package com.example.lp;

import com.example.lp.entity.Employee;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LpApplication implements CommandLineRunner {
    private EntityManager entityManager;

    @Autowired
    public LpApplication(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private void generateFakeEmployees(int count){
//        Faker faker = new Faker();
//        for (int i = 0; i < count; i++) {
//            var employee = Employee.builder()
//                    .name(faker.name().fullName())
//                    .age(faker.number().numberBetween(18, 65))
//                    .branch_code(faker.options().option("TX", "HM"))
//                    .status(faker.bool().bool())
//                    .address(faker.address().cityName())
//                    .secret_key(faker.internet().password())
//                    .build();
//            entityManager.persist(employee);
//        }
//        entityManager.flush();
    }
    public static void main(String[] args) {
        SpringApplication.run(LpApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

    }
}
