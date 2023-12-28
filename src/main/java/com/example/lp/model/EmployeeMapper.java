package com.example.lp.model;

import com.example.lp.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDTO toEmployeeDTO(Employee employee){
        EmployeeDTO tmp = new EmployeeDTO();
        tmp.setEmployee_code(employee.getEmployee_code());
        tmp.setName(employee.getName());
        tmp.setAge(employee.getAge());
        tmp.setBranch_code(employee.getBranch_code());
        tmp.setStatus(employee.isStatus());
        tmp.setAddress(employee.getAddress());

        return tmp;
    }
}
