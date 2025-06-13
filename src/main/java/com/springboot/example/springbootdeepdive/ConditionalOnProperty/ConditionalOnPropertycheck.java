package com.springboot.example.springbootdeepdive.ConditionalOnProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConditionalOnPropertycheck {
    @Autowired(required = true)
    SqlConnection sqlConnection;
    @Autowired(required = false)
    NoSqlConnection noSqlConnection;
    public ConditionalOnPropertycheck(){
        System.out.println("ConditionalOnPropertycheck init");
    }
}
