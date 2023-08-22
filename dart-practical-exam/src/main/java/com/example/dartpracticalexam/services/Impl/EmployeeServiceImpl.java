package com.example.dartpracticalexam.services.Impl;

import com.example.dartpracticalexam.entity.Employee;
import com.example.dartpracticalexam.repositories.EmployeeRepo;
import com.example.dartpracticalexam.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public void addEmployee(Employee employee) {
        if(ObjectUtils.isEmpty(employee)){
            throw new NullPointerException("Student data is invalid");
        }
        employeeRepo.save(employee);
    }

}
