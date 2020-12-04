package com.group.groupoproject.service;
import com.group.groupoproject.models.Role;
import com.group.groupoproject.models.User;

import java.util.List;


public interface UserServiceInterface {
    User findByUsername(String username);
    User findById(int id);
    User saveUser(User user);
    User updateUser(User user);
    List<User> findAll();
    void deleteById(int id);
    Role findRoleByUserName(String user_name);
}
