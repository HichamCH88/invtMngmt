package com.hicham.stockmanagment.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hicham.stockmanagment.model.Supplier;
import com.hicham.stockmanagment.model.SupplierOrder;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class SupplierDTO {

    private Integer id;

    private String Name;

    private AddressDTO address;

    private String email;

    private String phoneNum;

    @JsonIgnore
    private List<SupplierOrder> supplierOrders;

    public static SupplierDTO fromEntity(Supplier supplier){
        return SupplierDTO.builder().id(supplier.getId())
                .Name(supplier.getName())
                .address(AddressDTO.fromEntity(supplier.getAddress()))
                .email(supplier.getEmail())
                .phoneNum(supplier.getPhoneNum())
                .build();
    }

    public static Supplier toEntity(SupplierDTO dto){
        Supplier supplier = Supplier.builder().Name(dto.getName())
                .address(AddressDTO.toEntity(dto.getAddress()))
                .email(dto.getEmail())
                .phoneNum(dto.getPhoneNum())
                .build();
        supplier.setId(dto.getId());
        return supplier;

    }
}
