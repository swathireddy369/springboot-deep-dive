package com.springboot.example.springbootdeepdive.profile;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("qa")
public class ProfileCheck {
    @Value("${nameOfUser}")
    String username;
    @Value("${password}")
    String password;
    @PostConstruct
    public void init(){
        System.out.println("Username : " + username);
        System.out.println("Password : " + password);
    }
}
