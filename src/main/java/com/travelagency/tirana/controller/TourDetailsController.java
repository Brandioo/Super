package com.travelagency.tirana.controller;

import com.travelagency.tirana.service.Impl.ReservationImpl.ReservationService;
import com.travelagency.tirana.service.Impl.ReservationImpl.SaveReservationRequest;
import com.travelagency.tirana.service.Impl.TourImpl.TourService;
import lombok.var;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TourDetailsController {
    private TourService tourService;
    private ReservationService reservationService;

    public TourDetailsController(TourService tourService, ReservationService reservationService) {

        this.tourService = tourService;
        this.reservationService = reservationService;
    }

    @GetMapping("/details/{id}")
    public String showHello(final ModelMap modelMap, @PathVariable long id) {

        var tour = this.tourService.getById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
        modelMap.addAttribute("tour", tour);

        var request = new SaveReservationRequest();
        request.setTourId(tour.getId());
        request.setFinalPrice(tour.getPrice());

        modelMap.addAttribute("saveReservationRequest", request);

        return "tour-page-right-sidebar";
    }

    @PostMapping("/reserve")
    public ResponseEntity reserve(@Valid SaveReservationRequest request) {
        var result = reservationService.save(request);
        return ResponseEntity.ok(result);
    }
}
