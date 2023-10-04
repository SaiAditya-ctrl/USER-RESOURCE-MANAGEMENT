package com.example.userresoucemanagement.service;


import com.example.userresoucemanagement.entity.Resource;
import com.example.userresoucemanagement.userRepositry.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class ResourceService {

        @Autowired
        private ResourceRepository resourceRepository;

       public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public Resource getResourceById(Long id) {
        return resourceRepository.findById(id).orElse(null);
    }

    public Resource addResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
    }

    public void updateResource(Resource resource) {
        resourceRepository.save(resource);
    }


}


