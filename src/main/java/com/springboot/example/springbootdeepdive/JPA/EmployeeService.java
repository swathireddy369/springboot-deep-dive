package com.springboot.example.springbootdeepdive.JPA;
import java.util.*;

import com.springboot.example.springbootdeepdive.utilities.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeMapper employeeMapper;
    public ResponseEntity<?> saveUser(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity=employeeMapper.toEntity(employeeDTO);
        employeeRepository.save(employeeEntity);
         return new ResponseEntity<>("Employee created successfully",HttpStatus.OK);
    }
    public ResponseEntity<EmployeeDTO> getEmpById(Integer id) {
        EmployeeEntity emp=employeeRepository.getReferenceById(id);
        EmployeeDTO resultSet=employeeMapper.toDTO(emp);
        return new ResponseEntity<>(resultSet,HttpStatus.OK);
    }


    public void get() {
        employeeRepository.findAll();
    }

    public ResponseEntity<?> updateEmployee(EmployeeDTO employeeDTO,int id) {
        employeeRepository.save(employeeMapper.toEntity(employeeDTO));
        return new ResponseEntity<>("Employee updated successfully",HttpStatus.OK);
    }
}
