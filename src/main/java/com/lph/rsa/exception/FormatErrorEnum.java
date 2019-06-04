package com.lph.rsa.exception;
/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2018年4月12日  
**/
public enum FormatErrorEnum {
    Date_Format_Error("F10001","日期转换出现异常!"),
    Date_Format_IsNull("F10002","日期不能为空!"),
    Paramer_Format_Error("F10003","参数格式错误!"),
    Paramer_Format_IsNull("F10004","参数不能为空!"),
    Paramer_Format_length("F10005","参数长度过长!"),
    Passage_IsNull("F10006", "应用所属通道不能为空"),
    ;
    private String errorCode;
    
    private String message;
    
    FormatErrorEnum(String code,String message){
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
  
    