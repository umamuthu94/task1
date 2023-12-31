package com.example.task1.service;

import java.util.List;
// import java.util.NoSuchElementException;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task1.model.Empmanagement;
import com.example.task1.repo.EmployeeRepo;



@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public Empmanagement saveEmployee(Empmanagement empmanagement) {
        Empmanagement empmanagement1 =employeeRepo.save(empmanagement);
        return empmanagement1;
    }

    public List<Empmanagement> getAllEmployees() {
        return employeeRepo.findAll();
   }

   public void deleteEmployee(Integer id) {
    employeeRepo.deleteById(id);
}

   public Empmanagement updateEmpmanagement(Integer id,Empmanagement empmanagement) {
    Empmanagement updateEmpmanagement = employeeRepo.findById(id).get();
    updateEmpmanagement.setName(empmanagement.getName());
    return employeeRepo.save(updateEmpmanagement);
   }

public Empmanagement updateEmployee(Integer id, Empmanagement updatedEmployee) {
    return null;
}

// public Empmanagement updateEmpmanagement(Integer id, Empmanagement empmanagement) {
//         Empmanagement existingEmployee = employeeRepo.findById(id)
//                 .orElseThrow(() -> new NoSuchElementException("Employee with ID " + id + " not found"));

//         existingEmployee.setName(empmanagement.getName());
//         // Update other fields as needed

//         return employeeRepo.save(existingEmployee);
//     }



}
