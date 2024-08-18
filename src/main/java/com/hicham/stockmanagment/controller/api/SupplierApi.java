package com.hicham.stockmanagment.controller.api;

import com.hicham.stockmanagment.DTO.SupplierDTO;
import com.hicham.stockmanagment.Shared.Consts;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface SupplierApi {
    @PostMapping(value = Consts.APP_ROOT+"/supplier/create")
    public SupplierDTO save(@RequestBody SupplierDTO dto);

    @GetMapping(value = Consts.APP_ROOT+"/supplier/all")
    public List<SupplierDTO> findAll();

    @GetMapping(value = Consts.APP_ROOT+"/supplier/{id}")
    public SupplierDTO findById(@PathVariable("id") Integer id);

    @DeleteMapping(value = Consts.APP_ROOT+"/supplier/{id}")
    public SupplierDTO deleteById(@PathVariable("id") Integer id);
}
