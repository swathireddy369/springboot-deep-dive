package com.springboot.example.springbootdeepdive.utilities;

import com.springboot.example.springbootdeepdive.JPA.EmployeeDTO;
import com.springboot.example.springbootdeepdive.JPA.EmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeEntity toEntity(EmployeeDTO employeeDTO){
        EmployeeEntity employeeEntity=new EmployeeEntity();
        employeeEntity.setName(employeeDTO.getName());
        employeeEntity.setAge(employeeDTO.getAge());
        return employeeEntity;
    }
    public EmployeeDTO toDTO(EmployeeEntity employeeEntity){
        EmployeeDTO employeeDTO=new EmployeeDTO();
        employeeDTO.setName(employeeEntity.getName());
        employeeDTO.setAge(employeeEntity.getAge());
        return employeeDTO;
    }
}
