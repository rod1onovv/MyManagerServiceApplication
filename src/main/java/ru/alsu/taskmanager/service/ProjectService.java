package ru.alsu.taskmanager.service;

import org.springframework.stereotype.Service;
import ru.alsu.taskmanager.Repositories.ProjectRepository;
import ru.alsu.taskmanager.model.Project;
import ru.alsu.taskmanager.model.User;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserServiceImpl userService;

    public ProjectService(ProjectRepository projectRepository, UserServiceImpl userService) {
        this.projectRepository = projectRepository;
        this.userService = userService;
    }


    public void createProject(Project project) {
        projectRepository.save(project);
    }


    public void updateProject(Long id, Project updatedProject){
        Project project = projectRepository.findProjectById(id);
        project.setName(updatedProject.getName());
        project.setDescription(updatedProject.getDescription());
        project.setManager(updatedProject.getManager());
        projectRepository.save(updatedProject);
    }

    public void deleteProject(Long id) {projectRepository.deleteById(id);}

    public List<Project> findAll() {return projectRepository.findAll();}

}
