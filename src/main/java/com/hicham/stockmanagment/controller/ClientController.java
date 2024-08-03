package com.hicham.stockmanagment.controller;

import com.hicham.stockmanagment.DTO.ClientDTO;
import com.hicham.stockmanagment.controller.api.ClientApi;
import com.hicham.stockmanagment.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController implements ClientApi {

    ClientService clientService;

    @Autowired
    ClientController(ClientService clientService){
        this.clientService=clientService;
    }

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        System.out.println(clientDTO.getFirstName()+clientDTO.getAddress());
        return this.clientService.save(clientDTO);
    }
}
