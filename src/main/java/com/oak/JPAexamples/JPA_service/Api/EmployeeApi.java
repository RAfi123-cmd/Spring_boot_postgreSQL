package com.oak.JPAexamples.JPA_service.Api;

import java.util.List;

// import java.util.List;

import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oak.JPAexamples.JPA_service.DTO.EmployeeDto;
// import com.oak.JPAexamples.JPA_service.DTO.EmployeeDTO;
// import com.oak.JPAexamples.JPA_service.Entity.Employee;
import com.oak.JPAexamples.JPA_service.Services.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeApi {

    private final EmployeeService employeeservice;

    // localhost:8080/employee
    @PostMapping("/{id}")
    public ResponseEntity<EmployeeDto> getbyId(@PathVariable("id") long Id) {
        boolean control = employeeservice.existby(Id);
        if (control)
            System.out.println("Employee is present");
        else
            System.out.println("Employee is not in the Database");

        return new ResponseEntity<EmployeeDto>(employeeservice.getById(Id), HttpStatus.OK);
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
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employee) {
        return new ResponseEntity<EmployeeDto>(employeeservice.save(employee), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getall() {
        System.out.println("The count is:" + employeeservice.count());
        return new ResponseEntity<List<EmployeeDto>>(employeeservice.getall(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> update(@PathVariable("id") long Id, @RequestBody EmployeeDto employeedto) {
        employeedto.setId(Id);
        return new ResponseEntity<EmployeeDto>(employeeservice.update(employeedto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDto> delete(@PathVariable("id") long Id) {
        return new ResponseEntity<EmployeeDto>(employeeservice.deleteById(Id), HttpStatus.OK);
    }

    @GetMapping("/pagination/{offset}/{pagesize}")
    public ResponseEntity<List<EmployeeDto>> employeepagination(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int pagesize) {
        return ResponseEntity.ok(employeeservice.pagination(offset, pagesize));

    }

    @GetMapping("/sortedlist/{direction}/{field}")
    public ResponseEntity<List<EmployeeDto>> sortinglist(@PathVariable("direction") String direction,
            @PathVariable("field") String field) {
        return ResponseEntity.ok(employeeservice.sorting(direction, field));
    }

    // public ResponseEntity<List<Employee>> pagination() {

    // }
}
