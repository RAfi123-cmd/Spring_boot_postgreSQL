package com.oak.JPAexamples.JPA_service.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.oak.JPAexamples.JPA_service.DTO.EmployeeDto;
import com.oak.JPAexamples.JPA_service.Entity.Employee;
import com.oak.JPAexamples.JPA_service.Repositories.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeerepository;
    private final ModelMapper modelmapper;

    @Override
    public EmployeeDto deleteById(long Id) {
        return null;
    }

    @Override
    public EmployeeDto getById(long Id) {
        return null;
    }

    @Override
    public List<EmployeeDto> getall() {
        List<Employee> employeeList = employeerepository.findAll();
        List<EmployeeDto> dtoList = employeeList.stream().map(employee -> modelmapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public EmployeeDto save(EmployeeDto employeedto) {
        Employee employee = modelmapper.map(employeedto, Employee.class);
        employee = employeerepository.save(employee);
        employeedto = modelmapper.map(employee, EmployeeDto.class);
        return employeedto;
        // Employee employee_added = new Employee();
        // employee_added.setFirstName(employee.getFirstName());
        // employee_added.setLastName(employee.getLastName());
        // employee_added.setEmail(employee.getEmail());
        // employee_added.setAge(employee.getAge());
        // employee_added = employeerepository.save(employee_added);
        // employee.setId(employee_added.getId());
        // employee.setCreatedDate(employee_added.getCreatedDate());
        // employee.setLastUpdateDate(employee_added.getLastUpdateDate());
    }

}
