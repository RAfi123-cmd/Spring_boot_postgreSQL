package com.oak.JPAexamples.JPA_service.Api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oak.JPAexamples.JPA_service.Entity.Employee;
import com.oak.JPAexamples.JPA_service.Repositories.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/querymethods")
@RequiredArgsConstructor
public class QueriesApi {
    private final EmployeeRepository employeeRepository;

    @GetMapping("/findbyfirstname")
    public ResponseEntity<List<Employee>> getByFirstName() {
        return ResponseEntity.ok(employeeRepository.findByFirstName("John"));
    }

    @GetMapping("/multiple fields")
    public ResponseEntity<List<Employee>> getByFirstNameandLastName() {
        return ResponseEntity.ok(employeeRepository.findByFirtsNameAndLastName("Josh", "Malerman"));
    }

    @GetMapping("/multiplefieldsor")
    public ResponseEntity<List<Employee>> getByFirstNameorLastName() {
        return ResponseEntity.ok(employeeRepository.findByFirtsNameOrLastName("Josh", "Malerman"));
    }

    @GetMapping("/containing")
    public ResponseEntity<List<Employee>> containing() {
        return ResponseEntity.ok(employeeRepository.findByEmailContaining("gmail"));
    }

    @GetMapping("/greater")
    public ResponseEntity<List<Employee>> greater() {
        return ResponseEntity.ok(employeeRepository.findByAgeGreaterThan(30));
    }

    @GetMapping("/lessthan")
    public ResponseEntity<List<Employee>> less() {
        return ResponseEntity.ok(employeeRepository.findByAgeLessThan(40));
    }

    @GetMapping("/lessequels")
    public ResponseEntity<List<Employee>> lessequels() {
        return ResponseEntity.ok(employeeRepository.findByAgeLessThanEqual(40));
    }

    @GetMapping("/greaterandless")
    public ResponseEntity<List<Employee>> greaterandless() {
        return ResponseEntity.ok(employeeRepository.findByAgeGreaterThanAndAgeLessThan(20, 50));
    }

    @GetMapping("/between")
    public ResponseEntity<List<Employee>> between() {
        return ResponseEntity.ok(employeeRepository.findByAgeBetween(20, 50));
    }

}
