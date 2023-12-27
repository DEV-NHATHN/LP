package com.example.lp.service;

import com.example.lp.dto.EmployeeDTO;
import com.example.lp.model.Employee;

import java.util.List;

public interface IEmployeeService {
public Employee add(Employee employee);

    public Employee update(long employee_code, EmployeeDTO employeeDTO);

    public boolean delete(long employee_code);

    public List<Employee> getList();

    public Employee getOne(long employee_code);

    public List<Employee> getEmployeesByBranchAndStatus(String branch_code, boolean status);

    public List<Employee> getEmployeesByStatus(boolean status);

    public List<Employee> getEmployeesByBranchAndGroup(String branch_code);
}
