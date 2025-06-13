package com.springboot.example.springbootdeepdive.scopes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurationfile {
    @Bean
    public User getUser(@Value("${isStudent}") boolean isTrue){
        System.out.println(isTrue);
        if(isTrue){
            return new Student();
        }else {
            return  new Employee();
        }
    }
}
