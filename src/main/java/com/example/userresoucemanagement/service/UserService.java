package com.example.userresoucemanagement.service;

import com.example.userresoucemanagement.entity.User;
import com.example.userresoucemanagement.userRepositry.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private userRepository userRepository;


    public List<User> getAllUsers() {

        return userRepository.findAll();
    }



    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }
}
