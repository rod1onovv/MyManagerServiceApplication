package ru.alsu.taskmanager.model;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.PostLoad;

@Entity
public class TeamMember {

    @Id
    public String id;

    public String name;
    public String role;
    private String projectId;

    public TeamMember(String name, String role, String projectId) {
        this.name = name;
        this.role = role;
        this.projectId = projectId;
    }

    public TeamMember() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

}
