package com.travelagency.tirana.controller;

import com.travelagency.tirana.service.Impl.ReservationImpl.ReservationService;
import com.travelagency.tirana.service.Impl.TourImpl.TourService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FourOFourController {

    @GetMapping("/404.html")
    public String showHello(final ModelMap modelMap) {
        return "404";
    }
}
