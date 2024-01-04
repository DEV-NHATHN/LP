package com.example.lp.service;

import com.example.lp.IEmployeeSpecifications;
import com.example.lp.entity.Employee;
import com.example.lp.exception.BadRequestException;
import com.example.lp.model.CreateEmployeeRequest;
import com.example.lp.model.EmployeeDTO;
import com.example.lp.model.ModelMapper;
import com.example.lp.repository.EmployeeRepository;
import com.example.lp.utils.Util;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class EmployeeServiceImpl implements IEmployeeService {
    private final EmployeeRepository employeeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
        this.employeeRepository = employeeRepo;
    }

    public boolean isEmployeeExists(long employeeCode) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeCode);
        return employeeOptional.isPresent();
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, timeout = 30)
//    public List<EmployeeDTO> getEmployees(String branchCode, Boolean status) {
//        Specification<Employee> spec = Specification.where(null);
//
//        if (branchCode != null) {
//            spec = spec.and(IEmployeeSpecifications.hasBranchCode(branchCode));
//        }
//
//        if (status != null) {
//            spec = spec.and(IEmployeeSpecifications.hasStatus(status));
//        }
//
//        List<Employee> employees = employeeRepository.findAll(spec);
//
//        List<EmployeeDTO> result = new ArrayList<>();
//        for (Employee employee : employees) {
//            result.add(ModelMapper.toEmployeeDTO(employee));
//        }
//        return result;
//    }

//    public List<EmployeeDTO> getEmployees(String branchCode, Boolean status) {
//        StringBuilder queryString = new StringBuilder("SELECT * FROM Employee e WHERE 1=1");
//
//        if (branchCode != null) {
//            queryString.append(" AND e.branch_code = :branchCode");
//        }
//
//        if (status != null) {
//            queryString.append(" AND e.status = :status");
//        }
//
//        Query query = entityManager.createNativeQuery(queryString.toString(), Employee.class);
//
//        if (branchCode != null) {
//            query.setParameter("branchCode", branchCode);
//        }
//
//        if (status != null) {
//            query.setParameter("status", status);
//        }
//
//        @SuppressWarnings("unchecked")
//        List<Employee> employees = query.getResultList();
//
//        List<EmployeeDTO> result = new ArrayList<>();
//        for (Employee employee : employees) {
//            result.add(ModelMapper.toEmployeeDTO(employee));
//        }
//        return result;
//    }

