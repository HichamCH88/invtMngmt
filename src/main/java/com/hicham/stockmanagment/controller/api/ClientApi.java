package com.hicham.stockmanagment.controller.api;

import com.hicham.stockmanagment.DTO.ClientDTO;
import com.hicham.stockmanagment.Shared.Consts;
import com.hicham.stockmanagment.model.Client;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ClientApi {

    @PostMapping(value = Consts.APP_ROOT+"/Client/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDTO save(@RequestBody ClientDTO dto );

    @GetMapping(value=Consts.APP_ROOT+"/Client/{id}")
    ClientDTO findById(@PathVariable("id") Integer id);


    @GetMapping(value = Consts.APP_ROOT+"/Client/all")
    List<ClientDTO> findAll();

    @DeleteMapping(value =Consts.APP_ROOT+"/Client/{id}")
    void delete(@PathVariable("id") Integer id);

}
