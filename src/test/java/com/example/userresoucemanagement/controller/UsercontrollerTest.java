package com.example.userresoucemanagement.controller;

import com.example.userresoucemanagement.entity.Project;
import com.example.userresoucemanagement.entity.User;
import com.example.userresoucemanagement.service.ProjectService;
import com.example.userresoucemanagement.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UsercontrollerTest {

    @Mock
    private UserService userService;
    @Mock
    private ProjectService projectService;
    @InjectMocks
    private Usercontroller usercontroller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllUsers() {
        List<User> expectedUserList = new ArrayList<>();
        when(userService.getAllUsers()).thenReturn(expectedUserList);
        ResponseEntity<List<User>> responseEntity = usercontroller.getAllUsers();
        assertEquals(responseEntity.getStatusCode(), HttpStatusCode.valueOf(HttpStatus.OK.value()));
        assertEquals(responseEntity.getBody(), expectedUserList);
    }


    @Test
    void addUser() {
        User user = mock(User.class);
        Mockito.doNothing().when(userService).addUser(user);
        ResponseEntity<String> responseEntity = usercontroller.addUser(user);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(responseEntity.getBody(), "User added successfully");
    }


    @Test
    void deleteUser() {
    }

    @Test
    void updateUser() {
    }
}