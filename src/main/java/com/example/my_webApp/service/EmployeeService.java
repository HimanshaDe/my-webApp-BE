package com.example.my_webApp.service;

import com.example.my_webApp.dto.RequestDTOs.EmployeeRequestDTO;
import com.example.my_webApp.dto.ResponseDTO;

public interface EmployeeService {
    ResponseDTO saveEmployee(EmployeeRequestDTO employeeRequestDTO);

    ResponseDTO getEmployeeList();

    ResponseDTO updateEmployee(EmployeeRequestDTO employeeRequestDTO, Integer id);
}
