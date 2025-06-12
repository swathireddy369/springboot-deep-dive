package com.springboot.example.springbootdeepdive.Beans;

import com.springboot.example.springbootdeepdive.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentChecking {
    @Autowired
    User user;
    public ComponentChecking(){
        System.out.println("ComponentChecking initilized");
    }
}
