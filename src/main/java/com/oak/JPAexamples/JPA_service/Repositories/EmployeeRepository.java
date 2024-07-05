package com.oak.JPAexamples.JPA_service.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oak.JPAexamples.JPA_service.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByFirstName(String firstName);

    List<Employee> findByFirtsNameAndLastName(String firstName, String lastName);

    List<Employee> findByFirtsNameOrLastName(String firstName, String lastName);

    List<Employee> findByEmailContaining(String email);

    List<Employee> findByAgeGreaterThan(int age);

    List<Employee> findByAgeLessThan(int age);

    List<Employee> findByAgeLessThanEqual(int age);

    List<Employee> findByAgeGreaterThanAndAgeLessThan(int age1, int age2);

    List<Employee> findByAgeBetween(int age1, int age2);

    List<Employee> findByFirstNameIn(String[] array);

    List<Employee> findFirst3ByOrdersByFirstNameAsc();

    List<Employee> findLast3ByOrdersByFirstNameDesc();

    @Query("SELECT e FROM Employee e WHERE e.age> :age")
    List<Employee> findByAgeGreaterThanEquels(@Param("age") Integer age);

    @Query(nativeQuery = true, value = "SELECT * FROM Employee e WHERE e.last_name= :lastname")
    List<Employee> findLastNameEqual(@Param("lastname") String lastname);

}
