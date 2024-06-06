package com.oak.JPAexamples.JPA_service.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oak.JPAexamples.JPA_service.Entity.Employee;
import com.oak.JPAexamples.JPA_service.Repositories.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeerepository;

    @Override
    public Employee save(Employee employee) {
        Employee employee_added = new Employee();
        employee_added = employeerepository.save(employee);
        return employee_added;
        // or
        // employee = employeerepository.save(employee);
        // return employee;
    }

    @Override
    public List<Employee> getall() {
        return null;
    }

    @Override
    public Employee getById(long Id) {
        return null;
    }

    @Override
    public Employee deleteById(long Id) {
        return null;
    }
}
