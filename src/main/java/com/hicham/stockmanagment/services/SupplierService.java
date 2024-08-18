package com.hicham.stockmanagment.services;

import com.hicham.stockmanagment.DTO.SupplierDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SupplierService {

    public SupplierDTO save(SupplierDTO dto);

    public List<SupplierDTO> findAll();

    public SupplierDTO findById(Integer id);

    public void deleteById(Integer id);
}
