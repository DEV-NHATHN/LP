package com.example.lp.service;

import com.example.lp.entity.Employee;
import com.example.lp.model.CreateEmployeeRequest;
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
    public Employee add(CreateEmployeeRequest request) {
        if (request != null) {
            Employee employee = new Employee();
            employee.setName(request.getName());
            employee.setAge(request.getAge());
            employee.setBranch_code(request.getBranch_code());
            employee.setStatus(request.isStatus());
            employee.setAddress(request.getAddress());

            return employeeRepo.save(employee);

        }
        return null;
    }

    @Override
    public Employee update(long employeeCode, CreateEmployeeRequest request) {
        if (isEmployeeExists(employeeCode)) {
            // Sử dụng constructor để khởi tạo Employee với dữ liệu từ EmployeeDTO
            Employee updatedEmployee = new Employee(
                    employeeCode,
                    request.getName(),
                    request.getAge(),
                    request.getBranch_code(),
                    request.isStatus(),
                    request.getAddress()
            );

            return employeeRepo.save(updatedEmployee);
        }
        return null;
    }

    @Override
    public boolean delete(long employeeCode) {
        if (isEmployeeExists(employeeCode)){
            employeeRepo.deleteById(employeeCode);
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> getList() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getOne(long employeeCode) {
        return employeeRepo.getReferenceById(employeeCode);
    }

    @Override
    public List<Employee> getEmployeesByBranchAndStatus(String branchCode, boolean status) {
        return employeeRepo.findByBranchCodeAndStatus(branchCode, status);
    }

    @Override
    public List<Employee> getEmployeesByStatus(boolean status) {
        return employeeRepo.findByStatus(status);
    }

    @Override
    public List<Employee> getEmployeesByBranchAndGroup(String branchCode) {
        return employeeRepo.findBranchCodeAndGroup(branchCode);
    }
}
