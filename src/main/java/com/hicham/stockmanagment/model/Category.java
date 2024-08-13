package com.hicham.stockmanagment.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="Category")
public class Category extends AbstractEntity {

    @Column(name="Code")
    private String categoryCode;

    @Column(name="Designation")
    private String CategoryDesignation;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Article> Articles;

}
