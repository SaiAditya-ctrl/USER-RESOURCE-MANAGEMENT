package com.example.userresoucemanagement.controller;

import com.example.userresoucemanagement.entity.ResourceDetails;
import com.example.userresoucemanagement.service.ResourceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ResourceDetailsContoller {
    @Autowired
    private ResourceDetailsService ResourceDetailsService;

    @GetMapping
    public List<ResourceDetails> getAllResourceDescriptions() {
        return ResourceDetailsService.getAllResourceDescriptions();
    }

    @GetMapping("/{id}")
    public ResourceDetails getResourceDescriptionById(@PathVariable Long id) {
        return ResourceDetailsService.getResourceDescriptionById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addResourceDescription(@RequestBody ResourceDetails resourceDescription) {
        ResourceDetailsService.addResourceDescription(resourceDescription);
        return ResponseEntity.ok("Resource Description added successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateResourceDescription(@RequestBody ResourceDetails resourceDetailsService) {
        ResourceDetailsService.updateResourceDescription(resourceDetailsService);
        return ResponseEntity.ok("Resource Description updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResourceDescription(@PathVariable Long id) {
        ResourceDetailsService.deleteResourceDescription(id);
        return ResponseEntity.ok("Resource Description deleted successfully");
    }
}
