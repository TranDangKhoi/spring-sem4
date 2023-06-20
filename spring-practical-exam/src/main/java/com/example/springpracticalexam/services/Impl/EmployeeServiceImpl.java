package com.example.springpracticalexam.services.Impl;

import com.example.springpracticalexam.entities.Employee;
import com.example.springpracticalexam.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.example.springpracticalexam.repositories.EmployeeRepo;
import java.util.List;
import java.util.Optional;

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

    @Override
    public void deleteEmployee(Long id) throws Exception {
        Optional<Employee> employee = employeeRepo.findById(id);
        if(!employee.isPresent()) {
            throw new Exception("Employee's id is invalid");
        }
        employeeRepo.deleteById(id);
    }
}