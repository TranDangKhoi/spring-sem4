package com.example.springpracticalexam.controllers;

import com.example.springpracticalexam.entities.Employee;
import com.example.springpracticalexam.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String getAllStudents(Model model){
        model.addAttribute("allEmployee", employeeService.getAllEmployees());
        model.addAttribute("employeeEntity", new Employee());
        return "index";
    }
    @PostMapping("/create-employee")
    public String addStudent(@ModelAttribute(value = "studentEntity")Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/delete-employee/{id}")
    public String deleteStudentById(@PathVariable(value = "id") Long id) throws Exception{
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
