package com.javatechie.crud.example.repository;

import com.javatechie.crud.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import com.javatechie.crud.example.dto.DeptEmpDto;
import com.javatechie.crud.example.entity.Employee;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
//    Employee findByName(String name);

    @Query("SELECT new com.javatechie.crud.example.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
            + "FROM Department d INNER JOIN d.employees e")
    List<DeptEmpDto> fetchEmpDeptDataInnerJoin();

    @Query("SELECT new com.javatechie.crud.example.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
            + "FROM Department d, Employee e")
    List<DeptEmpDto> fetchEmpDeptDataCrossJoin();

}

