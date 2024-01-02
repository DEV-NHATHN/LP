package com.example.lp.repository;

import com.example.lp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor {
    /* @Query("SELECT new Employee(e.employee_code, e.name, e.age, e.branch_code, e.status, e.address) FROM Employee e WHERE e.branch_code = :branchCode AND e.status = :status")
    List<Employee> findByBranchCodeAndStatus(@Param("branch_code") String branchCode, @Param("status") boolean status); */
    @Query(value = "SELECT * FROM Employee e WHERE e.branch_code = :branchCode AND e.status = :status", nativeQuery = true)
    List<Employee> findByBranchCodeAndStatus(String branchCode, boolean status);

    @Query(value = "SELECT * FROM Employee e WHERE e.status = :status", nativeQuery = true)
    List<Employee> findByStatus(boolean status);

    @Query(value = "select Employee.employee_code, name, age, branch_code, status, address, secret_key from" +
            "    (Employee inner join Group_history on Employee.employee_code = Group_history.employee_code)" +
            "where branch_code=:branchCode", nativeQuery = true)
    List<Employee> findBranchCodeAndGroup(String branchCode);
}
