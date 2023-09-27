package com.example.userresoucemanagement.controller;


import com.example.userresoucemanagement.entity.Project;
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
            projectService.addProject(project);
            return ResponseEntity.ok("Project added successfully");
        }
    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }



    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }

    @PutMapping
    public void updateProject(@RequestBody Project project) {
        projectService.updateProject(project);
    }

}


