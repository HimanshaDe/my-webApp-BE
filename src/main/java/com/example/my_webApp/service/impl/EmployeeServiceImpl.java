package com.example.my_webApp.service.impl;

import com.example.my_webApp.dto.RequestDTOs.EmployeeRequestDTO;
import com.example.my_webApp.dto.ResponseDTO;
import com.example.my_webApp.model.Employee;
import com.example.my_webApp.repository.EmployeeRepo;
import com.example.my_webApp.service.EmployeeService;
import com.example.my_webApp.util.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public ResponseDTO saveEmployee(EmployeeRequestDTO employeeRequestDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        try {
            // Check if the employee already exists
            Boolean isEmployeeExists = employeeRepo.existsByEmployeeNameIgnoreCase(employeeRequestDTO.getEmployeeName());

            if (isEmployeeExists) {
                // Handle conflict response if the employee already exists
                return ResponseUtils.handleConflictResponse(responseDTO, "Employee already exists");
            }

            // Create and save a new employee if it doesn't exist
            Employee employee = new Employee();
            employee.setEmployeeName(employeeRequestDTO.getEmployeeName());
            employeeRepo.save(employee);

            // Handle success response after saving the employee
            return ResponseUtils.handleOkResponse(responseDTO, "Employee created successfully!");

        } catch (Exception e) {
            // Handle any unexpected errors
            return ResponseUtils.handleErrorResponse(responseDTO, "An error occurred while saving the employee.");
        }
    }

}
