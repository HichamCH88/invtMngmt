package com.hicham.stockmanagment.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name="InvMv")
@EqualsAndHashCode(callSuper = true)
public class InvMv  extends AbstractEntity{
}
