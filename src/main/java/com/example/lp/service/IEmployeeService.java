package com.example.lp.service;

import com.example.lp.entity.Employee;
import com.example.lp.model.CreateEmployeeRequest;
import com.example.lp.model.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {
    public Employee add(CreateEmployeeRequest request);

    public Employee update(long employeeCode, CreateEmployeeRequest request);

    public boolean delete(long employeeCode);

    public List<EmployeeDTO> getList();

    public EmployeeDTO getOne(long employeeCode);

    public List<EmployeeDTO> getEmployeesByBranchAndStatus(String branchCode, boolean status);

    public List<EmployeeDTO> getEmployeesByStatus(boolean status);

    public List<EmployeeDTO> getEmployeesByBranchAndGroup(String branchCode);
}
