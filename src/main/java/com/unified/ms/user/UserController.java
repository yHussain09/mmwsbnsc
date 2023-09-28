package com.unified.ms.user;

import com.unified.ms.post.Post;
import com.unified.ms.post.PostService;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final PostService postService;

    public UserController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping("")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public EntityModel<User> getUserById(@PathVariable int id) {
        User user = this.userService.getUserById(id);
        EntityModel<User> userEntityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
        userEntityModel.add(link.withRel("all-users"));
        return userEntityModel;
    }

    @PostMapping("")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
        User savedUser = this.userService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable int id) {
        this.userService.deleteUser(id);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/posts")
    public List<Post> getUserPostById(@PathVariable int id) {
        User user = this.userService.getUserById(id);
        return user.getPosts();
    }

    @PostMapping("/{id}/posts")
    public ResponseEntity<User> savePostByUserId(@PathVariable int id, @Valid @RequestBody Post post) {
        User user = this.userService.getUserById(id);
        post.setUser(user);
        Post savedPost = this.postService.savePost(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId()).toUri();

//        EntityModel<User> userEntityModel = EntityModel.of(user);
//        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
//        userEntityModel.add(link.withRel("all-users"));
        return ResponseEntity.created(location).build();
//        return userEntityModel;
    }
}
