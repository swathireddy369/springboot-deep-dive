package com.springboot.example.springbootdeepdive.ConditionalOnProperty;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "sqlConnection",value="enabled",havingValue="true",matchIfMissing=false)
public class SqlConnection {
    public SqlConnection(){
        System.out.println("SqlConnection init");
    }
}
