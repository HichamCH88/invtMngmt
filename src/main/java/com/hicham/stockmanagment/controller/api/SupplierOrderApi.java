package com.hicham.stockmanagment.controller.api;

import com.hicham.stockmanagment.DTO.SupplierOrderDTO;
import com.hicham.stockmanagment.Shared.Consts;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.hicham.stockmanagment.Shared.Consts.APP_ROOT;

public interface SupplierOrderApi {

    @PostMapping(value = APP_ROOT+"/supplierorder/create")
    public SupplierOrderDTO save(@RequestBody SupplierOrderDTO supplierOrderDTO);

    @GetMapping(value = APP_ROOT+"/supplierorder/all")
    public List<SupplierOrderDTO> findAll();

    @GetMapping(value = APP_ROOT+"/supplierorder/{id}")
    public SupplierOrderDTO findById(@PathVariable("id") Integer id);

    @GetMapping(value=APP_ROOT+"/supplierorder/supplier/{name}")
    public List<SupplierOrderDTO> findBySupplierName(@PathVariable("name") String name);
}
