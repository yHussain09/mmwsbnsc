package com.unified.ms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/app")
public class WebMvcController {

    public static Map<String, String> pages = new HashMap<>();

    public WebMvcController() {
        pages.put("home", "home-page");
        pages.put("error", "error-page");
        pages.put("user", "user-page");
    }

    @GetMapping("")
    public String getPageById() {
        return "home-page";
    }

    @GetMapping("/{pageId}")
    public String getPageById(@PathVariable String pageId) {
        return pages.get(pageId);
    }
}
