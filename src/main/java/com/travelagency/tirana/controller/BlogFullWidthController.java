package com.travelagency.tirana.controller;

import com.travelagency.tirana.service.Impl.BlogImpl.BlogService;
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
public class BlogFullWidthController {

    InstagramService instagramService;
    BlogService blogService;

    public BlogFullWidthController(InstagramService instagramService, BlogService blogService) {
        this.instagramService = instagramService;
        this.blogService = blogService;
    }

    @GetMapping("/blog-full-width.html")
    public String showHello(final ModelMap modelMap) {

        var instagrams = this.instagramService.getAll();
        modelMap.addAttribute("instagrams", instagrams);

        var blogs = this.blogService.getAll();
        modelMap.addAttribute("blogs", blogs);

        return "blog-full-width";
    }
}
