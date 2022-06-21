package ru.alsu.taskmanager.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alsu.taskmanager.model.NonFunctionalRequirement;

import java.util.List;

@Repository
public interface NonFunctionalReqRepository extends JpaRepository<NonFunctionalRequirement, String> {

    public List<NonFunctionalRequirement> findAllByProjectId(String projectId);

    public NonFunctionalRequirement findNonFunctionalRequirementById(String id);

}
