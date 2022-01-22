package com.travelagency.tirana.service.Impl.TeamMemberImpl;

import com.travelagency.tirana.model.Instagram;
import com.travelagency.tirana.model.TeamMember;
import com.travelagency.tirana.service.Impl.InstagramImpl.SaveInstagramRequest;

import java.util.List;
import java.util.Optional;

public interface TeamMemberService {
    long save(SaveTeamMemberRequest request);
    List<TeamMember> getAll();
    Optional<TeamMember> getById(long id);
    void delete(long clientId);
}
