package ru.alsu.taskmanager.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alsu.taskmanager.Repositories.FunctionalReqRepository;
import ru.alsu.taskmanager.Repositories.NonFunctionalReqRepository;
import ru.alsu.taskmanager.model.FunctionalRequirement;
import ru.alsu.taskmanager.model.NonFunctionalRequirement;

import java.util.List;

@Service
public class RequirementService {

    @Autowired
    FunctionalReqRepository functionalReqRepository;

    @Autowired
    NonFunctionalReqRepository nonFunctionalReqRepository;

    public List<FunctionalRequirement> getAllFunctionalRequirementsByProjectId(String projectId) {
        return functionalReqRepository.findAllByProjectId(projectId);
    }

    public void createFunctionalRequirement(String requirement, String projectId) {

        FunctionalRequirement functionalRequirement = new FunctionalRequirement(requirement, projectId);
        functionalReqRepository.save(functionalRequirement);

    }

    public void deleteFunctionalRequirement(String id) {
        functionalReqRepository.deleteById(id);
    }

    public void updateFunctionalRequirement(String requirement, String id) {

        FunctionalRequirement functionalRequirement = functionalReqRepository.findFunctionalRequirementById(id);
        functionalRequirement.setRequirement(requirement);

        functionalReqRepository.save(functionalRequirement);
    }



    // *********** NON - FUNCTIONAL REQUIREMENT METHODS BELOW ************

    public List<NonFunctionalRequirement> getAllNonFunctionalRequirementsByProjectId(String projectId) {
        return nonFunctionalReqRepository.findAllByProjectId(projectId);
    }

    public void createNonFunctionalRequirement(String requirement, String projectId) {

        NonFunctionalRequirement nonFunctionalRequirement = new NonFunctionalRequirement(requirement, projectId);
        nonFunctionalReqRepository.save(nonFunctionalRequirement);

    }

    public void deleteNonFunctionalRequirement(String id) {
        nonFunctionalReqRepository.deleteById(id);
    }

    public void updateNonFunctionalRequirement(String requirement, String id) {

        NonFunctionalRequirement nonFunctionalRequirement = nonFunctionalReqRepository.findNonFunctionalRequirementById(id);
        nonFunctionalRequirement.setRequirement(requirement);

        nonFunctionalReqRepository.save(nonFunctionalRequirement);
    }


}
