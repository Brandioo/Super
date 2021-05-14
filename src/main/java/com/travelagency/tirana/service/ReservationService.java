package com.travelagency.tirana.service;

import com.travelagency.tirana.model.Reservation;
import com.travelagency.tirana.service.Impl.ReservationImpl.SaveReservationRequest;


import java.util.List;
import java.util.Optional;

public interface ReservationService {
    long save(SaveReservationRequest request);

    List<Reservation> getAll();

    Optional<Reservation> getById(long id);

    void delete(long reservationId);

}
