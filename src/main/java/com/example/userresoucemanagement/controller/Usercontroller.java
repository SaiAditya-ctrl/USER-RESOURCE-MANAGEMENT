package com.example.userresoucemanagement.controller;

import com.example.userresoucemanagement.dto.UserResponse;
import com.example.userresoucemanagement.entity.Project;
import com.example.userresoucemanagement.entity.User;
import com.example.userresoucemanagement.exceptions.UserManagementException;
import com.example.userresoucemanagement.service.ProjectService;
import com.example.userresoucemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class Usercontroller {

    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            List<UserResponse> response = new ArrayList<>();
            for (User user : users) {
                List<Project> projects = projectService.getProjectsForUser(user.getUserName());
                UserResponse res = new UserResponse(user, projects);
                response.add(res);
            }
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new UserManagementException("Failed to retrieve users: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
//        try {
            User user = userService.getUserById(id);

            if (user != null) {
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }

//        } catch (Exception e) {
//            throw new UserManagementException("Failed to retrieve user: " + e.getMessage());
//        }
    }

    @PostMapping("/add")
    public ResponseEntity<UserResponse> addUser(@RequestBody User user) {
        try {
            user = userService.addUser(user);
            List<Project> projects = new ArrayList<>();
            UserResponse response = new UserResponse(user, projects);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new UserManagementException("Failed to add user: " + e.getMessage());
        }
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable String username) {
        try {
            userService.deleteUser(username);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e) {
            throw new UserManagementException("Failed to delete user: " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        try {
            userService.updateUser(user);
            return ResponseEntity.ok("User updated successfully");
        } catch (Exception e) {
            throw new UserManagementException("Failed to update user: " + e.getMessage());
        }
    }

}
