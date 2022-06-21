package ru.alsu.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alsu.taskmanager.Repositories.ProjectRepository;
import ru.alsu.taskmanager.Repositories.UserRepository;
import ru.alsu.taskmanager.model.*;
import ru.alsu.taskmanager.service.ProjectService;
import ru.alsu.taskmanager.service.UserServiceImpl;
import javax.validation.Valid;

@Controller
public class DashboardController {

    @Autowired
    private final ProjectService projectService;

    @Autowired
    private final ProjectRepository projectRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserServiceImpl userService;

    public DashboardController(ProjectService projectService, ProjectRepository projectRepository,
                               UserRepository userRepository, UserServiceImpl userService) {
        this.projectService = projectService;
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/create-project")
    public String createProject(@Valid Project project,
                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "fragments/create-project-modal";
        }
        projectService.createProject(project);

        return "views/done";
    }


//    @PostMapping("/delete-project")
//    public String deleteProject(@ModelAttribute Project project) {
//
//        String id = project.getId();
//        projectService.deleteProject(id);
//
//        return "redirect:/";
//    }


}
