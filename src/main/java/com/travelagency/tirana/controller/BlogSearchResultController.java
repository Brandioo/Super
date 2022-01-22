package com.travelagency.tirana.controller;

import com.travelagency.tirana.service.Impl.BlogImpl.BlogService;
import com.travelagency.tirana.service.Impl.InstagramImpl.InstagramService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogSearchResultController {

    InstagramService instagramService;
    BlogService blogService;

    public BlogSearchResultController(InstagramService instagramService, BlogService blogService) {
        this.instagramService = instagramService;
        this.blogService = blogService;
    }

    @GetMapping("/blog-search-results.html")
    public String showHello(final ModelMap modelMap) {

        var instagrams = this.instagramService.getAll();
        modelMap.addAttribute("instagrams", instagrams);

        var blogs = this.blogService.getAll();
        modelMap.addAttribute("blogs", blogs);

        return "blog-search-results";
    }
}
