package com.hicham.stockmanagment.validator;

import com.hicham.stockmanagment.DTO.ClientDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    public static List<String> validate(ClientDTO clientDTO){
        List<String> errors=new ArrayList<>();

        if(!StringUtils.hasLength(clientDTO.getFirstName())){
            errors.add("Please entre Client firstName");
        }
        return errors;
    }
}
