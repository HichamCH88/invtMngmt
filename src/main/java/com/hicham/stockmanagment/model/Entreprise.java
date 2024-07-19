package com.hicham.stockmanagment.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="Enterprise")
public class Entreprise  extends AbstractEntity{


}
