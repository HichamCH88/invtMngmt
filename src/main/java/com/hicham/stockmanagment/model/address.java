package com.hicham.stockmanagment.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@Embeddable
public class address {

    @Column(name = "address1")
    private String address1;
    @Column(name = "address2")
    private String address2;
    @Column(name = "city")
    private String city;
    @Column(name = "zipCode")
    private String zipCode;
    @Column(name = "Country")
    private String Country;


}
