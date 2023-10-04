package com.example.userresoucemanagement.service;

import com.example.userresoucemanagement.dto.UserResponse;
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
//public UserResponse convertintoDTO(User user){
//        UserResponse response=new UserResponse();
//        response.setEmail(user.getEmail());
//        response.setCreateDate(user.getCreateDate());
//        response.setUserName(user.getUserName());
//        response.se
//}


    public User addUser(User user) {
        return userRepository.save(user);
    }
    public User getUserById(String id){
        return userRepository.getReferenceById(id);
    }

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }
}
