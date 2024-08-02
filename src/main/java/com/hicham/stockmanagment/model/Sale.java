package com.hicham.stockmanagment.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="Sale")
public class Sale extends AbstractEntity {

    @Column(name="code")
    private String code;

    @OneToMany(mappedBy = "sale")
    private List <SaleLine> saleLines;
}
