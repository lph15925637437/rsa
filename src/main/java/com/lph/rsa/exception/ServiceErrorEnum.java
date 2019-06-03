package com.lph.rsa.exception;
/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2018年4月12日  
**/
public enum ServiceErrorEnum {
    SYS_VERIFYCODENINVALID("S10001","密码错误!"),
    ; 
    
    private String errorCode;
    
    private String message;
    
    ServiceErrorEnum(String code, String message){
        this.errorCode=code;
        this.message=message;
    }

    public String getMessage(){
        return"[code="+errorCode+",message="+message+"]";
    }
    public String getErrorCode() {
    
        return errorCode;
    }
    
    public String getMsg(){
        return message;
    }
    
    
    
}
  
    