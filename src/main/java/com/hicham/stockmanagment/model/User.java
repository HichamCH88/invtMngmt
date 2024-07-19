package com.hicham.stockmanagment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="User")
public class User extends AbstractEntity{

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Embedded
    private address address;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumbre")
    private String phoneNum;
}
