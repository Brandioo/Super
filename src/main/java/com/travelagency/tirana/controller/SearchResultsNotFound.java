package com.travelagency.tirana.controller;

import com.travelagency.tirana.service.Impl.InstagramImpl.InstagramService;
import lombok.var;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchResultsNotFound {
    InstagramService instagramService;

    public SearchResultsNotFound(InstagramService instagramService) {
        this.instagramService = instagramService;
    }

    @GetMapping("/search-results-not-found.html")
    public String showHello(final ModelMap modelMap) {


        var instagrams = this.instagramService.getAll();
        modelMap.addAttribute("instagrams", instagrams);

        return "search-results-not-found";
    }
}
