package com.springboot.example.springbootdeepdive.JPA;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Getter
@Setter
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Employee {
    String name;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    String email;
    String company;
    String role;
    int age;
    @JoinColumn(name="addressid")
    @OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    EmployeeAddress employeeAddress;
}