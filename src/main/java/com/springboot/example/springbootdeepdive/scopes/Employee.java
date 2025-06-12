package com.springboot.example.springbootdeepdive.scopes;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Employee {
    public  Employee(){
        System.out.println("Employee initialized");
    }
    @PostConstruct
    public void init(){
        System.out.println("Employee initialized "+this.hashCode());
    }
}
