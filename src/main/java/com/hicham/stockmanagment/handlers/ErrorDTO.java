package com.hicham.stockmanagment.handlers;


import com.hicham.stockmanagment.exception.ErrorCode;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
 // class to be able to send our error Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDTO {

    private Integer httpCode; //to recive http error code

    private ErrorCode code;  //our application customized error code

    private String message; //the message we want to type

    private List<String> errors=new ArrayList<>();

}
