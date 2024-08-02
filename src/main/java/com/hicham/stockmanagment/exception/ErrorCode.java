package com.hicham.stockmanagment.exception;

public enum ErrorCode {

    ARTICLE_NOT_Found(1000),
    ARTICLE_NOT_Valid(1001),
    CATEGORY_NOT_Found(2000),
    CATEGORY_NOT_VALID(2001),
    CLIENT_NOT_Found(3000),
    CLIENTORDER_NOT_Found(4000),
    CLIENTORDERLINE_NOT_Found(5000),
    INVMV_NOT_Found(6000),
    SALE_NOT_Found(7000),
    SALELINE_NOT_Found(8000),
    SUPPLIER_NOT_Found(9000),
    SUPPLIERORDER_NOT_Found(10000),
    SUPPLIERORDERLINE_NOT_Found(11000),
    USER_NOT_Found(12000);

    //TODO complete the rest of errorcodes

    private int code;

    ErrorCode(int code){
        this.code=code;
    }
     public int getCode(){
        return code;
     }

}
