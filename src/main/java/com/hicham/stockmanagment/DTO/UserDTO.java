package com.hicham.stockmanagment.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private Integer id;

    private String firstName;

    private String lastName;

    private AddressDTO address;

    private String email;

    private String phoneNum;
}
