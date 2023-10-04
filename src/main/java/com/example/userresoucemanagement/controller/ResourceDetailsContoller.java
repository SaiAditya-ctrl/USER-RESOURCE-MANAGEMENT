package com.example.userresoucemanagement.controller;

import com.example.userresoucemanagement.dto.ResourceDetailsDto;
import com.example.userresoucemanagement.dto.UserResponse;
import com.example.userresoucemanagement.entity.Formula;
import com.example.userresoucemanagement.entity.Project;
import com.example.userresoucemanagement.entity.ResourceDetails;
import com.example.userresoucemanagement.entity.User;
import com.example.userresoucemanagement.exceptions.ResourceDetailsNotFoundException;
import com.example.userresoucemanagement.service.FormulaService;
import com.example.userresoucemanagement.service.ResourceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/resourcesDetails")
public class ResourceDetailsContoller {
    @Autowired
    private ResourceDetailsService resourceDetailsService;
    @Autowired
    private FormulaService formulaService;

    @GetMapping
    public ResponseEntity<List<ResourceDetailsDto>> getAllResourceDescriptions() {
        try {
            List<ResourceDetails> resourceDetails =resourceDetailsService.getAllResourceDescriptions();
            List<ResourceDetailsDto> response = new ArrayList<>();
            for (ResourceDetails resourceDetails1 : resourceDetails) {
                List<Formula> formulas = formulaService.getAllFormulas();
                List<Formula> selectedFormulas=new ArrayList<>();
//                for(Formula formulaList: formulas){
//                    if(formulaList.getP)
//                }
                ResourceDetailsDto res = new ResourceDetailsDto(resourceDetails1, formulas);
                response.add(res);
            }
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve resource descriptions: " + e.getMessage());
        }
    }
    @PostMapping("/add")
    public ResponseEntity<String> addResource(@RequestBody ResourceDetails resourceDetails){
System.out.println(resourceDetails);
        resourceDetailsService.addResourceDescription(resourceDetails);
        return ResponseEntity.ok("Succesfully inserted resource details");
    }

    @GetMapping("/{id}")
    public ResourceDetails getResourceDescriptionById(@PathVariable Long id) {
        try {
            return resourceDetailsService.getResourceDescriptionById(id);
        } catch (ResourceDetailsNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve resource description with ID " + id + ": " + e.getMessage());
        }
    }

    // Add similar exception handling for other methods...

    // ...
}
