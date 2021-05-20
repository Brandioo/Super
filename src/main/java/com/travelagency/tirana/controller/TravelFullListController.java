package com.travelagency.tirana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TravelFullListController {
    @GetMapping("/travel-list-full-width.html")
    public String showHello(final ModelMap modelMap) {
        return "travel-list-full-width";
    }

    @GetMapping("/details/{id}/travel-list-full-width.html")
    public String show(final ModelMap modelMap) {
        return "travel-list-full-width";
    }
}
