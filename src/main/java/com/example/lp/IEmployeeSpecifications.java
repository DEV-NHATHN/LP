package com.example.lp;

import org.springframework.data.jpa.domain.Specification;
import  com.example.lp.entity.Employee;
public interface IEmployeeSpecifications {
    static Specification<Employee> hasBranchCode(String branchCode) {
        return (root, query, criteriaBuilder) ->
                branchCode == null ? criteriaBuilder.conjunction() :
                        criteriaBuilder.equal(root.get("branch_code"), branchCode);
    }

    static Specification<Employee> hasStatus(Boolean status) {
        return (root, query, criteriaBuilder) ->
                status == null ? criteriaBuilder.conjunction() :
                        criteriaBuilder.equal(root.get("status"), status);
    }
}
