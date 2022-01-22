package com.travelagency.tirana.service.Impl.ReservationImpl;

import com.travelagency.tirana.model.Client;
import com.travelagency.tirana.model.Reservation;
import com.travelagency.tirana.repository.ClientRepository;
import com.travelagency.tirana.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    private ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ClientRepository clientRepository) {
        this.reservationRepository = reservationRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> getById(long id) {
        return reservationRepository.findById(id);
    }

    @Transactional
    @Override
    public long save(SaveReservationRequest request) {
        var dbReservation = reservationRepository.findById(request.getId());
        if (dbReservation.isPresent()) {
            dbReservation.get().setTourId(request.getTourId());
            var client = clientRepository
                    .findById(dbReservation.get().getClientId()).orElseThrow(() -> new IllegalArgumentException("Invalid client id"));
            client.setName(request.getName());
            client.setEmail(request.getEmail());
            client.setPhoneNumber(request.getPhoneNumber());
            clientRepository.save(client);

            dbReservation.get().setCheckInDate(request.getCheckInDate());
            dbReservation.get().setCheckOutDate(request.getCheckOutDate());
            dbReservation.get().setComment(request.getComment());
            dbReservation.get().setFinalPrice(request.getFinalPrice());
            reservationRepository.save(dbReservation.get());
            return dbReservation.get().getId();
        }
        var newClient= new Client();
        newClient.setEmail(request.getEmail());
        newClient.setPhoneNumber(request.getPhoneNumber());
        newClient.setName(request.getName());
        clientRepository.save(newClient);

        var newReservation = new Reservation();
        newReservation.setTourId(request.getTourId());
        newReservation.setClientId(newClient.getId());
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
