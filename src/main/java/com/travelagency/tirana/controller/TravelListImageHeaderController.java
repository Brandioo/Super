package com.travelagency.tirana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TravelListImageHeaderController {
    @GetMapping("/travel-list-image-header.html")
    public String showHello(final ModelMap modelMap) {
        return "travel-list-image-header";
    }
}
