package ru.alsu.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.alsu.taskmanager.Repositories.ProjectRepository;
import ru.alsu.taskmanager.model.Project;
import ru.alsu.taskmanager.service.ProjectService;

import java.util.List;

@Controller
public class ProjectDetailsController {

    private final ProjectService projectService;
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectDetailsController(ProjectService projectService, ProjectRepository projectRepository) {
        this.projectService = projectService;
        this.projectRepository = projectRepository;
    }

    @GetMapping("/projects")
    public String listProjects(Model model) {
        List<Project> projectsList = projectRepository.findAll();

        model.addAttribute("projectList", projectsList);
        model.addAttribute("project", projectService.findAll());
        return "views/projects";
    }

    @GetMapping("project/delete/{id}")
    public String deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
        return "redirect:/projects";
    }

    @PostMapping("project/updateProject/{id}")
    public String updateProject(@PathVariable Long id, Project project) {
        projectService.updateProject(id, project);
        return "redirect:/projects";
    }

}
