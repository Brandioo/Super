package com.travelagency.tirana.controller;

import com.travelagency.tirana.service.Impl.ReservationImpl.ReservationService;
import com.travelagency.tirana.service.Impl.TourImpl.TourService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TourDetailsController {
    private TourService tourService;

    public TourDetailsController(TourService tourService) {

        this.tourService = tourService;
    }

    @GetMapping("/details/{id}")
    public String showHello(final ModelMap modelMap, @PathVariable long id) {

        var tour = this.tourService.getById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
        modelMap.addAttribute("tour", tour);

        return "tour-page-right-sidebar";
    }
}
