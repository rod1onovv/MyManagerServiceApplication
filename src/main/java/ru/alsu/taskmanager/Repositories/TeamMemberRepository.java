package ru.alsu.taskmanager.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alsu.taskmanager.model.TeamMember;

import java.util.List;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, String> {

    public List<TeamMember> findAllByProjectId(String projectId);

    public TeamMember findTeamMemberById(String teamMemberId);

}

