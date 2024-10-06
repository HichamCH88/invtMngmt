package com.hicham.stockmanagment.model.CodeSeq;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CodeSequence")
public class CodeSequence {

    @Id
    private Integer type; //0:for clientOrders, 1:for suppliersOrders,

    private Integer nextValue;

    private Integer restValue;
}
