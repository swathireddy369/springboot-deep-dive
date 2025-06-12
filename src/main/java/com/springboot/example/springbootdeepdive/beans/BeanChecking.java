package com.springboot.example.springbootdeepdive.beans;

import com.springboot.example.springbootdeepdive.utility.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanChecking {
    @Bean
   public String BeanCheckingwithBean(){
       System.out.println("BeanChecking initilized-1");
       return "HelloBean";
   }
   @Bean
   public User BeanCheckingtest(){
       System.out.println("BeanChecking initilized-2");
       return new User("defaultname","defaultPassword");
   }

}
