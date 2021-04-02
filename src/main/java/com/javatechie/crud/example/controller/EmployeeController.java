package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entity.Employee;
import com.javatechie.crud.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee emp) {
        return service.saveEmployee(emp);
    }

    @GetMapping("/employeeById/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees() {
        return service.getEmployees();
        
        
    }
        
        @PutMapping("/update")
        public Employee updateEmlpoyee(@RequestBody Employee emp) {
            return service.updateEmployee(emp);
        }
        
        @DeleteMapping("/delete/{id}")
        public String deleteEmployee(@PathVariable int id) {
            return service.deleteEmployee(id);
        }

}
