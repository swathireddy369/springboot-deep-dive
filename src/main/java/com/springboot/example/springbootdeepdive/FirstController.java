package com.springboot.example.springbootdeepdive;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FirstController {
    @RequestMapping(value = "/api",method = RequestMethod.GET)
    @ResponseBody
    public String getUserDetails() {
        System.out.println("getUserDetails called ");
        return "User details ";
    }
    @RequestMapping(value = "/api/path/{password}",method = RequestMethod.GET)
    @ResponseBody
    public String pathVarCheck(@PathVariable(name="password") String password) {
        System.out.println("PathVariable called "+password);
        return "PathVariable " + password;
    }
    @RequestMapping(value = "/api/params",method = RequestMethod.GET)
    @ResponseBody
    public String requestParamCheck(@RequestParam("name") String name) {
        System.out.println("RequestParam called "+name);
        return "RequestParam details " + name;
    }

    @RequestMapping(path="/api/requestBody",method=RequestMethod.POST)
    @ResponseBody
    public String requestCheck(@RequestBody User user){
        User u = new User();
        u.setName(user.name);
        System.out.println("requestBody called"+u.getName() );
        return "user with request check "+u.getName();
    }
    @RequestMapping(path="/api/responseEntityCheck",method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity checkResponseBody(@RequestBody User user){
        User uObj = new User();
        uObj.setName(user.name);
        return ResponseEntity.status(200).body(uObj.name);
    }
}
