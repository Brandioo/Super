package com.travelagency.tirana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogRightSideBar {
    @GetMapping("/blog-right-sidebar.html")
    public String showHello(final ModelMap modelMap) {
        return "blog-right-sidebar";
    }
}
