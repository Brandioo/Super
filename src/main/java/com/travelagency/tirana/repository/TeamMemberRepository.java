package com.travelagency.tirana.repository;

import com.travelagency.tirana.model.Instagram;
import com.travelagency.tirana.model.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
}
