package com.example.springpracticalexam.services;

import com.example.springpracticalexam.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void addEmployee(Employee employee);

    void deleteEmployee(Long id) throws Exception;
}
