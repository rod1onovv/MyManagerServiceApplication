package ru.alsu.taskmanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NonFunctionalRequirement {

    @Id
    public String id;

    public String requirement;

    public String projectId;

    public NonFunctionalRequirement() {}

    public NonFunctionalRequirement(String requirement, String projectId) {
        this.requirement = requirement;
        this.projectId = projectId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

}
