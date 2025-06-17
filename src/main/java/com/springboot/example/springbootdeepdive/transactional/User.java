package com.springboot.example.springbootdeepdive.transactional;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Component
public class User {

    @Transactional(transactionManager = "userTransactionManagerWithDataSource")
    public void updateUser(){
        System.out.println("update user");
    }
    @Transactional(transactionManager = "userTransactionManagerWithJDBC")
    public void updateUser1(){
        System.out.println("update user");
    }

}
