package com.hicham.stockmanagment.controller.api;

import com.hicham.stockmanagment.DTO.SupplierOrderDTO;
import com.hicham.stockmanagment.Shared.Consts;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SupplierOrderApi {

    @PostMapping(value = Consts.APP_ROOT+"/supplierorder/create")
    public SupplierOrderDTO save(@RequestBody SupplierOrderDTO supplierOrderDTO);

    @GetMapping(value = Consts.APP_ROOT+"/supplierorder/all")
    public List<SupplierOrderDTO> findAll();

    @GetMapping(value = Consts.APP_ROOT+"/supplierorder/{id}")
    public SupplierOrderDTO findById(@PathVariable("id") Integer id);
}
