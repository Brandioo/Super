package com.travelagency.tirana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TravelListLeftSideBarController {
    @GetMapping("/travel-list-left-sidebar.html")
    public String showHello(final ModelMap modelMap) {
        return "travel-list-left-sidebar";
    }
}
