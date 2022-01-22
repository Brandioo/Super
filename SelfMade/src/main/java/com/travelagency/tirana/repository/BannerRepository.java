package com.travelagency.tirana.repository;

import com.travelagency.tirana.model.Banner;
import com.travelagency.tirana.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BannerRepository extends JpaRepository<Banner, Long> {
    @Query(value = "SELECT * FROM Banner WHERE id = :id", nativeQuery = true)
    Banner findOne(Long id);
}
