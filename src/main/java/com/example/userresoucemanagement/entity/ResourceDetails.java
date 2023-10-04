package com.example.userresoucemanagement.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
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
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String resourceName;

    private String resourceCode;

    private String resourceDescription;

    private Date creationDate;

    private Date modifiedDate;

    private Double resourceCost;
@JsonIgnore
    @OneToOne
    @JoinColumn(name = "resource_id",referencedColumnName = "resource_id")
    private Resource resource;
//

//    @OneToMany(mappedBy = "resourceDetails", cascade = CascadeType.ALL)
//    private List<Formula> formulas = new ArrayList<>();
////
//
//   public void addFormula(Formula formula) {
//      formulas.add(formula);
//      formula.setResourceDetails(this);
//
//   }
//
//   public void removeFormula(Formula formula) {
//      formulas.remove(formula);
//      formula.setResourceDetails(null);
//   }
}
