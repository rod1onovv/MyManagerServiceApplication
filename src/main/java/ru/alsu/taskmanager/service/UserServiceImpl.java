package ru.alsu.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.alsu.taskmanager.model.Role;
import ru.alsu.taskmanager.model.User;
import ru.alsu.taskmanager.Repositories.RoleRepository;
import ru.alsu.taskmanager.Repositories.TaskRepository;
import ru.alsu.taskmanager.Repositories.UserRepository;
import ru.alsu.taskmanager.service.ServiceInterface.UserService;


import javax.transaction.Transactional;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private static final String ADMIN="ADMIN";
    private static final String USER="USER";
    private static final String MANAGER="MANAGER";

    private UserRepository userRepository;
    private TaskRepository taskRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private Role role;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           TaskRepository taskRepository,
                           RoleRepository roleRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByRole(USER);
        user.setRoles(new ArrayList<>(Collections.singletonList(userRole)));
        return userRepository.save(user);
    }

    @Override
    public User changeRoleToManager(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role managerRole = roleRepository.findByRole(MANAGER);
        user.setRoles(new ArrayList<>(Collections.singletonList(managerRole)));
        return userRepository.save(user);
    }

    @Override
    public User changeRoleToUser(User user) {
        Role userRole = roleRepository.findByRole(USER);
        user.setRoles(new ArrayList<>(Collections.singletonList(userRole)));
        return userRepository.save(user);
    }


    @Override
    public User changeRoleToAdmin(User user) {
        Role adminRole = roleRepository.findByRole(ADMIN);
        user.setRoles(new ArrayList<>(Collections.singletonList(adminRole)));
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean isUserEmailPresent(String email) {
        return userRepository.findByEmail(email) != null;
    }

//    @Transactional
//    public User updateUserById(Long id, UserDTO userToBeUpdate) {
//        User user;
//
//        Optional<User> userOptional = userRepository.findUserById((long) id);
//
//        if(!userOptional.isPresent()){
//            throw new RuntimeException("Could not find user with the id: " + id);
//        } else {
//            user = userOptional.get();
//            user.setName(userToBeUpdate.name);
//            user.setEmail(userToBeUpdate.email);
//        }
//        return userRepository.save(user);
//    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.getOne(id);
        user.getTasksOwned().forEach(task -> task.setOwner(null));
        userRepository.delete(user);
    }

    @Transactional
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

//    @Transactional
//    public User saveUser(UserDTO userDTO) {
//        User userToBeSaved = new User(userDTO);
//        User userSaved = userRepository.save(userToBeSaved);
//        return userSaved;
//    }

    @Transactional
    public User secondGetUserById(Long id) {
        Optional<User> byId = userRepository.findUserById(id);
        if (byId.isPresent()){
            return byId.get();
        } else {
            throw new RuntimeException("Could not find a user with the id: " + id);
        }
    }

    @Transactional
    public User findByName(String name){
         return userRepository.findByName(name);
    }

    @Transactional
    public User getUserById(Long id){
        Optional<User> byId = userRepository.findUserById(id);

        if (byId.isPresent()){
            return byId.get();
        } else {
            throw new RuntimeException("Could not find a user with the id: " + id);
        }
    }
}

