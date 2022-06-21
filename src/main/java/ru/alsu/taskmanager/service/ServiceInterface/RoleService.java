package ru.alsu.taskmanager.service.ServiceInterface;


import ru.alsu.taskmanager.model.Role;
import java.util.List;

public interface RoleService {
    Role createRole(Role role);

    List<Role> findAll();
}
