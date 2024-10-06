package com.hicham.stockmanagment.controller;

import com.hicham.stockmanagment.DTO.InventoryDTO;
import com.hicham.stockmanagment.controller.api.InventoryApi;
import com.hicham.stockmanagment.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryController implements InventoryApi {

    @Autowired
    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Override
    public List<InventoryDTO> findAll() {
        return this.inventoryService.findAll();
    }

    @Override
    public InventoryDTO findById(Integer id) {
        return this.inventoryService.findByArticle(id);
    }

    @Override
    public InventoryDTO save(InventoryDTO dto) {
        return this.inventoryService.update(dto);
    }
}
