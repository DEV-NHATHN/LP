package com.example.lp.service;

import com.example.lp.dto.EmployeeDTO;
import com.example.lp.model.Employee;
import com.example.lp.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public boolean isEmployeeExists(long employeeCode) {
        Optional<Employee> employeeOptional = employeeRepo.findById(employeeCode);
        return employeeOptional.isPresent();
    }

    @Override
    public Employee add(Employee employee) {
        if (employee != null) return employeeRepo.save(employee);
        return null;
    }

    @Override
    public Employee update(long employeeCode, EmployeeDTO employeeDTO) {
        if (isEmployeeExists(employeeCode)) {
            Employee e = employeeRepo.getReferenceById(employeeCode);
            // Sử dụng constructor để khởi tạo Employee với dữ liệu từ EmployeeDTO
            Employee updatedEmployee = new Employee(
                    e.getEmployeeCode(),
                    employeeDTO.getName(),
                    employeeDTO.getAge(),
                    employeeDTO.getBranchCode(),
                    employeeDTO.isStatus(),
                    employeeDTO.getAddress()
            );

            return employeeRepo.save(updatedEmployee);
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
