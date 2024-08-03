package com.hicham.stockmanagment.DTO;

import com.hicham.stockmanagment.model.Address;
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

    public static AddressDTO fromEntity(Address address){
        return AddressDTO.builder()
                .address1(address.getAddress1())
                .address2(address.getAddress2())
                .city(address.getCity())
                .zipCode(address.getZipCode())
                .Country(address.getCountry())
                .build();
    }
    public static Address toEntity(AddressDTO dto){
        return Address.builder()
                .address1(dto.getAddress1())
                .address2(dto.getAddress2())
                .city(dto.getCity())
                .zipCode(dto.getZipCode())
                .Country(dto.getCountry())
                .build();
    }

}
