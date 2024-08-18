package com.hicham.stockmanagment.validator;

import com.hicham.stockmanagment.DTO.SupplierDTO;

import java.util.ArrayList;
import java.util.List;

public class SupplierValidator {

    public static List<String> validate(SupplierDTO supplierDTO){
        List<String> errors=new ArrayList<>();
        if(supplierDTO==null){
            errors.add("Null supplier value");
            return errors;
        }
        if(supplierDTO.getName()==null){
            errors.add("Name can not be null");
        }
        if(supplierDTO.getEmail()==null&&supplierDTO.getPhoneNum()==null){
            errors.add("please insert Supplier coordination");
        }
        return errors;
    }
}
