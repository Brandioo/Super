package com.travelagency.tirana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TourPageRightSideBarWidthReplyController {
    @GetMapping("/tour-page-right-sidebar-width-reply.html")
    public String showHello(final ModelMap modelMap) {
        return "tour-page-right-sidebar-width-reply";
    }
}
