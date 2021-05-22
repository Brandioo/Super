package com.travelagency.tirana.controller;

import com.travelagency.tirana.service.Impl.BannerImpl.BannerService;
import com.travelagency.tirana.service.Impl.InstagramImpl.InstagramService;
import com.travelagency.tirana.service.Impl.TourImpl.TourService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TravelFullListController {
    private BannerService bannerService;
    private InstagramService instagramService;
    private TourService tourService;

    public TravelFullListController(BannerService bannerService, InstagramService instagramService, TourService tourService) {
        this.bannerService = bannerService;
        this.instagramService = instagramService;
        this.tourService = tourService;
    }

    @GetMapping("/travel-list-full-width.html")
    public String showHello(final ModelMap modelMap) {

        var banners = this.bannerService.getAll();
        modelMap.addAttribute("banners", banners);

        var instagrams = this.instagramService.getAll();
        modelMap.addAttribute("instagrams", instagrams);

        var tours = this.tourService.getAll();
        modelMap.addAttribute("tours", tours);

        return "travel-list-full-width";
    }

}
