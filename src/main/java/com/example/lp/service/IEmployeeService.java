package com.example.lp.service;

import com.example.lp.entity.Employee;
import com.example.lp.model.CreateEmployeeRequest;
import com.example.lp.model.EmployeeDTO;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface IEmployeeService {
    Employee add(CreateEmployeeRequest request);

    Employee update(long employeeCode, CreateEmployeeRequest request);

    boolean delete(long employeeCode);

    List<EmployeeDTO> getList();

    EmployeeDTO getOne(long employeeCode);

    List<EmployeeDTO> getEmployeesByBranchAndStatus(String branchCode, boolean status);

    List<EmployeeDTO> getEmployeesByStatus(boolean status);

    List<EmployeeDTO> getEmployeesByBranchAndGroup(String branchCode);

    void migrate();

    List<EmployeeDTO> getEmployees(String branchCode, Boolean status);
}
