package com.springboot.example.springbootdeepdive.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class AOPCheck {
    //aop does not work if you call method in construtor
//    public AOPCheck() {
//        AOPExcute();
//    }
    @Autowired
    Utility utility;
    @GetMapping("/aop")
    public String AOPExcute(){
        System.out.println("============AOPExcute");
        utility.Test("akhila",33);
        return "AOPExcute";
    }
}
