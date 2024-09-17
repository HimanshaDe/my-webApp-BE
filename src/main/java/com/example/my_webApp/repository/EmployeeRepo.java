package com.example.my_webApp.repository;

import com.example.my_webApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    Boolean existsByEmployeeNameIgnoreCase(String employeeName);
}
