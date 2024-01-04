package com.example.lp.service;

import com.example.lp.entity.Employee;
import com.example.lp.exception.BadRequestException;
import com.example.lp.model.CreateEmployeeRequest;
import com.example.lp.model.EmployeeDTO;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    Employee add(CreateEmployeeRequest request) throws BadRequestException;

    Employee update(long employeeCode, CreateEmployeeRequest request);

    boolean delete(long employeeCode);

    EmployeeDTO getOne(long employeeCode);

    List<EmployeeDTO> getEmployeesByBranchAndGroup(String branchCode);

    List<EmployeeDTO> getEmployees(Map<String, ?> params);
}
