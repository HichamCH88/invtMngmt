package com.hicham.stockmanagment.validator;

import com.hicham.stockmanagment.DTO.UserDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {
    public static List<String> validate(UserDTO userDTO){
        List<String> errors=new ArrayList<>();

        if(!StringUtils.hasLength(userDTO.getFirstName())){
            errors.add("Please insert user first name");
        }
        if(!StringUtils.hasLength(userDTO.getLastName())){
            errors.add("Please insert user last name");
        }
        if(!StringUtils.hasLength(userDTO.getEmail())){
            errors.add("Please insert user email");
        }
        if(!StringUtils.hasLength(userDTO.getAddress().getAddress1())){
            errors.add("Please insert user address");
        }
        if(!StringUtils.hasLength(userDTO.getPhoneNum())){
            errors.add("Please insert user phone number");
        }

        return errors;
    }
}
