package com.travelagency.tirana.controller;

import com.travelagency.tirana.service.Impl.InstagramImpl.InstagramService;
import com.travelagency.tirana.service.Impl.TourImpl.TourService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchResultController {

    TourService tourService;
    InstagramService instagramService;

    public SearchResultController(TourService tourService, InstagramService instagramService) {
        this.tourService = tourService;
        this.instagramService = instagramService;
    }


    @GetMapping("/search-results.html")
    public String showHello(final ModelMap modelMap) {

        var tours = this.tourService.getAll();
        modelMap.addAttribute("tours", tours);

        var instagrams = this.instagramService.getAll();
        modelMap.addAttribute("instagrams", instagrams);

        return "search-results";
    }
}
