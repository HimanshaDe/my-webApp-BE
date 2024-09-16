package com.example.my_webApp.service.impl;

import com.example.my_webApp.dto.RequestDTOs.EmployeeRequestDTO;
import com.example.my_webApp.dto.ResponseDTO;
import com.example.my_webApp.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public ResponseDTO saveEmployee(EmployeeRequestDTO employeeRequestDTO) {
        return null;
    }
}
