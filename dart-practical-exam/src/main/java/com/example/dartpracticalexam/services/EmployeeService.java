package com.example.dartpracticalexam.services;

import com.example.dartpracticalexam.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void addEmployee(Employee employee);

}
