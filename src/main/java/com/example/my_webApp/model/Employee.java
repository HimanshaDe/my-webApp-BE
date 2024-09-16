package com.example.my_webApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="employee")
public class Employee {

    @Id
    @GeneratedValue()
    @Column
    private Integer employeeId;

    @Column(name="employee_name")
    private String employeeName;
}
