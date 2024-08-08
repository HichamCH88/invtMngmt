package com.hicham.stockmanagment.controller.api;

import com.hicham.stockmanagment.DTO.ClientOrderDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ClientOrderApi {

    @PostMapping(value = "clientorders/create")
    ClientOrderDTO save(@RequestBody ClientOrderDTO clientOrderDTO);

    @GetMapping(value = "clientorders")
    List<ClientOrderDTO> findAll();

    @GetMapping(value = "clientsorders/{id}")
    ClientOrderDTO findById(@PathVariable("id") Integer id);

    @GetMapping(value = "clientsorders/c{code}")
    ClientOrderDTO findByCode(@PathVariable("code") String id);

    @DeleteMapping(value="clientorders/{id}")
    void deleteById(@PathVariable("id") Integer id);

}
