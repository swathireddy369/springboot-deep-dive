package com.springboot.example.springbootdeepdive;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FirstRestController {
    @GetMapping("/getUser")
    public String getUserDetails() {
        System.out.println("getUserDetails called");
        return "User details";
    }
}
