package com.example.lp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_code")
    private long employee_code;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "branch_code")
    private String branch_code;

    @Column(name = "status")
    private boolean status;

    @Column(name = "address")
    private String address;

    @Column(name = "secret_key")
    private String secret_key;

    public Employee(String name, int age, String branch_code, boolean status, String address, String secret_key) {
        this.name = name;
        this.age = age;
        this.branch_code = branch_code;
        this.status = status;
        this.address = address;
        this.secret_key = secret_key;
    }
}