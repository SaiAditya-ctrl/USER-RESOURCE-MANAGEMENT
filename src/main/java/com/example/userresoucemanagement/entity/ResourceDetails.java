package com.example.userresoucemanagement.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resourceName;

    private String resourceCode;

    private String resourceDescription;

    private Date creationDate;

    private Date modifiedDate;

    private Double resourceCost;

    // Establishing the many-to-one relationship with Resource
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @OneToMany(mappedBy = "resourceDescription")
    private List<Formula> formulas;



    // Getters and setters (omitted for brevity)
}
