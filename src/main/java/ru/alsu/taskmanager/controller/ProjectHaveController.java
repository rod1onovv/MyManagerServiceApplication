package ru.alsu.taskmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.alsu.taskmanager.Repositories.ProjectRepository;
import ru.alsu.taskmanager.model.Project;
import ru.alsu.taskmanager.model.User;
import ru.alsu.taskmanager.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectHaveController {

    private final ProjectRepository projectRepository;
    private final UserServiceImpl userService;

    public ProjectHaveController(ProjectRepository projectRepository, UserServiceImpl userService) {
        this.projectRepository = projectRepository;
        this.userService = userService;
    }

    @GetMapping("/project")
    public String showEmptyProjects(Model model){

        List<Project> projectList = new ArrayList<>();
        List<User> userList = new ArrayList<>();

        model.addAttribute("project", projectList);
        model.addAttribute("project", new Project());
        model.addAttribute("userList", userList);

        return "views/project-detail";
    }

    public void deleteProject(Long id) {projectRepository.deleteById(id);}

    public List<Project> findAll() {return projectRepository.findAll();}

}
