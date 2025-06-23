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
        employeeEntity.setId(employeeDTO.getId());
        return employeeEntity;
    }
    public EmployeeDTO toDTO(EmployeeEntity employeeEntity){
        EmployeeDTO employeeDTO=new EmployeeDTO();
        employeeDTO.setName(employeeEntity.getName());
        employeeDTO.setAge(employeeEntity.getAge());
        employeeDTO.setId(employeeEntity.getId());
        return employeeDTO;
    }
}
