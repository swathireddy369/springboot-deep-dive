package com.springboot.example.springbootdeepdive.JPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class EmployeeAddress {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;
    public String street;
    public String city;
    public String state;
}
