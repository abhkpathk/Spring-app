package com.javatechie.crud.example.service;

import com.javatechie.crud.example.entity.Employee;
import com.javatechie.crud.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(Employee emp) {
        return repository.save(emp);
    }

    
    public Employee getEmployeeById(int id) {
    	return repository.findById(id).orElse(null);
    }

    
//    public List<Employee> saveEmployees(List<Employee> emps) {
//        return repository.saveAll(emps);
//    }

    public List<Employee> getEmployees() {
        return repository.findAll();
    }



    public String deleteEmployee(int id) {
        repository.deleteById(id);
        return "Employee removed !! " + id;
    }

    public Employee updateEmployee(Employee emp) {
        Employee existingEmployee = repository.findById(emp.getId()).orElse(null);
        existingEmployee.setEmpName(emp.getEmpName());
        existingEmployee.setEmpId(emp.getEmpId());
        existingEmployee.setSalary(emp.getSalary());
        return repository.save(existingEmployee);
    }


}
