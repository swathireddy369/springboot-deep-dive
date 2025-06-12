package com.springboot.example.springbootdeepdive.dependecyInjectionTypes;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DependencyInjectionTypesCheck {
    //Dependency inversion
    WiredKeyBoard  wiredKeyBoard = new WiredKeyBoard();//this breaks solid d principle modules should depend on abstraction rather than concreteclasses
//    to avoid this we use dependency injection

    //field Injection
//    @Autowired
//    Keyboard  keyboard;

    //constructor injection only initliated first time and keeping final gives more realiability

     final Keyboard  keyboard;
      @Autowired
    public DependencyInjectionTypesCheck(Keyboard keyboard) {
        System.out.println("dependecny created");
        this.keyboard = keyboard;
    }

    //setter injection
//     @Autowired
//    public void settterInjection(Keyboard keyboard) {
//        this.keyboard=keyboard;
//    }

    @PostConstruct //we can reinject any time after first initialization
    public void postCreated(){
        keyboard.getData();
    }

}
