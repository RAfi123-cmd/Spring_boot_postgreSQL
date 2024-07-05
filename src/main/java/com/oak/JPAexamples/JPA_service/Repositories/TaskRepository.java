package com.oak.JPAexamples.JPA_service.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.oak.JPAexamples.JPA_service.Entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTime(@Param("time") Integer time);

}
