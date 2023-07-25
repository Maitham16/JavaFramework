package com.example.mcv.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.mcv.Model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    
}
