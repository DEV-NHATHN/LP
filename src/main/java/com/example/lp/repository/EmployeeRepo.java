package com.example.lp.repository;

import com.example.lp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    /* @Query("SELECT new Employee(e.employee_code, e.name, e.age, e.branch_code, e.status, e.address) FROM Employee e WHERE e.branch_code = :branch_code AND e.status = :status")
    List<Employee> findByBranchCodeAndStatus(@Param("branch_code") String branch_code, @Param("status") boolean status); */
    @Query(value = "SELECT * FROM Employee e WHERE e.branch_code = :branch_code AND e.status = :status", nativeQuery = true)
    List<Employee> findByBranchCodeAndStatus(String branch_code, boolean status);

    @Query(value = "SELECT * FROM Employee e WHERE e.status = :status", nativeQuery = true)
    List<Employee> findByStatus(boolean status);

    @Query(value = "select Employee.employee_code, name, age, branch_code, status, address from" +
            "    (Employee inner join Group_history on Employee.employee_code = Group_history.employee_code)" +
            "where branch_code=:branch_code", nativeQuery = true)
    List<Employee> findBranchCodeAndGroup(String branch_code);

}
