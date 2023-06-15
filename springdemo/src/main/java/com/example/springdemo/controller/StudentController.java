package com.example.springdemo.controller;

import com.example.springdemo.entity.StudentEntity;
import com.example.springdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/")
    public String getAllStudents(Model model){
        model.addAttribute("allStudent", studentService.getAllStudents());
        model.addAttribute("studentEntity", new StudentEntity());
        return "index";
    }
    @PostMapping("/create-student")
    public String addStudent(@ModelAttribute(value = "studentEntity")StudentEntity studentEntity){
        studentService.addStudent(studentEntity);
        return "redirect:/";
    }

    @GetMapping("/delete-student/{id}")
    public String deleteStudentById(@PathVariable(value = "id") Long id) throws Exception{
        studentService.deleteStudent(id);
        return "redirect:/";
    }
}
