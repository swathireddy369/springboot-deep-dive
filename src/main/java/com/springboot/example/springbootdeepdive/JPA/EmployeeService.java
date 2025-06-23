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
    public ResponseEntity<?> getEmpById(Integer id) {
     Optional<EmployeeEntity> emp=employeeRepository.findById(id);
     if(emp.isPresent()){
        EmployeeDTO resultSet=employeeMapper.toDTO(emp.get());
        return new ResponseEntity<>(resultSet,HttpStatus.OK);
     }
     return new ResponseEntity<>("Employee Not Found With Given Id",HttpStatus.NOT_FOUND);
    }


    public void get() {
        employeeRepository.findAll();
    }
    public ResponseEntity<?> updateEmployee(EmployeeDTO employeeDTO,int id) {
        employeeRepository.save(employeeMapper.toEntity(employeeDTO));
        return new ResponseEntity<>("Employee updated successfully",HttpStatus.OK);
    }

    public ResponseEntity<?> updateEmployeeById(EmployeeDTO employeeDTO, int id) {
        //get employee by id
        Optional<EmployeeEntity> emp=employeeRepository.findById(id);
        if(emp.isPresent()){
            EmployeeEntity empEntityObj=emp.get();
            empEntityObj.setName(employeeDTO.getName());
            empEntityObj.setAge(employeeDTO.getAge());
            employeeRepository.save(empEntityObj);
            return new ResponseEntity<>("Employee Updated Successfully",HttpStatus.OK);
        }else{
            System.out.println("Employee Not Found with Given Id"+id);
            return new ResponseEntity<>("No Employee Found",HttpStatus.BAD_REQUEST);
        }

    }
}
