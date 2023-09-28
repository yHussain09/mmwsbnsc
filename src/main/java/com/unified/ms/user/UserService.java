package com.unified.ms.user;

import com.unified.ms.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*public static List<User> userList = new ArrayList<>();
    public static int userId = 0;
    public UserService() {
        userList.add(new User(++userId, "User 1", LocalDate.now().minusYears(30)));
        userList.add(new User(++userId, "User 2", LocalDate.now().minusYears(25)));
        userList.add(new User(++userId, "User 3", LocalDate.now().minusYears(20)));
    }*/

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User getUserById(int id) {
//        Predicate<? super User> predicate = user -> user.getId().equals(id);
//        Optional<User> userOptional = this.getAllUsers().stream().filter(predicate).findFirst();
        Optional<User> userOptional = this.userRepository.findById(id);
        if(userOptional.isPresent()) {
            return userOptional.get();
        }
        throw new UserNotFoundException("id:" + id);
    }

//    public User findOne(int id) {
//        Predicate<? super User> predicate = user -> user.getId().equals(id);
//        return users.stream.filter(predicate).findFirst().get();
//    }

    public User saveUser(User user) {
//        user.setId(++userId);
//        userList.add(user);
        return this.saveUser(user);
    }

    public void deleteUser(int id) {
//        Predicate<? super User> predicate = user -> user.getId().equals(id);
//        userList.removeIf(predicate);
        this.userRepository.deleteById(id);
    }
}
