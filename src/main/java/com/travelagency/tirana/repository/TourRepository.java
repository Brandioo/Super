package com.travelagency.tirana.repository;

import com.travelagency.tirana.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TourRepository extends JpaRepository<Tour, Long> {
    @Query(value = "SELECT * FROM Tour WHERE tourID = :tourID", nativeQuery = true)
    Tour findOne(long tourID);
}
