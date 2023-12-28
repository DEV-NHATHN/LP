package com.example.lp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {

    private String name;
    private int age;
    private String branch_code;
    private boolean status;
    private String address;

    // Getters and setters

}
