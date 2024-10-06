package com.hicham.stockmanagment.controller.api;

import com.hicham.stockmanagment.DTO.ClientOrderDTO;
import com.hicham.stockmanagment.DTO.ClientOrderLineDTO;
import com.hicham.stockmanagment.Shared.Consts;
import com.hicham.stockmanagment.model.Enums.OrderStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hicham.stockmanagment.Shared.Consts.APP_ROOT;


public interface ClientOrderApi {

    @PostMapping(value = APP_ROOT+"/clientorder/create")
    ClientOrderDTO save(@RequestBody ClientOrderDTO clientOrderDTO);

    @GetMapping(value = APP_ROOT+ "/clientorder/all")
    List<ClientOrderDTO> findAll();

    @GetMapping(value = APP_ROOT+ "/clientorder/{id}")
    ClientOrderDTO findById(@PathVariable("id") Integer id);

    @GetMapping(value = APP_ROOT+"/clientorder/c/{code}")
    ClientOrderDTO findByCode(@PathVariable("code") String id);

    @DeleteMapping(value= APP_ROOT+ "/clientorder/{id}")
    void deleteById(@PathVariable("id") Integer id);

    @GetMapping(value = APP_ROOT+"/clientorder/order/{id}")
    List<ClientOrderLineDTO> findByOrderId(@PathVariable("id") Integer id);

    @GetMapping(value = APP_ROOT+"clientorder/client/{id}")
    List<ClientOrderDTO> findByClient(@PathVariable("id") Integer id);

    @GetMapping(value = APP_ROOT+"clientorder/status/{status}")
    List<ClientOrderDTO> findByOrderStatus(@PathVariable("status")OrderStatus status);
}
