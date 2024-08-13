package com.hicham.stockmanagment.DTO;

import com.hicham.stockmanagment.model.Client;
import com.hicham.stockmanagment.model.ClientOrder;
import com.hicham.stockmanagment.model.ClientOrderLine;
import com.hicham.stockmanagment.model.Enums.OrderStatus;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
@Data
@Builder
public class ClientOrderDTO {

    private Integer id;

    private String code;

    private Instant orderDate;

    private ClientDTO client;

    private OrderStatus status;

    private List<ClientOrderLineDTO> clientOrderLines;


    public static ClientOrderDTO fromEntity(ClientOrder clientOrder){

        return   ClientOrderDTO.builder().id(clientOrder.getId())
                .code(clientOrder.getCode())
                .orderDate(clientOrder.getOrderDate())
                .client(ClientDTO.fromEntity(clientOrder.getClient()))
                .status(clientOrder.getStatus())
                .build();
    }
    public static ClientOrder toEntity(ClientOrderDTO clientOrderDTO){


        ClientOrder clientOrder= ClientOrder.builder().code(clientOrderDTO.getCode())
                .orderDate(clientOrderDTO.getOrderDate())
                .client(ClientDTO.toEntity(clientOrderDTO.getClient()))
                .status(clientOrderDTO.getStatus())
                .build();
        clientOrder.setId(clientOrderDTO.getId());
        return clientOrder;

    }
}
