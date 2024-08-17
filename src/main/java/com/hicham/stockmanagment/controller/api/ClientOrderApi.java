package com.hicham.stockmanagment.controller.api;

import com.hicham.stockmanagment.DTO.ClientOrderDTO;
import com.hicham.stockmanagment.DTO.ClientOrderLineDTO;
import com.hicham.stockmanagment.Shared.Consts;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface ClientOrderApi {

    @PostMapping(value = Consts.APP_ROOT+"/clientorder/create")
    ClientOrderDTO save(@RequestBody ClientOrderDTO clientOrderDTO);

    @GetMapping(value =Consts.APP_ROOT+ "/clientorder/all")
    List<ClientOrderDTO> findAll();

    @GetMapping(value =Consts.APP_ROOT+ "/clientsorder/{id}")
    ClientOrderDTO findById(@PathVariable("id") Integer id);

    @GetMapping(value = Consts.APP_ROOT+"/clientsorder/c{code}")
    ClientOrderDTO findByCode(@PathVariable("code") String id);

    @DeleteMapping(value=Consts.APP_ROOT+ "/clientorder/{id}")
    void deleteById(@PathVariable("id") Integer id);

    @GetMapping(value = Consts.APP_ROOT+"/clientorder/order/{id}")
    List<ClientOrderLineDTO> findByOrderId(@PathVariable("id") Integer id);

}
