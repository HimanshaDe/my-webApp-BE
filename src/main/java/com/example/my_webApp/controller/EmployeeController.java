package com.example.my_webApp.controller;

import com.example.my_webApp.dto.RequestDTOs.EmployeeRequestDTO;
import com.example.my_webApp.dto.ResponseDTO;
import com.example.my_webApp.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/my-web-app/employee")
@RestController
@Slf4j
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<ResponseDTO<T>> saveEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        log.info("EmployeeController.saveEmployee() method accessed..");
        ResponseDTO<T> responseDTO = employeeService.saveEmployee(employeeRequestDTO);
        return ResponseEntity.status(responseDTO.getStatus()).body(responseDTO);
    }
}
