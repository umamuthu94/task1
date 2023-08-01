package com.example.task1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.task1.model.Empmanagement;

public interface EmployeeRepo extends JpaRepository<Empmanagement,Integer> {
    
}
