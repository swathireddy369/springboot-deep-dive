package com.springboot.example.springbootdeepdive;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FirstController {
    @RequestMapping(value = "/api/{password}",method = RequestMethod.GET)
    @ResponseBody
    public String getUserDetails(@PathVariable(name="password") String password) {
        System.out.println("getUserDetails called "+password);
        return "User details " + password;
    }
}
