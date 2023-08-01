package com.example.task1.controller;

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
    
    @PostMapping("/create")
    public Empmanagement saveEmployee(@RequestBody Empmanagement empmanagement) {
        Empmanagement empmanagement2 = employeeService.saveEmployee(empmanagement);
        return empmanagement2;
    }

      @GetMapping("/listOfEmployee")
     public List<Empmanagement> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    //  @PutMapping("/update/{id}")
    // public Empmanagement updateEmployee(@PathVariable Integer id, @RequestBody Empmanagement updatedEmployee) {
    //     return employeeService.updateEmployee(id, updatedEmployee);
    // }

    @PutMapping("/update/{id}")
    public ResponseEntity<Empmanagement> updateEmployee(@PathVariable Integer id, @RequestBody Empmanagement updateEmployee) {
        Empmanagement updated = employeeService.updateEmpmanagement(id, updateEmployee);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
public String deleteEmployee(@PathVariable Integer id) {
    employeeService.deleteEmployee(id);
    return "Employee with ID " + id + " has been deleted.";
}

}
