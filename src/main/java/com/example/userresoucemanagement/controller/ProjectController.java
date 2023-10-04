package com.example.userresoucemanagement.controller;


import com.example.userresoucemanagement.entity.Project;
import com.example.userresoucemanagement.exceptions.ProjectNotFoundException;
import com.example.userresoucemanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/projects")
    public class ProjectController {

        @Autowired
        private ProjectService projectService;

        @PostMapping("/add")
        public ResponseEntity<String> addProject(@RequestBody Project project) {

            System.out.println(project);
 projectService.addProject(project);
            return ResponseEntity.ok("Project added successfully");
        }
    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        try {
            Project project = projectService.getProjectById(id);
            return ResponseEntity.ok(project);
        } catch (ProjectNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve project with ID " + id + ": " + e.getMessage());
        }
    }

    @GetMapping("/user/{username}")
    public List<Project> getProjectByUsername(@PathVariable String username) {
        return projectService.getProjectsForUser(username);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok("Successfully deleted the project");
    }

    @PutMapping
    public ResponseEntity<String> updateProject(@RequestBody Project project) {

            projectService.updateProject(project);

            return ResponseEntity.ok("Successfully updated the project");
    }

}


