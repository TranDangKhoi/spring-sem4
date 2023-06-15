package com.example.springdemo.service.Impl;

import com.example.springdemo.entity.StudentEntity;
import com.example.springdemo.repository.StudentRepo;
import com.example.springdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public void addStudent(StudentEntity student) {
        if(ObjectUtils.isEmpty(student)){
            throw new NullPointerException("Student data is invalid");
        }
        studentRepo.save(student);
    }

    @Override
    public void deleteStudent(Long id) throws Exception {
        Optional<StudentEntity> student = studentRepo.findById(id);
        if(!student.isPresent()) {
            throw new Exception("Student id is invalid");
        }
        studentRepo.deleteById(id);
    }
}
