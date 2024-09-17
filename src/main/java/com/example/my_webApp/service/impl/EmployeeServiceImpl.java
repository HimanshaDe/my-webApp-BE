package com.example.my_webApp.service.impl;

import com.example.my_webApp.dto.RequestDTOs.EmployeeRequestDTO;
import com.example.my_webApp.dto.ResponseDTO;
import com.example.my_webApp.model.Employee;
import com.example.my_webApp.repository.EmployeeRepo;
import com.example.my_webApp.service.EmployeeService;
import com.example.my_webApp.util.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public ResponseDTO saveEmployee(EmployeeRequestDTO employeeRequestDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        try {
            Boolean isEmployeeExists = employeeRepo.existsByEmployeeNameIgnoreCase(employeeRequestDTO.getEmployeeName());
            if (isEmployeeExists) {
                return ResponseUtils.handleConflictResponse(responseDTO, "Employee already exists");
            }
            Employee employee = new Employee();
            employee.setEmployeeName(employeeRequestDTO.getEmployeeName().toLowerCase());
            employeeRepo.save(employee);
            return ResponseUtils.handleOkResponse(responseDTO, responseDTO,"Employee created successfully!");
        } catch (Exception e) {
            return ResponseUtils.handleErrorResponse(responseDTO, "An error occurred while saving the employee.");
        }
    }

    @Override
    public ResponseDTO getEmployeeList() {
        ResponseDTO responseDTO = new ResponseDTO();
        List<Employee> employeeList = employeeRepo.findAll();
        if(!employeeList.isEmpty()){
            responseDTO.setData(employeeList);
            ResponseUtils.handleOkResponse(responseDTO,employeeList,"Employee list retrieved successfully");
        }else {
            return ResponseUtils.handleNotFoundResponse(responseDTO, "Employee list not found!");
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO updateEmployee(EmployeeRequestDTO employeeRequestDTO, Integer id) {
        ResponseDTO responseDTO = new ResponseDTO();
        Optional<Employee> employeeOptional = employeeRepo.findById(id);

        if(employeeOptional.isPresent()){
            Employee currentEmployee = employeeOptional.get();
            currentEmployee.setEmployeeName(employeeRequestDTO.getEmployeeName());
            employeeRepo.save(currentEmployee);
            ResponseUtils.handleOkResponse(responseDTO,currentEmployee,"Employee Updated Successfully!");
        }else {
            ResponseUtils.handleNotFoundResponse(responseDTO,"Employee Not Found!");
        }
        return responseDTO;
    }

}
