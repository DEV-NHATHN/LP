package com.example.lp.controller;

import com.example.lp.entity.Employee;
import com.example.lp.exception.BadRequestException;
import com.example.lp.model.CreateEmployeeRequest;
import com.example.lp.model.EmployeeDTO;
import com.example.lp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/employee")
@EnableTransactionManagement
public class EmployeeController {
    private final IEmployeeService iEmployeeService;

    @Autowired
    public EmployeeController(IEmployeeService iEmployeeService) {
        this.iEmployeeService = iEmployeeService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CreateEmployeeRequest request) {
        try {
            return ResponseEntity.ok().body(iEmployeeService.add(request));
        } catch (BadRequestException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
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
    public List<EmployeeDTO> list(@RequestParam Map<String, Object> params) {
        return iEmployeeService.getEmployees(params);
    }

    @GetMapping("/group")
    public List<EmployeeDTO> group(
            @RequestParam(value = "branch_code", required = false) String branchCode) {
        return iEmployeeService.getEmployeesByBranchAndGroup(branchCode);
    }
}
