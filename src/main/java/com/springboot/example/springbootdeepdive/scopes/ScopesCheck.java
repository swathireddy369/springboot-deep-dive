package com.springboot.example.springbootdeepdive.scopes;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // 1 for entire IOC
@Scope("singleton")
public class ScopesCheck {

    //this is direclty depending on concrete classes so voileting the principle D
//    @Autowired
//    Student student;
//    @Autowired
//    Employee employee;


//    1 way
//    @Qualifier("Employee")
//    @Autowired
//    User employee;
//
//    @Qualifier("Student")
//    @Autowired
//    User student;


    @Autowired
    User user;


    public ScopesCheck(){
        System.out.println("-----------------ScopesCheck initialized------------ "+this.hashCode());
    }
    @PostConstruct
    public void init(){
//        System.out.println("After initialized"+student.hashCode()+" "+employee.hashCode()+" "+this.hashCode());
    }
    @GetMapping("/")
    public String getDetails(){
//        System.out.println("student initialized "+student.hashCode()+" "+employee.hashCode()+" "+this.hashCode());
        user.getName();
        return  "student details";
    }
    @GetMapping("/scope")
    public String getUserDetails(){
//        System.out.println("user initialized "+student.hashCode()+" "+employee.hashCode()+" "+this.hashCode());
        user.getName();
        return  "student details";
    }
}
