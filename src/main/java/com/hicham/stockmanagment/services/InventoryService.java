package com.hicham.stockmanagment.services;

import com.hicham.stockmanagment.DTO.InventoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface InventoryService {

    List<InventoryDTO> findAll();

    InventoryDTO findByArticle(Integer id);

    InventoryDTO update(InventoryDTO dto);

}
