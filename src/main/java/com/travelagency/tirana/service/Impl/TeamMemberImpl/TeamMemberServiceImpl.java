package com.travelagency.tirana.service.Impl.TeamMemberImpl;

import com.travelagency.tirana.model.TeamMember;
import com.travelagency.tirana.repository.TeamMemberRepository;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {
    private TeamMemberRepository teamMemberRepository;

    public TeamMemberServiceImpl(TeamMemberRepository teamMemberRepository) {
        this.teamMemberRepository = teamMemberRepository;
    }

    @Override
    public long save(SaveTeamMemberRequest request) {
        var dbTeamMember = teamMemberRepository.findById(request.getId());
        if(dbTeamMember.isPresent()) {
            dbTeamMember.get().setName(request.getName());
            dbTeamMember.get().setPhoto(request.getPhoto());
            dbTeamMember.get().setRole(request.getRole());
            teamMemberRepository.save(dbTeamMember.get());
            return dbTeamMember.get().getId();
        }

        var newBanner = new TeamMember();
        newBanner.setName(request.getName());
        newBanner.setPhoto(request.getPhoto());
        newBanner.setRole(request.getRole());
        teamMemberRepository.save(newBanner);
        return newBanner.getId();
    }

    @Override
    public List<TeamMember> getAll() {
        return teamMemberRepository.findAll();
    }

    @Override
    public Optional<TeamMember> getById(long id) {
        return teamMemberRepository.findById(id);
    }

    @Override
    public void delete(long bannerId) {
        var dbBanner = teamMemberRepository.findById(bannerId).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
        teamMemberRepository.delete(dbBanner);
    }
}
