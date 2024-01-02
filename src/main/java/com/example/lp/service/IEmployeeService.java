package com.example.lp.service;

import com.example.lp.entity.Employee;
import com.example.lp.exception.BadRequestException;
import com.example.lp.model.CreateEmployeeRequest;
import com.example.lp.model.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {
    Employee add(CreateEmployeeRequest request) throws BadRequestException;

    Employee update(long employeeCode, CreateEmployeeRequest request);

    boolean delete(long employeeCode);

    EmployeeDTO getOne(long employeeCode);

    List<EmployeeDTO> getEmployeesByBranchAndGroup(String branchCode);

    List<EmployeeDTO> getEmployees(String branchCode, Boolean status);
}
