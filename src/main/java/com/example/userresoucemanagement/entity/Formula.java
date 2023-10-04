package com.example.userresoucemanagement.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Formula {

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String formulaName;

    private String formulaCostCode;

    private Boolean edited;

    @ManyToOne
    @JoinColumn(name = "resourceDetails_id",referencedColumnName = "id")
    private ResourceDetails resourceDetails;


}
