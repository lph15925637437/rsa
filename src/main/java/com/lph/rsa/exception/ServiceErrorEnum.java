package com.lph.rsa.exception;
/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2018年4月12日  
**/
public enum ServiceErrorEnum {
    SYS_VERIFYCODENINVALID("S10001","密码错误!"),
    ELEMENT_IS_REPEAT("S10002", "集合中有重复元素"),
    E_Sign_Error("S10003","签名出错了!"),
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
  
    