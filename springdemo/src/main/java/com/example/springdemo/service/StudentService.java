package com.example.springdemo.service;

import com.example.springdemo.entity.StudentEntity;

import java.util.List;

public interface StudentService {

    List<StudentEntity> getAllStudents();

    void addStudent(StudentEntity student);

    void deleteStudent(Long id) throws Exception;
}
