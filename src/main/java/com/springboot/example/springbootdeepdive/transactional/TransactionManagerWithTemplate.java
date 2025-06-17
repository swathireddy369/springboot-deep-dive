package com.springboot.example.springbootdeepdive.transactional;

import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TransactionManagerWithTemplate {
    TransactionTemplate template;
    public TransactionManagerWithTemplate(TransactionTemplate template){
        this.template=template;
    }

    @GetMapping("/temp")
    public void getUser(){
        TransactionCallback<TransactionStatus> callback=(TransactionStatus Status)->{
            System.out.println("in transaction temp");
            return Status;
        };
        TransactionStatus status=template.execute(callback);
    }
}
