package com.example.userresoucemanagement.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resource_id")
    private Long resourceId;

    @Column(name = "resource_name")
    private String resourceName;

//    @ToString.Exclude
    @ManyToMany(mappedBy = "resources")
//    @JsonManagedReference
    private List<Project> projects = new ArrayList<>();

    @OneToOne(mappedBy = "resource",cascade = CascadeType.ALL)
    private ResourceDetails resourceDetails;

}
