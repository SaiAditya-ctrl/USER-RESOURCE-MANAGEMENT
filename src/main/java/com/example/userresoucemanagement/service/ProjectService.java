package com.example.userresoucemanagement.service;


import com.example.userresoucemanagement.entity.Project;
import com.example.userresoucemanagement.userRepositry.ProjectRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class ProjectService {

        @Autowired
        private ProjectRepositry projectRepository;


    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public void addProject(Project project) {
        projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public void updateProject(Project project) {
        projectRepository.save(project);
    }
    }


