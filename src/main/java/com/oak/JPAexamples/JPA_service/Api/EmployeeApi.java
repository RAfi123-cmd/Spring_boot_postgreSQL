package com.oak.JPAexamples.JPA_service.Api;

// import java.util.List;

import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.oak.JPAexamples.JPA_service.DTO.EmployeeDTO;
import com.oak.JPAexamples.JPA_service.Entity.Employee;
import com.oak.JPAexamples.JPA_service.Services.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeApi {

    private final EmployeeService employeeservice;

    // localhost:8080/employee
    @PostMapping("/{id}")
    public ResponseEntity<Employee> getbyId(@PathVariable("id") long Id) {
        Employee employee = new Employee();
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    // @GetMapping
    // public ResponseEntity<Employee> save2() {
    // Employee employee = new Employee();
    // employee.setFirstName("Bernard");
    // employee.setLastName("Lewis");
    // employee.setEmail("Bernard@gmail.com");
    // employee.setAge(80);
    // return ResponseEntity.ok(employeeservice.save(employee));
    // // Manually
    // // return new ResponseEntity<Employee>(employee.HttpStatus.OK);
    // }
    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeservice.save(employee), HttpStatus.OK);
    }

    // public ResponseEntity<Employee> update(@RequestBody Employee employee) {

    // }

    // public ResponseEntity<Employee> delete(long id) {

    // }

    // public ResponseEntity<List<Employee>> pagination() {

    // }
}
