package com.hicham.stockmanagment.services;

import com.hicham.stockmanagment.DTO.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO save(ClientDTO clientDTO);

    ClientDTO findById(ClientDTO clientDTO);

    ClientDTO findByCode(ClientDTO clientDTO);

    ClientDTO update(ClientDTO clientDTO);

    List<ClientService> findAll();

    void delete(Integer id);

}
