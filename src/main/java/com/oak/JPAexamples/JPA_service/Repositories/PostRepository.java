package com.oak.JPAexamples.JPA_service.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oak.JPAexamples.JPA_service.Entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
