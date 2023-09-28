package com.unified.ms;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    private MessageSource messageSource;

    public TestController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(path = "")
    public String getTest() {
        return "server is up and running...";
    }

    @GetMapping(path = "/message")
    public String getMessage() {
        return this.messageSource.getMessage("good.morning", null, "Default Message", LocaleContextHolder.getLocale());
    }
}
