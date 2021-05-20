package com.travelagency.tirana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TravelListRightSideBarController {
    @GetMapping("/travel-list-right-sidebar.html")
    public String showHello(final ModelMap modelMap) {
        return "travel-list-right-sidebar";
    }
}
