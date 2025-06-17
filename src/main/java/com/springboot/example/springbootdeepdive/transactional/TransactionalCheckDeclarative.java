package com.springboot.example.springbootdeepdive.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis")
public class TransactionalCheckDeclarative {
     @Autowired
     User user;
    @GetMapping("/trans")
    public void getTransactionalPrint(){
        user.updateUser();
        System.out.println("**************************get transactional print*********************");
    }

}
