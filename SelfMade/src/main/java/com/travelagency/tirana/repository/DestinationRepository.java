package com.travelagency.tirana.repository;

import com.travelagency.tirana.model.Destination;
import com.travelagency.tirana.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DestinationRepository extends JpaRepository<Destination, Long>{

    @Query(value = "SELECT * FROM Destination WHERE id = :id", nativeQuery = true)
    Reservation findOne(Long id);

}
