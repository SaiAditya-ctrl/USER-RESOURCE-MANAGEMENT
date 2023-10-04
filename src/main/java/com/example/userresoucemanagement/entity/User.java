package com.example.userresoucemanagement.entity;



import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
//import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
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


//    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//    private List<Project> projects = new ArrayList<>();


}