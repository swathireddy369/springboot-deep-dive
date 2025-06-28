package com.springboot.example.springbootdeepdive.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress,Integer> {
}
