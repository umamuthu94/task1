package com.example.task1.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.task1.model.Empmanagement;
import com.example.task1.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    
    // @PostMapping("/create")
    // public Empmanagement saveEmployee(@RequestBody Empmanagement empmanagement) {
    //     Empmanagement empmanagement2 = employeeService.saveEmployee(empmanagement);
    //     return empmanagement2;
    // }

    @PostMapping("/create")
public Empmanagement saveEmployee(@RequestBody Empmanagement empmanagement) {
    try {
        Empmanagement empmanagement2 = employeeService.saveEmployee(empmanagement);
        return empmanagement2;
    } catch (Exception e) {
        // Handle the exception here (e.g., log the error, return a specific error response, etc.)
        e.printStackTrace(); // Print the stack trace for debugging purposes
        return null; // Or any other appropriate error response
    }
}

    //   @GetMapping("/listOfEmployee")
    //  public List<Empmanagement> getAllEmployees() {
    //     return employeeService.getAllEmployees();
    // }


    @GetMapping("/listOfEmployee")
public List<Empmanagement> getAllEmployees() {
    try {
        return employeeService.getAllEmployees();
    } catch (Exception e) {
        // Handle the exception here (e.g., log the error, return a specific error response, etc.)
        e.printStackTrace(); // Print the stack trace for debugging purposes
        return Collections.emptyList(); // Or any other appropriate error response
    }
}

    //  @PutMapping("/update/{id}")
    // public Empmanagement updateEmployee(@PathVariable Integer id, @RequestBody Empmanagement updatedEmployee) {
    //     return employeeService.updateEmployee(id, updatedEmployee);
    // }

    // @PutMapping("/update/{id}")
    // public ResponseEntity<Empmanagement> updateEmployee(@PathVariable Integer id, @RequestBody Empmanagement updateEmployee) {
    //     Empmanagement updated = employeeService.updateEmpmanagement(id, updateEmployee);
    //     return ResponseEntity.ok(updated);
    // }

    @PutMapping("/update/{id}")
public ResponseEntity<Empmanagement> updateEmployee(@PathVariable Integer id, @RequestBody Empmanagement updateEmployee) {
    Empmanagement updated = employeeService.updateEmpmanagement(id, updateEmployee);

    if (updated != null) {
        // Employee updated successfully
        return ResponseEntity.ok(updated);
    } else {
        // Employee with the specified ID not found
        return ResponseEntity.notFound().build();
    }
}

//     @DeleteMapping("/delete/{id}")
// public String deleteEmployee(@PathVariable Integer id) {
//     employeeService.deleteEmployee(id);
//     return "Employee with ID " + id + " has been deleted.";
// }

@DeleteMapping("/delete/{id}")
public String deleteEmployee(@PathVariable Integer id) {
    try {
        employeeService.deleteEmployee(id);
        return "Employee with ID " + id + " has been deleted.";
    } catch (Exception e) {
        // Handle the exception here (e.g., log the error, return a specific error response, etc.)
        e.printStackTrace(); // Print the stack trace for debugging purposes
        return "Error deleting employee with ID " + id + ".";
    }
}

}
