package com.example.userresoucemanagement.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "create_date")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "user_name_fk", referencedColumnName = "user_name")

//    @JsonBackReference
    private User user;




//    @ToString.Exclude
    @JsonIgnore
   @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ProjectResources",
            joinColumns = @JoinColumn(name = "project_id",referencedColumnName = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "resource_id",referencedColumnName = "resource_id")
    )
private List<Resource> resources = new ArrayList<>();
//}
}