package com.travelagency.tirana.controller;

import com.travelagency.tirana.service.Impl.BannerImpl.BannerService;
import com.travelagency.tirana.service.Impl.BlogImpl.BlogService;
import com.travelagency.tirana.service.Impl.DestinationImpl.DestinationService;
import com.travelagency.tirana.service.Impl.InstagramImpl.InstagramService;
import com.travelagency.tirana.service.Impl.TourImpl.TourService;
import lombok.var;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private TourService tourService;
    private DestinationService destinationService;
    private BannerService bannerService;
    private BlogService blogService;
    private InstagramService instagramService;

    public HomeController(InstagramService instagramService, TourService tourService, DestinationService destinationService,
                          BannerService bannerService, BlogService blogService) {
        this.tourService = tourService;
        this.destinationService = destinationService;
        this.bannerService = bannerService;
        this.blogService = blogService;
        this.instagramService = instagramService;
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

        var blogs = this.blogService.getAll();
        modelMap.addAttribute("blogs", blogs);

        var instagrams = this.instagramService.getAll();
        modelMap.addAttribute("instagrams", instagrams);


        return "index";
    }

}
