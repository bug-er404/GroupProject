package com.group.groupoproject.controller;

import com.group.groupoproject.DAO.UserRepository;
import com.group.groupoproject.models.User;
import com.group.groupoproject.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/add")
    public User createUser(User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/getById/{id}")
    public User getUserDetailById(@PathVariable(value = "id") int userId) {
        return userService.findById(userId);
        //.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }

    @GetMapping(value = "/findByUserName")
    public User findByUserName(String username) {
        return userService.findByUsername(username);
    }

    @PutMapping("/updatePasswordById")
    public User updatePasswordById(int id, String password) {
        User user = userService.findById(id);
        user.setPassword(password);
        return userService.updateUser(user);
    }

    @PutMapping("/updateUserById/{id}")
    public User updateUserById(@PathVariable(value = "id") int userId,
                               User userDetails) {

        User user = userService.findById(userId);
        user.setUserName(userDetails.getUserName());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());

        User updatedUser = userService.saveUser(user);
        return updatedUser;
    }

    @Transactional
    @DeleteMapping("/deleteUserById/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable(value = "id") int userId) {
        userService.deleteById(userId);
        return ResponseEntity.ok().build();
    }

}
