package com.oak.JPAexamples.JPA_service.Services;

import java.util.List;

import com.oak.JPAexamples.JPA_service.Entity.Employee;

public interface EmployeeService {
    public Employee save(Employee employee);

    public List<Employee> getall();

    public Employee getById(long Id);

    public Employee deleteById(long Id);

}
