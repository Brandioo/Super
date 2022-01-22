package com.travelagency.tirana.controller;

import com.travelagency.tirana.model.Reservation;
import com.travelagency.tirana.service.Impl.ReservationImpl.SaveReservationRequest;
import com.travelagency.tirana.service.Impl.ReservationImpl.ReservationService;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/reservations")
public class ReservationController {
    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @GetMapping
    public List<Reservation> getAll () {
        return reservationService.getAll();
    }

    @PostMapping
    public long save(@RequestBody SaveReservationRequest request) {
        return reservationService.save(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> geReservationById (@PathVariable long id){
        var result = reservationService.getById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation ( @PathVariable long id){
        reservationService.delete(id);
    }
}
