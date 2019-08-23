package com.lph.rsa.exception;

import com.lph.rsa.Utils.StringUtil;

public class ApiException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
     private String code;
     
     private String message;
     
     
    public ApiException(){
        
    }
    
    public ApiException(String message){
        super(message);
    }
    
    public  ApiException(String errorCode,String message){
        super(message);
        this.code=errorCode;
    }
    
    public  ApiException(ApiErrorEnum errorEnum){
        super(errorEnum.getMessage());
        this.code=errorEnum.getErrorCode();
        this.message=errorEnum.getMsg();
        
    }
    
    public  ApiException(ApiErrorEnum errorEnum,String message){
        super(errorEnum.getMessage()+message);
        this.code=errorEnum.getErrorCode();
        this.message=message;
    }
    
    public  ApiException(ApiErrorEnum errorEnum,Throwable e){
        super(e);
        this.code=errorEnum.getErrorCode();
        this.message=errorEnum.getMsg();
    }

    public String getErrorCode() {
        if(StringUtil.isEmpty(code)){
            return "10001";
        }
        return code;
    }

    public String getMessage() {
        if(StringUtil.isEmpty(message)){
           return super.getMessage(); 
        }
        return message;
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
        this.message=message;
    }

    
    
    
    
    
}