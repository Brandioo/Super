package com.travelagency.tirana.controller;

import com.travelagency.tirana.model.Instagram;
import com.travelagency.tirana.model.TeamMember;
import com.travelagency.tirana.service.Impl.InstagramImpl.InstagramService;
import com.travelagency.tirana.service.Impl.InstagramImpl.SaveInstagramRequest;
import com.travelagency.tirana.service.Impl.TeamMemberImpl.SaveTeamMemberRequest;
import com.travelagency.tirana.service.Impl.TeamMemberImpl.TeamMemberService;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/teamMembers")
public class TeamMemberController {
    private TeamMemberService teamMemberService;

    public TeamMemberController(TeamMemberService teamMemberService) {
        this.teamMemberService = teamMemberService;
    }

    @PostMapping
    public long save(@RequestBody SaveTeamMemberRequest request) {
        return teamMemberService.save(request);
    }

    @GetMapping
    public List<TeamMember> getAll() {
        return teamMemberService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamMember> getDestinationById(@PathVariable long id) {
        var result = teamMemberService.getById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public void deleteDestination(@PathVariable long id) {
        teamMemberService.delete(id);
    }
}
