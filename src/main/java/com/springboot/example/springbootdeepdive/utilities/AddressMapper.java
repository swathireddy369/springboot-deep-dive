package com.springboot.example.springbootdeepdive.utilities;

import com.springboot.example.springbootdeepdive.JPA.EmployeeAddress;
import com.springboot.example.springbootdeepdive.JPA.EmployeeAddressDTO;
import com.springboot.example.springbootdeepdive.JPA.EmployeeDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public EmployeeAddress toEntity(EmployeeDTO employeeDTO) {
    EmployeeAddress employeeAddress =new EmployeeAddress();
    employeeAddress.setStreet(employeeDTO.getEmployeeAddress().getStreet());
    employeeAddress.setCity(employeeDTO.getEmployeeAddress().getCity());
    employeeAddress.setState(employeeDTO.getEmployeeAddress().getState());
    return employeeAddress;
    }
    public EmployeeAddressDTO toDTO(EmployeeAddress employeeAddress) {
        EmployeeAddressDTO employeeAddressDTO = new EmployeeAddressDTO();
        employeeAddressDTO.setStreet(employeeAddress.getStreet());
        employeeAddressDTO.setCity(employeeAddress.getCity());
        employeeAddressDTO.setState(employeeAddress.getState());
        return employeeAddressDTO;
    }
}
