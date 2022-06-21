package ru.alsu.taskmanager.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alsu.taskmanager.model.FunctionalRequirement;

import java.util.List;

@Repository
public interface FunctionalReqRepository extends JpaRepository<FunctionalRequirement, String> {

    public List<FunctionalRequirement> findAllByProjectId(String projectId);

    public FunctionalRequirement findFunctionalRequirementById(String id);

}