package ru.alsu.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.alsu.taskmanager.Repositories.UserRepository;
import ru.alsu.taskmanager.model.Project;
import ru.alsu.taskmanager.model.User;
import ru.alsu.taskmanager.service.ServiceInterface.TaskService;
import ru.alsu.taskmanager.service.ServiceInterface.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class ProfileController {

    private final UserService userService;
    private final TaskService taskService;
    private final UserRepository userRepository;


    @Autowired
    public ProfileController(UserService userService, TaskService taskService, UserRepository userRepository) {
        this.userService = userService;
        this.taskService = taskService;
        this.userRepository = userRepository;
    }

    @GetMapping("/profile")
    public String showProfilePage(Model model, Principal principal) {
        String email = principal.getName();
        User user = userService.getUserByEmail(email);

        List<User> userList = userRepository.findAll();

        System.out.println("-----------------------");
        System.out.println(userList.get(1));

        model.addAttribute("user", user);
        model.addAttribute("users",userList);
        model.addAttribute("project", new Project());
        model.addAttribute("tasksOwned", taskService.findByOwnerOrderByDateDesc(user));
        return "views/profile";
    }

    @GetMapping("/profile/mark-done/{taskId}")
    public String setTaskCompleted(@PathVariable Long taskId) {
        taskService.setTaskCompleted(taskId);
        return "redirect:/profile";
    }

    @GetMapping("/profile/unmark-done/{taskId}")
    public String setTaskNotCompleted(@PathVariable Long taskId) {
        taskService.setTaskNotCompleted(taskId);
        return "redirect:/profile";
    }

}
