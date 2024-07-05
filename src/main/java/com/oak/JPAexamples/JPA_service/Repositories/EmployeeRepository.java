package com.oak.JPAexamples.JPA_service.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oak.JPAexamples.JPA_service.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByFirstName(String firstName);

    List<Employee> findByFirtsNameAndLastName(String firstName, String lastName);

    List<Employee> findByFirtsNameOrLastName(String firstName, String lastName);
    List<Employee> findByEmailContaining(String email);

}
