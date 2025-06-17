package com.springboot.example.springbootdeepdive.asyncanno;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncCheck {
    @Autowired
    AsyncService asyncS;

    @GetMapping("/async")
    public void Asyncmethodcall(){
        System.out.println("first  "+Thread.currentThread().getName());
        asyncS.get();
    }

}
