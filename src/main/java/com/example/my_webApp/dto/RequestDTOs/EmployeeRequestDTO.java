package com.example.my_webApp.dto.RequestDTOs;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDTO {
    private Integer employeeId;
    private String employeeName;
}
