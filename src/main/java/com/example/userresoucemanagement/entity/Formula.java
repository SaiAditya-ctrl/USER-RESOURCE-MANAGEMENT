package com.example.userresoucemanagement.entity;




import jakarta.persistence.*;

@Entity
public class Formula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String formulaName;

    private String formulaCostCode;

    private Boolean edited;

    @ManyToOne
    @JoinColumn(name = "resource_description_id")
    private ResourceDetails resourceDescription;

}
