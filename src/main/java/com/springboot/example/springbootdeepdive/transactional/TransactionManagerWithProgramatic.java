package com.springboot.example.springbootdeepdive.transactional;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TransactionManagerWithProgramatic {
    //autowiring
    PlatformTransactionManager userTransactionManager;

    public TransactionManagerWithProgramatic(PlatformTransactionManager userTransactionManager){
        this.userTransactionManager=userTransactionManager;
    }
    @GetMapping("/prog")
    public void getUser(){
        TransactionStatus status=userTransactionManager.getTransaction(null);
        try{
            System.out.println("in transaction");
            userTransactionManager.commit(status);
        }catch (Exception e){
          userTransactionManager.rollback(status);
        }
        System.out.println("get user");
    }
}
