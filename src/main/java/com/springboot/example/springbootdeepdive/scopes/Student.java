package com.springboot.example.springbootdeepdive.scopes;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@Scope("singleton")
public class Student {
    public   Student(){
        System.out.println("student initialized");
    }
    @PostConstruct
    public void init(){
        System.out.println("student initialized "+this.hashCode());
    }


}
