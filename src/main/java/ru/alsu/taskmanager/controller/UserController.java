package ru.alsu.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.alsu.taskmanager.model.Role;
import ru.alsu.taskmanager.model.User;
import ru.alsu.taskmanager.service.ServiceInterface.RoleService;
import ru.alsu.taskmanager.service.ServiceInterface.UserService;

@Controller
public class UserController {

    private UserService userService;
    private RoleService roleService;
    private Role role;

    @Autowired
    public UserController(UserService userService,
                          RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public String listUsers(Model model, SecurityContextHolderAwareRequestWrapper request) {
        boolean isAdminSigned = request.isUserInRole("ROLE_ADMIN");
        boolean isUserSigned = request.isUserInRole("ROLE_USER");
        boolean isManagerSigned = request.isUserInRole("ROLE_MANAGER");

        model.addAttribute("users", userService.findAll());
        model.addAttribute("isAdminSigned", isAdminSigned);
        model.addAttribute("isUserSigned", isUserSigned);
        model.addAttribute("isManagerSigned", isManagerSigned);
        return "views/users";
    }

    @GetMapping("user/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("user/updateRoleUser/{id}")
    public String updateRoleUserAdmin(@PathVariable Long id){
        User user = userService.getUserById(id);
        userService.changeRoleToManager(user);
        return "redirect:/users";
    }

    @GetMapping("user/updateRoleUser_user/{id}")
    public String updateRoleUserUser(@PathVariable Long id){
        User user = userService.getUserById(id);
        userService.changeRoleToUser(user);
        return "redirect:/users";
    }


}
