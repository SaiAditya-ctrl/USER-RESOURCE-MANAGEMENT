package com.example.userresoucemanagement.entity;



import com.fasterxml.jackson.annotation.JsonManagedReference;
//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.management.relation.Role;


import jakarta.persistence.*;
import java.util.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    public enum Role {
        USER, ADMIN
    }

    @Id
    @Column(name = "user_name")
    private String userName;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String email;

    @Column(name = "create_date")
    private Date createDate;


    @ManyToMany(fetch =FetchType.LAZY ,cascade = CascadeType.ALL)
    @JoinTable(
            name = "UserProjects",
            joinColumns = @JoinColumn(name = "user_name"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )

    private List<Project> projects = new ArrayList<>();
}
