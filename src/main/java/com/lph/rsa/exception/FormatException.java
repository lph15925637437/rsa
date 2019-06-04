package com.lph.rsa.exception;


import com.lph.rsa.Utils.StringUtil;

/**
 * 自定义格式化异常
 * @author: lph
 * @date:  2019/6/4 9:44
 * @version V1.0
 */
public class FormatException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    private String code;
    
    private String message;
    
    
   public FormatException(){
       super();
   }
   
   public FormatException(String message){
       super(message);
   }
   
   public  FormatException(String errorCode,String message){
       super(message);
       this.code=errorCode;
   }
   
   public  FormatException(FormatErrorEnum errorEnum){
       super(errorEnum.getMessage());
       this.code=errorEnum.getErrorCode();
       this.message=errorEnum.getMsg();
       
   }
   
   public  FormatException(FormatErrorEnum errorEnum,String message){
       super(errorEnum.getMessage()+message);
       this.code=errorEnum.getErrorCode();
       this.message=message+errorEnum.getMessage();
   }
   
   public  FormatException(FormatErrorEnum errorEnum,Throwable e){
       super(e);
       this.code=errorEnum.getErrorCode();
       this.message=errorEnum.getMsg();
   }

   public String getErrorCode() {
       if(StringUtil.isEmpty(code)){
           return "30001";
       }
       return code;
   }

   public String getMessage() {
       if(StringUtil.isEmpty(message)){
           return super.getMessage(); 
        }
       return message;
   }
    
    
    
    
    
}
  
    