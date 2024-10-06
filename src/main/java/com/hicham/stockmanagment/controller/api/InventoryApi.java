package com.hicham.stockmanagment.controller.api;

import com.hicham.stockmanagment.DTO.InventoryDTO;
import com.hicham.stockmanagment.Shared.Consts;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface InventoryApi {

    @GetMapping(value= Consts.APP_ROOT+"/inventory/all")
    List<InventoryDTO> findAll();

    @GetMapping(value=Consts.APP_ROOT+"/inventory/{id}")
    InventoryDTO findById(@PathVariable("id") Integer id);

    @PostMapping(value=Consts.APP_ROOT+"/inventory/create")
    InventoryDTO save(@RequestBody InventoryDTO dto);


}
