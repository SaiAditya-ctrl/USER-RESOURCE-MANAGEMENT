package com.example.userresoucemanagement.service;
import com.example.userresoucemanagement.entity.ResourceDetails;
import com.example.userresoucemanagement.userRepositry.ResourceDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceDetailsService {

    @Autowired
    private ResourceDetailsRepository resourceDetailsRepository;

    public List<ResourceDetails> getAllResourceDescriptions() {
        return resourceDetailsRepository.findAll();
    }

    public ResourceDetails getResourceDescriptionById(Long id) {
        return resourceDetailsRepository.findById(id).orElse(null);
    }

    public void addResourceDescription(ResourceDetails resourceDescription) {
        resourceDetailsRepository.save(resourceDescription);
    }

    public void updateResourceDescription(ResourceDetails resourceDescription) {
        resourceDetailsRepository.save(resourceDescription);
    }

    public void deleteResourceDescription(Long id) {
        resourceDetailsRepository.deleteById(id);
    }
}
