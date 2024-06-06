package com.oak.JPAexamples.JPA_service.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oak.JPAexamples.JPA_service.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
