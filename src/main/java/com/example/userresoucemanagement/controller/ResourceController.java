package com.example.userresoucemanagement.controller;


import com.example.userresoucemanagement.entity.Resource;
import com.example.userresoucemanagement.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/resources")
    public class ResourceController {

        @Autowired
        private ResourceService resourceService;

        @PostMapping("/add")
        public ResponseEntity<String> addResource(@RequestBody Resource resource) {
            resourceService.addResource(resource);
            return ResponseEntity.ok("Resource added successfully");
        }
    @GetMapping
    public List<Resource> getAllResources() {
        return resourceService.getAllResources();
    }

    @GetMapping("/{id}")
    public Resource getResourceById(@PathVariable Long id) {
        return resourceService.getResourceById(id);
    }



    @DeleteMapping("/{id}")
    public void deleteResource(@PathVariable Long id) {
        resourceService.deleteResource(id);
    }

    @PutMapping
    public void updateResource(@RequestBody Resource resource) {
        resourceService.updateResource(resource);
    }
    }


