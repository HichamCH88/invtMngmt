package com.hicham.stockmanagment.controller;

import com.hicham.stockmanagment.DTO.ClientOrderDTO;
import com.hicham.stockmanagment.controller.api.ClientOrderApi;
import com.hicham.stockmanagment.services.ClientOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientOrderController implements ClientOrderApi {

    ClientOrderService clientOrderService;

    @Autowired
    public ClientOrderController(ClientOrderService clientOrderService) {
        this.clientOrderService = clientOrderService;
    }

    @Override
    public ClientOrderDTO save(ClientOrderDTO clientOrderDTO) {
        return clientOrderService.save(clientOrderDTO);
    }

    @Override
    public List<ClientOrderDTO> findAll() {
        return clientOrderService.findAll();
    }

    @Override
    public ClientOrderDTO findById(Integer id) {
        return clientOrderService.findById(id);
    }

    @Override
    public ClientOrderDTO findByCode(String code) {
        return clientOrderService.findByCode(code);
    }

    @Override
    public void deleteById(Integer id) {
        clientOrderService.deleteById(id);
    }
}
