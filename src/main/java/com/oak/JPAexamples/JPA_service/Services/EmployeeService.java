package com.oak.JPAexamples.JPA_service.Services;

import java.util.List;

import com.oak.JPAexamples.JPA_service.DTO.EmployeeDto;
// import com.oak.JPAexamples.JPA_service.Entity.Employee;

public interface EmployeeService {
    public EmployeeDto save(EmployeeDto employee);

    public EmployeeDto update(EmployeeDto employeedto);

    public List<EmployeeDto> getall();

    public EmployeeDto getById(long Id);

    public EmployeeDto deleteById(long Id);

    public long count();

    public boolean existby(long Id);

}
