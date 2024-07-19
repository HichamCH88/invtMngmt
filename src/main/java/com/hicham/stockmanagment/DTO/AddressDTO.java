package com.hicham.stockmanagment.DTO;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {


    private String address1;

    private String address2;

    private String city;

    private String zipCode;

    private String Country;
}
