package com.example.lp.service;

import com.example.lp.model.Employee;
import com.example.lp.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee add(Employee employee) {
        if (employee != null) return employeeRepo.save(employee);
        return null;
    }

    @Override
    public Employee update(long employee_code, Employee employee) {
        if (employee != null) {
            Employee e = employeeRepo.getReferenceById(employee_code);
            e.setName(employee.getName());
            e.setAge(employee.getAge());
            e.setBranch_code(employee.getBranch_code());
            e.setStatus(employee.isStatus());
            e.setAddress(employee.getAddress());

            return employeeRepo.save(e);
        }
        return null;
    }

    @Override
    public boolean delete(long employee_code) {
        Employee employee = employeeRepo.getReferenceById(employee_code);
        employeeRepo.delete(employee);
        return true;
    }

    @Override
    public List<Employee> getList() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getOne(long employee_code) {
        return employeeRepo.getReferenceById(employee_code);
    }

    @Override
    public List<Employee> getEmployeesByBranchAndStatus(String branch_code, boolean status) {
        return employeeRepo.findByBranchCodeAndStatus(branch_code, status);
    }

    @Override
    public List<Employee> getEmployeesByStatus(boolean status) {
        return employeeRepo.findByStatus(status);
    }

    @Override
    public List<Employee> getEmployeesByBranchAndGroup(String branch_code) {
        return employeeRepo.findBranchCodeAndGroup(branch_code);
    }

}
