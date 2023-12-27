package com.example.lp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_code")
    private long employeeCode;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "branch_code")
    private String branchCode;

    @Column(name = "status")
    private boolean status;

    @Column(name = "address")
    private String address;

    // Constructors, getters, setters, and other methods...

    // Constructors
    public EmployeeEntity() {
    }

    public EmployeeEntity(String name, int age, String branchCode, boolean status, String address) {
        this.name = name;
        this.age = age;
        this.branchCode = branchCode;
        this.status = status;
        this.address = address;
    }

    // Getters and setters

}
