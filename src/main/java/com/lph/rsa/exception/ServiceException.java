package com.lph.rsa.exception;

import com.lph.rsa.Utils.StringUtil;

/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2018年4月12日  
**/
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
     private String code;
     private String message;
     
     
     public ServiceException(){
         super();
     }
     
     public ServiceException(String message){
         super(message);
     }
     
     public ServiceException(String errorCode, String message){
         super(message);
         this.code=errorCode;
     }
     
     public ServiceException(ServiceErrorEnum errorEnum){
         super(errorEnum.getMessage());
         this.code=errorEnum.getErrorCode();
         this.message=errorEnum.getMsg();
         
     }
     
     public ServiceException(ServiceErrorEnum errorEnum, String message){
         super(errorEnum.getMessage()+message);
         this.code=errorEnum.getErrorCode();
         this.message=message;
     }
     
     public ServiceException(ServiceErrorEnum errorEnum, Throwable e){
         super(e);
         this.code=errorEnum.getErrorCode();
         this.message=errorEnum.getMsg();
     }

     public String getErrorCode() {
         if(StringUtil.isEmpty(code)){
             return "20001";
         }
         return code;
     }

     public String getMessage() {
         if(StringUtil.isEmpty(message)){
             return super.getMessage(); 
         }
         return message;
     }
      
    public String getMsg(){
        
        return message;
    }

    public String getFullMsg(){
         return getMessage() +" " +message;
    }
    
    
    
    
    
}
  
    