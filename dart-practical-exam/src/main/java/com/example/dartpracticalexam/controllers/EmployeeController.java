package com.example.dartpracticalexam.controllers;

import com.example.dartpracticalexam.entity.Employee;
import com.example.dartpracticalexam.repositories.EmployeeRepo;
import com.example.dartpracticalexam.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class EmployeeController {
    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeRepo.save(employee);
        return ResponseEntity.ok(savedEmployee);
    }
}