package com.springboot.example.springbootdeepdive.JPA;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
@Getter
@Setter
@Component
public class EmployeeDTO {
    String name;
    int age;
    int id;
}
