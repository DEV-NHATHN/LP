package com.example.lp.model;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Employee() {
    }

    public Employee(long employee_code, String name, int age, String branch_code, boolean status, String address) {
        this.employee_code = employee_code;
        this.name = name;
        this.age = age;
        this.branch_code = branch_code;
        this.status = status;
        this.address = address;
    }

    public long getEmployee_code() {
        return employee_code;
    }

    public void setEmployee_code(long employee_code) {
        this.employee_code = employee_code;
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

    public String getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
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
