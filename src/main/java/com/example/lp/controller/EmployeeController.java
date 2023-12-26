package com.example.lp.controller;

import com.example.lp.model.Employee;
import com.example.lp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @PostMapping("/add")
    public Employee add(@RequestBody Employee employee){
        return iEmployeeService.add(employee);
    }

    @PutMapping("/update")
    public Employee update(@RequestParam("employee_code") long employee_code, @RequestBody Employee employee ){
        return iEmployeeService.update(employee_code, employee);
    }

    @DeleteMapping("/delete/{employee_code}")
    public boolean delete(@PathVariable("employee_code") long employee_code){
        return iEmployeeService.delete(employee_code);
    }

    @GetMapping("/list")
    public List<Employee> getList(){
        return iEmployeeService.getList();
    }
}
