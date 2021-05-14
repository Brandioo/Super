package com.travelagency.tirana.service.Impl.ReservationImpl;

import com.travelagency.tirana.model.Reservation;
import com.travelagency.tirana.model.Tour;
import com.travelagency.tirana.repository.ReservationRepository;
import com.travelagency.tirana.service.DestinationService;
import com.travelagency.tirana.service.Impl.TourImpl.SaveTourRequest;
import com.travelagency.tirana.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    private ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> getById(long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public long save(SaveReservationRequest request) {
        var dbReservation = reservationRepository.findById(request.getId());
        if (dbReservation.isPresent()) {
            dbReservation.get().setTourId(request.getTourId());
            dbReservation.get().setClientId(request.getClientId());
            dbReservation.get().setCheckInDate(request.getCheckInDate());
            dbReservation.get().setCheckOutDate(request.getCheckOutDate());
            dbReservation.get().setComment(request.getComment());
            dbReservation.get().setFinalPrice(request.getFinalPrice());
            reservationRepository.save(dbReservation.get());
            return dbReservation.get().getId();
        }
        var newReservation = new Reservation();
        newReservation.setTourId(request.getTourId());
        newReservation.setClientId(request.getClientId());
        newReservation.setCheckInDate(request.getCheckInDate());
        newReservation.setCheckOutDate(request.getCheckOutDate());
        newReservation.setComment(request.getComment());
        newReservation.setFinalPrice(request.getFinalPrice());
        reservationRepository.save(newReservation);
        return newReservation.getId();
    }

    @Override
    public void delete(long ReservationId) {
        var dbReservation = reservationRepository.findById(ReservationId).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
        reservationRepository.delete(dbReservation);
    }
}
