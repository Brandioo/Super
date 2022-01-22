package com.travelagency.tirana.controller;

import com.travelagency.tirana.service.Impl.DestinationImpl.DestinationService;
import com.travelagency.tirana.service.Impl.InstagramImpl.InstagramService;
import com.travelagency.tirana.service.Impl.TourImpl.TourService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class DestinationDetailsController {

    private DestinationService destinationService;
    private TourService tourService;
    private InstagramService instagramService;

    public DestinationDetailsController(DestinationService destinationService, TourService tourService, InstagramService instagramService) {
        this.destinationService = destinationService;
        this.tourService = tourService;
        this.instagramService = instagramService;
    }

    @GetMapping("/destinations/{id}")
    public String showHello(final ModelMap modelMap, @PathVariable long id) {

        var destination = this.destinationService.getById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
        modelMap.addAttribute("destination", destination);

        var tour = this.tourService.getById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
        modelMap.addAttribute("tour", tour);

        var tours = this.tourService.getAll();
        modelMap.addAttribute("tours", tours);

        var instagrams = this.instagramService.getAll();
        modelMap.addAttribute("instagrams", instagrams);

        return "travel-list-full-width";
    }
}
