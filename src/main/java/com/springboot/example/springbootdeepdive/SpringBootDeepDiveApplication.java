package com.springboot.example.springbootdeepdive;

import jakarta.annotation.PreDestroy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAsync
@EnableTransactionManagement
@EnableCaching
public class SpringBootDeepDiveApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context= SpringApplication.run(SpringBootDeepDiveApplication.class, args);
//        context.close();

        System.out.println("Just started");
    }
    @PreDestroy
    public  String preDestroyCheck(){
        System.out.println("preDestroyCheck");
        return "PreDestroy";
    }

}
