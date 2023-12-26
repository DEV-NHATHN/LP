package com.example.lp.service;

import com.example.lp.model.Employee;
import com.example.lp.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee add(Employee employee) {
        if (employee != null) return employeeRepo.save(employee);
        return null;
    }

    @Override
    public Employee update(long employee_code, Employee employee) {
        if (employee != null) {
            Employee e = employeeRepo.getById(employee_code);
            if (e != null) {
                e.setName(employee.getName());
                e.setAge(employee.getAge());
                e.setBranch_code(employee.getBranch_code());
                e.setStatus(employee.isStatus());
                e.setAddress(employee.getAddress());

                return employeeRepo.save(e);
            }
        }
        return null;
    }

    @Override
    public boolean delete(long employee_code) {
            Employee employee = employeeRepo.getById(employee_code);
            if (employee != null) {
                employeeRepo.delete(employee);
                return true;
            }
        return false;
    }

    @Override
    public List<Employee> getList() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getOne(long employee_code) {
        return employeeRepo.getById(employee_code);
    }
}
