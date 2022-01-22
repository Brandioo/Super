package com.travelagency.tirana.controller;

import com.travelagency.tirana.service.Impl.InstagramImpl.InstagramService;
import com.travelagency.tirana.service.Impl.ReservationImpl.ReservationService;
import com.travelagency.tirana.service.Impl.TeamMemberImpl.TeamMemberService;
import com.travelagency.tirana.service.Impl.TourImpl.TourService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AboutUsController {

    private InstagramService instagramService;
    private TeamMemberService teamMemberService;

    public AboutUsController(InstagramService instagramService, TeamMemberService teamMemberService) {
        this.instagramService = instagramService;
        this.teamMemberService = teamMemberService;
    }

    @GetMapping("/about-us.html")
    public String showHello(final ModelMap modelMap) {

        var instagrams = this.instagramService.getAll();
        modelMap.addAttribute("instagrams", instagrams);

        var teamMembers = this.teamMemberService.getAll();
        modelMap.addAttribute("teamMembers", teamMembers);

        return "about-us";
    }
}
