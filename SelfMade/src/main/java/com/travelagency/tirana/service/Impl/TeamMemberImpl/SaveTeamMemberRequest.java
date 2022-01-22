package com.travelagency.tirana.service.Impl.TeamMemberImpl;

import lombok.Data;

@Data
public class SaveTeamMemberRequest {
    private long id;
    private String name;
    private String photo;
    private String role;
}
