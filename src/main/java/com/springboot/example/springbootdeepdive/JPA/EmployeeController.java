package com.springboot.example.springbootdeepdive.JPA;

import com.springboot.example.springbootdeepdive.scopes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeDTO employeeDTO;

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/post")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
       ResponseEntity<?> res=  employeeService.saveUser(employeeDTO);
        employeeService.get();
        return res;
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDTO employeeDTO,@PathVariable int id) {
        ResponseEntity<?> res=  employeeService.updateEmployee(employeeDTO,id);
        employeeService.get();
        return res;
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmpById(id);
    }
}
