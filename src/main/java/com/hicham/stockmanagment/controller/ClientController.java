package com.hicham.stockmanagment.controller;

import com.hicham.stockmanagment.DTO.ClientDTO;
import com.hicham.stockmanagment.controller.api.ClientApi;
import com.hicham.stockmanagment.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController implements ClientApi {

    ClientService clientService;

    @Override
    public ClientDTO findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public List<ClientDTO> findAll() {
        return clientService.findAll();
    }

    @Override
    public void delete(Integer id) {
        clientService.delete(id);
    }

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
