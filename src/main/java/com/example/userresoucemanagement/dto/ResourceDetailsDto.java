package com.example.userresoucemanagement.dto;

import com.example.userresoucemanagement.entity.Formula;
import com.example.userresoucemanagement.entity.Resource;
import com.example.userresoucemanagement.entity.ResourceDetails;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class ResourceDetailsDto {


    private Long id;

    private String resourceName;

    private String resourceCode;

    private String resourceDescription;

    private Date creationDate;

    private Date modifiedDate;

    private Double resourceCost;
    private Resource resource;
    private List<Formula> formulas = new ArrayList<>();
public  ResourceDetailsDto(ResourceDetails resourceDetails,List<Formula> formulas){
    this.id = resourceDetails.getId();
    this.resourceName = resourceDetails.getResourceName();
    this.resourceCode = resourceDetails.getResourceCode();
    this.resourceDescription = resourceDetails.getResourceDescription();
    this.creationDate = resourceDetails.getCreationDate();
    this.modifiedDate = resourceDetails.getModifiedDate();
    this.resourceCost = resourceDetails.getResourceCost();
    this.resource = resourceDetails.getResource();
    this.formulas = formulas;


}

}