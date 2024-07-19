package com.hicham.stockmanagment.DTO;

import com.hicham.stockmanagment.model.SupplierOrder;
import com.hicham.stockmanagment.model.address;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class SupplierDTO {

    private Integer id;
    private String firstName;

    private String lastName;

    private AddressDTO address;

    private String email;

    private String phoneNum;

    private List<SupplierOrder> supplierOrders;
}
