package com.springboot.example.springbootdeepdive.asyncanno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AsyncService {

    @Async
    public void get(){
        try{
            Thread.sleep(1000);
            System.out.println("async    "+Thread.currentThread().getName());
        }catch (InterruptedException e){

        }

    }

}
