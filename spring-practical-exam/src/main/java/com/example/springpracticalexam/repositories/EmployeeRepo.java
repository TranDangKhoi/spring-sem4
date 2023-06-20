package com.example.springpracticalexam.repositories;

import com.example.springpracticalexam.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
