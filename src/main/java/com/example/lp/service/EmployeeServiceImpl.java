package com.example.lp.service;

import com.example.lp.entity.Employee;
import com.example.lp.model.CreateEmployeeRequest;
import com.example.lp.model.EmployeeDTO;
import com.example.lp.model.EmployeeMapper;
import com.example.lp.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
            employee.setSecret_key(request.getSecret_key());

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
                    request.getAddress(),
                    request.getSecret_key()
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
    public List<EmployeeDTO> getList() {
        List<Employee> list = employeeRepo.findAll();

        List<EmployeeDTO> result = new ArrayList<>();
        for(Employee  employee : list) {
            result.add(EmployeeMapper.toEmployeeDTO(employee));
        }
        return result;
    }

    @Override
    public EmployeeDTO getOne(long employeeCode) {
        Employee e = employeeRepo.getReferenceById(employeeCode);
        return EmployeeMapper.toEmployeeDTO(e);
    }

    @Override
    public List<EmployeeDTO> getEmployeesByBranchAndStatus(String branchCode, boolean status) {
        List<Employee> list = employeeRepo.findByBranchCodeAndStatus(branchCode, status);

        List<EmployeeDTO> result = new ArrayList<>();
        for(Employee  employee : list) {
            result.add(EmployeeMapper.toEmployeeDTO(employee));
        }
        return result;
    }

    @Override
    public List<EmployeeDTO> getEmployeesByStatus(boolean status) {
        List<Employee> list = employeeRepo.findByStatus(status);

        List<EmployeeDTO> result = new ArrayList<>();
        for(Employee  employee : list) {
            result.add(EmployeeMapper.toEmployeeDTO(employee));
        }
        return result;
    }

    @Override
    public List<EmployeeDTO> getEmployeesByBranchAndGroup(String branchCode) {
        List<Employee> list = employeeRepo.findBranchCodeAndGroup(branchCode);

        List<EmployeeDTO> result = new ArrayList<>();
        for(Employee  employee : list) {
            result.add(EmployeeMapper.toEmployeeDTO(employee));
        }
        return result;
    }
}