//    public List<EmployeeDTO> getEmployees(Map<String, String> params) {
//        List<Employee> employees = employeeRepository.findAll((Specification<Employee>) (root, query, criteriaBuilder) -> {
//            List<Predicate> predicates = new ArrayList<>();
//            params.forEach((field, value) -> {
//                if (value != null) {
//                    if (value.equals("true") || value.equals("false")) {
//                        Boolean bool = Boolean.parseBoolean(value);
//                        predicates.add(criteriaBuilder.equal(root.get(field), bool));
//                    } else {
//                        predicates.add(criteriaBuilder.equal(root.get(field), value));
//                    }
//                }
//            });
//
//            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//        });
//
//        List<EmployeeDTO> result = new ArrayList<>();
//
//        for (Employee employee : employees) {
//            result.add(ModelMapper.toEmployeeDTO(employee));
//        }
//
//        return result;
//    }

    public List<EmployeeDTO> getEmployees(Map<String, Object> params) {
        StringBuilder queryString = new StringBuilder("SELECT * FROM Employee e WHERE 1=1");


        params.forEach((field, value) -> {
            if (value != null) {
                queryString.append(" AND e.").append(field).append(" = :").append(field);
            }
        });

        Query query = entityManager.createNativeQuery(queryString.toString(), Employee.class);


        if (!params.isEmpty()) {
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
        }

        @SuppressWarnings("unchecked")
        List<Employee> employees = query.getResultList();

        List<EmployeeDTO> result = new ArrayList<>();
        for (Employee employee : employees) {
            result.add(ModelMapper.toEmployeeDTO(employee));
        }
        return result;
    }


    @Transactional(
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRES_NEW,
            timeout = 30)
    @Override
    public Employee add(CreateEmployeeRequest request) throws BadRequestException {
        if (!Util.isValidString(request.getName())) {
            throw new BadRequestException("Name is not valid!");
        }

        if (!Util.isValidNumber(request.getAge())) {
            throw new BadRequestException("Age is not valid!");
        }

        if (!Util.isValidString(request.getBranch_code())) {
            throw new BadRequestException("Branch code is not valid!");
        }

        if (!Util.isValidString(request.getAddress())) {
            throw new BadRequestException("Address code is not valid!");
        }

        Employee employee = new Employee(request.getName(), request.getAge(), request.getBranch_code(), request.isStatus(), request.getAddress(), request.getSecret_key());
        Employee employee2 = new Employee(request.getName(), request.getAge(), request.getBranch_code(), request.isStatus(), request.getAddress(), request.getSecret_key());
        Employee employee3 = new Employee(request.getName(), request.getAge(), request.getBranch_code(), request.isStatus(), request.getAddress(), request.getSecret_key());
        Employee employee4 = new Employee(request.getName(), request.getAge(), request.getBranch_code(), request.isStatus(), request.getAddress(), request.getSecret_key());
        Employee employee5 = new Employee(request.getName(), request.getAge(), request.getBranch_code(), request.isStatus(), request.getAddress(), request.getSecret_key());

        saveEmployee1(employee);
        saveEmployee2(employee2);
        saveEmployee3(employee3);
        saveEmployee4(employee4);
        saveEmployee5(employee5);

        return employeeRepository.save(employee);
    }

    @Transactional(
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRES_NEW,
            timeout = 30,
            rollbackFor = BadRequestException.class)
    void saveEmployee1(Employee employee) throws BadRequestException {
        employeeRepository.save(employee);
    }

    @Transactional(
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRES_NEW,
            timeout = 30,
            rollbackFor = BadRequestException.class)
    void saveEmployee2(Employee employee) throws BadRequestException {
        employeeRepository.save(employee);
    }

    @Transactional(
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRES_NEW,
            timeout = 30,
            rollbackFor = BadRequestException.class)
    void saveEmployee3(Employee employee) throws BadRequestException {
        employeeRepository.save(employee);
    }

    @Transactional(
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRES_NEW,
            timeout = 30,
            rollbackFor = BadRequestException.class)
    void saveEmployee4(Employee employee) throws BadRequestException {
        throw new BadRequestException("Err");
    }

    @Transactional(
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRES_NEW,
            timeout = 30,
            rollbackFor = BadRequestException.class)
    void saveEmployee5(Employee employee) throws BadRequestException {
        throw new BadRequestException("Err");
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, timeout = 30)
    @Override
    public Employee update(long employeeCode, CreateEmployeeRequest request) {
        if (isEmployeeExists(employeeCode)) {
            Employee updatedEmployee = new Employee(
                    request.getName(),
                    request.getAge(),
                    request.getBranch_code(),
                    request.isStatus(),
                    request.getAddress(),
                    request.getSecret_key()
            );
            updatedEmployee.setEmployee_code(employeeCode);

            return employeeRepository.save(updatedEmployee);
        }
        return null;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, timeout = 30)
    @Override
    public boolean delete(long employeeCode) {
        if (isEmployeeExists(employeeCode)) {
            employeeRepository.deleteById(employeeCode);
            return true;
        }
        return false;
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, timeout = 30)
    @Override
    public EmployeeDTO getOne(long employeeCode) {
        Employee e = employeeRepository.getReferenceById(employeeCode);
        return ModelMapper.toEmployeeDTO(e);
    }

    @Override
    public List<EmployeeDTO> getEmployeesByBranchAndGroup(String branchCode) {
        List<Employee> list = employeeRepository.findBranchCodeAndGroup(branchCode);

        List<EmployeeDTO> result = new ArrayList<>();
        for (Employee employee : list) {
            result.add(ModelMapper.toEmployeeDTO(employee));
        }
        return result;
    }
}
