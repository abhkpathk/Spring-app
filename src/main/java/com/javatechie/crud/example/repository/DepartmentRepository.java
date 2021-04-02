package com.javatechie.crud.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javatechie.crud.example.dto.DeptEmpDto;
import com.javatechie.crud.example.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query("SELECT new com.javatechie.crud.example.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
            + "FROM Department d LEFT JOIN d.employees e")
    List<DeptEmpDto> fetchEmpDeptDataLeftJoin();

    @Query("SELECT new com.javatechie.crud.example.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
            + "FROM Department d RIGHT JOIN d.employees e")
    List<DeptEmpDto> fetchEmpDeptDataRightJoin();

}
