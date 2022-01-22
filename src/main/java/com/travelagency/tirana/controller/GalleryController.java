package com.travelagency.tirana.controller;

import com.travelagency.tirana.service.Impl.InstagramImpl.InstagramService;
import com.travelagency.tirana.service.Impl.ReservationImpl.ReservationService;
import com.travelagency.tirana.service.Impl.TourImpl.TourService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GalleryController {
    private InstagramService instagramService;

    public GalleryController(InstagramService instagramService) {
        this.instagramService = instagramService;
    }

    @GetMapping("/gallery.html")
    public String showHello(final ModelMap modelMap) {


        var instagrams = this.instagramService.getAll();
        modelMap.addAttribute("instagrams", instagrams);

        return "gallery";
    }
}
