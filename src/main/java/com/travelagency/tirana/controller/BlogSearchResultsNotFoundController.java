package com.travelagency.tirana.controller;

import com.travelagency.tirana.service.Impl.InstagramImpl.InstagramService;
import lombok.var;
import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogSearchResultsNotFoundController {
    InstagramService instagramService;

    public BlogSearchResultsNotFoundController(InstagramService instagramService) {
        this.instagramService = instagramService;
    }

    @GetMapping("/blog-search-results-not-found.html")
    public String showHello(final ModelMap modelMap) {

        var instagrams = this.instagramService.getAll();
        modelMap.addAttribute("instagrams", instagrams);

        return "blog-search-results-not-found";
    }
}
