package com.hicham.stockmanagment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="Category")
public class Category extends AbstractEntity {

    @Column(name="Code")
    private String categoryCode;

    @Column(name="Designation")
    private String CategoryDesignation;

    @OneToMany(mappedBy = "category")
    private List<Article> Articles;

}
