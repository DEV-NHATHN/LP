package com.example.lp.controller;

import com.example.lp.dto.EmployeeDTO;
import com.example.lp.model.Employee;
import com.example.lp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final IEmployeeService iEmployeeService;

    @Autowired
    public EmployeeController(IEmployeeService iEmployeeService) {
        this.iEmployeeService = iEmployeeService;
    }

    @PostMapping("/add")
    public Employee add(@RequestBody Employee employee) {
        return iEmployeeService.add(employee);
    }

    @PutMapping("/update/{employee_code}")
    public Employee update(@PathVariable("employee_code") long employee_code, @RequestBody EmployeeDTO employeeDTO) {
        return iEmployeeService.update(employee_code, employeeDTO);
    }

    @DeleteMapping("/delete/{employee_code}")
    public boolean delete(@PathVariable("employee_code") long employee_code) {
        return iEmployeeService.delete(employee_code);
    }

    @GetMapping("/list")
    public List<Employee> list(
            @RequestParam(value = "branch_code", required = false) String branch_code,
            @RequestParam(value = "status", required = false) Boolean status) {

        if (branch_code != null && status != null) {
            // cả branch_code và status đều được cung cấp.
            return iEmployeeService.getEmployeesByBranchAndStatus(branch_code, status);
        } else if (status != null) {
            // chỉ có status được cung cấp.
            return iEmployeeService.getEmployeesByStatus(status);
        } else {
            // không có tham số nào được cung cấp.
            return iEmployeeService.getList();
        }
    }

    @GetMapping("/group")
    public List<Employee> group(
            @RequestParam(value = "branch_code", required = false) String branch_code) {
            return iEmployeeService.getEmployeesByBranchAndGroup(branch_code);
    }
}
