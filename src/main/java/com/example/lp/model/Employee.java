package com.example.lp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
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
    public Employee() {
    }

    public Employee(long employeeCode, String name, int age, String branchCode, boolean status, String address) {
        this.employeeCode = employeeCode;
        this.name = name;
        this.age = age;
        this.branchCode = branchCode;
        this.status = status;
        this.address = address;
    }

    // Getters and setters

    public long getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(long employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}