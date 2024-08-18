package com.hicham.stockmanagment.services;

import com.hicham.stockmanagment.DTO.SupplierOrderDTO;
import com.hicham.stockmanagment.DTO.SupplierOrderLineDTO;

import java.util.List;

public interface SupplierOrderService {

    //save new supplier Order
    public SupplierOrderDTO save(SupplierOrderDTO dto);

    //get supplier Orders
    public List<SupplierOrderDTO> findAll();

    //get supplierOrder
    public SupplierOrderDTO findById(Integer id);

    //delete an order
    public void deleteById(Integer id);

    //get list of items in given order
    public List<SupplierOrderLineDTO> getOrderLines(Integer id);

}
