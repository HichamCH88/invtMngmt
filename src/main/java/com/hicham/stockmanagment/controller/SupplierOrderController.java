package com.hicham.stockmanagment.controller;

import com.hicham.stockmanagment.DTO.SupplierOrderDTO;
import com.hicham.stockmanagment.controller.api.SupplierOrderApi;
import com.hicham.stockmanagment.services.SupplierOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class SupplierOrderController implements SupplierOrderApi {

    private SupplierOrderService supplierOrderService;

    @Autowired
    public SupplierOrderController(SupplierOrderService supplierOrderService) {
        this.supplierOrderService = supplierOrderService;
    }

    @Override
    public SupplierOrderDTO save(SupplierOrderDTO supplierOrderDTO) {

        return supplierOrderService.save(supplierOrderDTO) ;
    }

    @Override
    public List<SupplierOrderDTO> findAll() {
        return supplierOrderService.findAll();
    }

    @Override
    public SupplierOrderDTO findById(Integer id) {
        return supplierOrderService.findById(id);
    }
}
