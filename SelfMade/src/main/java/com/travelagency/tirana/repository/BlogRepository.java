package com.travelagency.tirana.repository;


import com.travelagency.tirana.model.Blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    @Query(value = "SELECT * FROM Blog WHERE id = :id", nativeQuery = true)
    Blog findOne(Long id);
}
