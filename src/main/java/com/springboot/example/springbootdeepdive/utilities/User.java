package com.springboot.example.springbootdeepdive.utilities;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Lazy;

@Lazy
public class User {
  public String name;
   public  String password;

        public User(){
        System.out.println("User created");
    }
    public User(String name,String password){
        this.name=name;
        this.password=password;
        System.out.println("User created with args "+name+" "+password);
    }
    @PostConstruct
    public String postBeanCreationCheck(){
        System.out.println("postBeanCreationCheck");
          return "PostConstruct";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
