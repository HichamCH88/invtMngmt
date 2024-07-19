package com.hicham.stockmanagment.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@Table(name="InvMv")
@EqualsAndHashCode(callSuper = true)
public class InvMv  extends AbstractEntity{
}
