package com.example.springweb;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController 
public class HelloController {
    
    @GetMapping("/")
    public String home() {
        return "Spring Boot 실행 성공!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }
    
    
}
