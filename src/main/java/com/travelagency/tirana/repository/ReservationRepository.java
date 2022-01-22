package com.travelagency.tirana.repository;

import com.travelagency.tirana.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query(value = "SELECT * FROM Reservation WHERE id = :id", nativeQuery = true)
    Reservation findOne(Long id);
}
