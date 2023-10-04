package com.example.userresoucemanagement.controller;


import com.example.userresoucemanagement.entity.Resource;
import com.example.userresoucemanagement.entity.ResourceDetails;
import com.example.userresoucemanagement.service.ResourceDetailsService;
import com.example.userresoucemanagement.service.ResourceService;
import com.example.userresoucemanagement.userRepositry.ResourceDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/resources")
    public class ResourceController {

        @Autowired
        private ResourceService resourceService;

        @Autowired
        private ResourceDetailsRepository resourceDetailsRepository;
        @PostMapping("/add")
        public Resource addResource(@RequestBody Resource resource) {




          return resourceService.addResource(resource);


//            resourceDetails=resourceDetailsRepository.save(resourceDetails);
//            resource.setResourceDetails(resourceDetails);
//
//            return  resource;
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


