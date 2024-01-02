package com.example.lp.controller;

import com.example.lp.entity.Employee;
import com.example.lp.model.CreateEmployeeRequest;
import com.example.lp.model.EmployeeDTO;
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
    public Employee add(@RequestBody CreateEmployeeRequest request) {
        return iEmployeeService.add(request);
    }

    @PutMapping("/update/{employee_code}")
    public Employee update(@PathVariable("employee_code") long employeeCode, @RequestBody CreateEmployeeRequest request) {
        return iEmployeeService.update(employeeCode, request);
    }

    @DeleteMapping("/delete/{employee_code}")
    public boolean delete(@PathVariable("employee_code") long employeeCode) {
        return iEmployeeService.delete(employeeCode);
    }

    @GetMapping("/list")
    public List<EmployeeDTO> list(
            @RequestParam(value = "branch_code", required = false) String branchCode,
            @RequestParam(value = "status", required = false) Boolean status) {

        return iEmployeeService.getEmployees(branchCode, status);
    }

    @GetMapping("/group")
    public List<EmployeeDTO> group(
            @RequestParam(value = "branch_code", required = false) String branchCode) {
        return iEmployeeService.getEmployeesByBranchAndGroup(branchCode);
    }

    @GetMapping("/migrate")
    public void migrate() {
        iEmployeeService.migrate();
    }
}
