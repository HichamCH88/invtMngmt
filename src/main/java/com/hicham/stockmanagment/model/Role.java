package com.hicham.stockmanagment.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="Role")
public class Role extends AbstractEntity {
}
