package com.springboot.example.springbootdeepdive.aop;

import org.springframework.stereotype.Component;

@Component
public  class Utility {
    public  void Test(String name, int age){
        System.out.println(name+" "+age);
    }
}
