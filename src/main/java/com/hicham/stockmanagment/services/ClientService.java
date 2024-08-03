package com.hicham.stockmanagment.services;

import com.hicham.stockmanagment.DTO.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO save(ClientDTO clientDTO);

    ClientDTO findById(Integer id);


    ClientDTO update(ClientDTO clientDTO);

    List<ClientDTO> findAll();

    void delete(Integer id);

}
