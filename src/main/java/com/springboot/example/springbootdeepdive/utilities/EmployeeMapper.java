package com.springboot.example.springbootdeepdive.utilities;

import com.springboot.example.springbootdeepdive.JPA.EmployeeDTO;
import com.springboot.example.springbootdeepdive.JPA.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee toEntity(EmployeeDTO employeeDTO){
        Employee employee =new Employee();
        employee.setName(employeeDTO.getName());
        employee.setAge(employeeDTO.getAge());
        employee.setId(employeeDTO.getId());
        employee.setEmail(employeeDTO.getEmail());
        employee.setRole(employeeDTO.getRole());
        employee.setCompany(employeeDTO.getCompany());

        return employee;
    }
    public EmployeeDTO toDTO(Employee employee){
        EmployeeDTO employeeDTO=new EmployeeDTO();
        employeeDTO.setName(employee.getName());
        employeeDTO.setAge(employee.getAge());
        employeeDTO.setId(employee.getId());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setRole(employee.getRole());
        employeeDTO.setCompany(employee.getCompany());
        return employeeDTO;
    }
}
