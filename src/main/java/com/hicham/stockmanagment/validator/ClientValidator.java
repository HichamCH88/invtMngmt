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
        if(!StringUtils.hasLength(clientDTO.getLastName())){
            errors.add("Please entre Client lastName");
        }
        if(!StringUtils.hasLength(clientDTO.getEmail())){
            errors.add("Please entre Client email");
        }
        if(!StringUtils.hasLength(clientDTO.getPhoneNum())){
            errors.add("Please entre Client phone number");
        }
        return errors;
    }
}
