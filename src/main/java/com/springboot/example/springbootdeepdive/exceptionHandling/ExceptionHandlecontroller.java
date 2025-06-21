package com.springboot.example.springbootdeepdive.exceptionHandling;

import com.springboot.example.springbootdeepdive.exceptionHandling.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
public class ExceptionHandlecontroller {
     public static final Map<Integer,User> users=new HashMap<>();
     static{
         users.put(1,new User(1,"SwathiRaji"));
     }



//    @GetMapping("/get-user/{id}")
//    public User getUser(@PathVariable Integer id){
//          if(id == null){
//              throw new IllegalArgumentException("id is null");
//          }
//          if(!users.containsKey(id)){
//              throw new UserNotFoundException("user not found");
//          }
//          return users.get(id);
//    }
    @GetMapping("/get-user/{id}")
    public ResponseEntity<?> getUserWithResponseEntiy(@PathVariable Integer id){
        if(id == null){
            throw new IllegalArgumentException("id is null");
        }
        if(!users.containsKey(id)){
            throw new UserNotFoundException("user not found");
        }
        return new ResponseEntity<>(
                Map.of("userDeatils",users.get(id)),HttpStatus.ACCEPTED);
    }
//    @ExceptionHandler(UserNotFoundException.class)
//    public ResponseEntity<?> handleException(UserNotFoundException e){
////
//        ErrorResponse err=new ErrorResponse("i am hanldeing",HttpStatus.NOT_FOUND.value());
////        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
//        return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
//    }
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<?> handleException_2(IllegalArgumentException e){
//         return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("i am not found");
//    }
//


}
