package com.springboot.example.springbootdeepdive.scopes;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
//@Qualifier("Student")
//@Component
//@Scope("singleton")
public class Student implements User {
    public   Student(){
        System.out.println("student initialized");
    }
    @PostConstruct
    public void init(){
        System.out.println("student initialized "+this.hashCode());
    }
    public void getStudentDetails(){
        System.out.println("i am a student");
    }


    @Override
    public String getName() {
        System.out.println("i am a student");
        return "student ";
    }
}
