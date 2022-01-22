package com.travelagency.tirana.controller;

import com.travelagency.tirana.service.Impl.InstagramImpl.InstagramService;
import com.travelagency.tirana.service.Impl.ReservationImpl.ReservationService;
import com.travelagency.tirana.service.Impl.TourImpl.TourService;
import lombok.var;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FavouritesController {

    InstagramService instagramService;
    TourService tourService;

    public FavouritesController(InstagramService instagramService, TourService tourService) {
        this.instagramService = instagramService;
        this.tourService = tourService;
    }

    @GetMapping("/favourites.html")
    public String showHello(final ModelMap modelMap) {

        var instagrams = this.instagramService.getAll();
        modelMap.addAttribute("instagrams", instagrams);

        var tours = this.tourService.getAll();
        modelMap.addAttribute("tours", tours);

        return "favourites";
    }
}
