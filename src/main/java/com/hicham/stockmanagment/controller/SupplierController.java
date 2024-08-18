package com.hicham.stockmanagment.controller;

import com.hicham.stockmanagment.DTO.SupplierDTO;
import com.hicham.stockmanagment.controller.api.SupplierApi;
import com.hicham.stockmanagment.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SupplierController implements SupplierApi {

    private SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @Override
    public SupplierDTO save(SupplierDTO dto) {
        return supplierService.save(dto) ;
    }

    @Override
    public List<SupplierDTO> findAll() {
        return List.of();
    }

    @Override
    public SupplierDTO findById(Integer id) {
        return null;
    }

    @Override
    public SupplierDTO deleteById(Integer id) {
        return null;
    }
}
