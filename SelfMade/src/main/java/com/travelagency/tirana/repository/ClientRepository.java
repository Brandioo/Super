package com.travelagency.tirana.repository;

import com.travelagency.tirana.model.Client;
import com.travelagency.tirana.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client,Long> {
    @Query(value = "SELECT * FROM Client WHERE id = :id", nativeQuery = true)
    Client findOne(Long id);
}
