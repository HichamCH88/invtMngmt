package com.hicham.stockmanagment.DTO;

import com.hicham.stockmanagment.model.Client;
import com.hicham.stockmanagment.model.ClientOrderLine;
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


    private List<ClientOrderLineDTO> clientOrderLines;
}
