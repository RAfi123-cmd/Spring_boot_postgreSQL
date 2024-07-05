package com.oak.JPAexamples.JPA_service.Entity;

import java.sql.Timestamp;
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;

import org.hibernate.annotations.CreationTimestamp;
// import org.hibernate.annotations.UpdateTimestamp;
// import org.springframework.format.annotation.DateTimeFormat;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.Index;
// import jakarta.persistence.Table;
// import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
/*
 * @Table(name = "employees", schema = "newone", uniqueConstraints
 * = @UniqueConstraint(columnNames = "FirstName"), indexes = @Index(name =
 * "email_index", columnList = "Email"))
 */

public class Employee {
    // public static final String HttpStatus = null;
    // @jakarta.persistence.Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(nullable = false, name = "Name")
    private String firstName;
    @Column(length = 60)
    private String lastName;
    @Column(unique = true)
    private String email;
    private int age;
    @CreationTimestamp
    private Timestamp createdDate;
    @UpdateTimestamp
    private Timestamp lastUpdateDate;

    // DateTimeFormatter format=new DateTimeFormat("yyyy.mm.dd")
    // format(LocalDateTime.new());

}
