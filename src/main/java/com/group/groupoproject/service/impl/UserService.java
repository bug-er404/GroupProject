package com.group.groupoproject.service.impl;


import com.group.groupoproject.DAO.UserRepository;
import com.group.groupoproject.models.Role;
import com.group.groupoproject.models.User;
import com.group.groupoproject.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findByUsername(String userName){
        return userRepository.findByUsername(userName);
    }

    public Role findRoleByUserName(String userName){
        User user = findByUsername(userName);

        return user.getRole();
    }


    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
