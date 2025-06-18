package com.springboot.example.springbootdeepdive.customIntercepters;

import com.springboot.example.springbootdeepdive.annotations.MyCustomAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BeforeController {


    @MyCustomAnnotation
    @GetMapping("/get")
    public String get(){
        System.out.println("get user details");
        return "contoller";
    }
}
