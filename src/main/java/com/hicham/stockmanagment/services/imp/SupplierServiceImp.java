package com.hicham.stockmanagment.services.imp;

import com.hicham.stockmanagment.DTO.SupplierDTO;
import com.hicham.stockmanagment.exception.EntityNotFoundException;
import com.hicham.stockmanagment.exception.ErrorCode;
import com.hicham.stockmanagment.exception.InvalidEntityException;
import com.hicham.stockmanagment.model.Supplier;
import com.hicham.stockmanagment.repository.SupplierRepository;
import com.hicham.stockmanagment.services.SupplierService;
import com.hicham.stockmanagment.validator.SupplierValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImp implements SupplierService {

    private static final Logger log = LoggerFactory.getLogger(SupplierServiceImp.class);
    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImp(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public SupplierDTO save(SupplierDTO dto) {
        List<String> errors= SupplierValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Invalid supplier");
            throw new InvalidEntityException("Invalid supplier", ErrorCode.SUPPLIER_NOT_Found,errors);
        }
        return SupplierDTO.fromEntity(supplierRepository.save(SupplierDTO.toEntity(dto)));
    }

    @Override
    public List<SupplierDTO> findAll() {

        return supplierRepository.findAll().stream().map(SupplierDTO::fromEntity).toList();
    }

    @Override
    public SupplierDTO findById(Integer id) {
        if(id==null){
            throw new InvalidEntityException("Supplier id is null");
        }
        Optional<Supplier> supplier=supplierRepository.findById(id);
        if(supplier.isEmpty()){
            throw new EntityNotFoundException("supplier not found",ErrorCode.SUPPLIER_NOT_Found);
        }

        return SupplierDTO.fromEntity(supplier.get());
    }

    @Override
    public void deleteById(Integer id) {
            supplierRepository.deleteById(id);
    }
}
