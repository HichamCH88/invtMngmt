package com.hicham.stockmanagment.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hicham.stockmanagment.model.Client;
import com.hicham.stockmanagment.model.ClientOrder;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class ClientDTO {

    private Integer id;

    private String firstName;

    private String lastName;

    private AddressDTO address;

    private String email;

    private String phoneNum;

    @JsonIgnore
    private List<ClientOrder> clientOrders;

    public static ClientDTO fromEntity(Client client){
        if (client==null){
            return null;
        }
        return ClientDTO.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .address(AddressDTO.fromEntity(client.getAddress()))
                .email(client.getEmail())
                .phoneNum(client.getPhoneNum())
                .build();
    }

    public static Client toEntity(ClientDTO dto){
        if (dto==null){
            return null;
        }
        Client client= Client.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .address(AddressDTO.toEntity(dto.getAddress()))
                .email(dto.getEmail())
                .phoneNum(dto.getPhoneNum())
                .build();
        client.setId(dto.getId());
        return client;
    }
}
