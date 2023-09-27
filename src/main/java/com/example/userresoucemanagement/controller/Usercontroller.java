package com.example.userresoucemanagement.controller;

import com.example.userresoucemanagement.entity.User;
import com.example.userresoucemanagement.service.ProjectService;
import com.example.userresoucemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Usercontroller {

    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users= userService.getAllUsers();

        return ResponseEntity.ok(users);
    }


@PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok("User added successfully");
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }


}
