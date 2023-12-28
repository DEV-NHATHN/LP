package com.example.lp.service;

import com.example.lp.entity.Employee;
import com.example.lp.model.CreateEmployeeRequest;

import java.util.List;

public interface IEmployeeService {
    public Employee add(CreateEmployeeRequest request);

    public Employee update(long employeeCode, CreateEmployeeRequest request);

    public boolean delete(long employeeCode);

    public List<Employee> getList();

    public Employee getOne(long employeeCode);

    public List<Employee> getEmployeesByBranchAndStatus(String branchCode, boolean status);

    public List<Employee> getEmployeesByStatus(boolean status);

    public List<Employee> getEmployeesByBranchAndGroup(String branchCode);
}
