package com.springboot.example.springbootdeepdive.scopes;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
//@Qualifier("Employee")
//@Component
//@Scope("application")
public class Employee implements User {
    public  Employee(){
        System.out.println("Employee initialized");
    }
    @PostConstruct
    public void init(){
        System.out.println("Employee initialized "+this.hashCode());
    }
    public void getEmployeeDetails(){
        System.out.println("i am a Employee");
    }

    @Override
    public String getName() {
        System.out.println("i am a employee");
        return "employee ";
    }
}
