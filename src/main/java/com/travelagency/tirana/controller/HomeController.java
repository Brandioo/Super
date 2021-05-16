package com.travelagency.tirana.controller;

import com.travelagency.tirana.service.Impl.BannerImpl.BannerService;
import com.travelagency.tirana.service.Impl.DestinationImpl.DestinationService;
import com.travelagency.tirana.service.Impl.TourImpl.TourService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class HomeController {
    private TourService tourService;
    private DestinationService destinationService;
    private BannerService bannerService;

    public HomeController(TourService tourService, DestinationService destinationService, BannerService bannerService) {
        this.tourService = tourService;
        this.destinationService = destinationService;
        this.bannerService = bannerService;
    }

    @GetMapping("/")
    public String showHello(final ModelMap modelMap) {
//        modelMap.addAttribute("helloMsg", "hello in thymeleaf from model map");
//        modelMap.addAttribute("isSunny", true);
//        modelMap.addAttribute("fruits", Arrays.asList("Apple", "Banana", "Orange", "Cherry"));

        var tours = this.tourService.getAll();
        modelMap.addAttribute("tours", tours);


        var destinations = this.destinationService.getAll();
        modelMap.addAttribute("destinations", destinations);

        var banners = this.bannerService.getAll();
        modelMap.addAttribute("banners", banners);


        return "index";
    }

}
