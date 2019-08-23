package com.lph.rsa.exception;

public enum ApiErrorEnum {
    A_Application_Invalid("A10001","该应用无效!"),
    A_RequestParam_Invalid("A10001","参数格式错误,请检查请求参数!"),
    A_Sign_IsNotFind("A10003","签名算法类型目前不支持!"),
    A_Sign_Error("A10004","签名出错!"),
    A_ThirdHandler_Error("A10005","第三方处理错误!"),
    A_PayWay_NotFind("A10006","支付方式未找到!"),
    A_Application_NotHave("A10007","该应用未找到此订单!"),
    A_Application_NotFindDock("A10008","该应用未找到对应对接渠道!"),
    A_Application_InterfaceNotFind("A10009","该应用未找到对接方!"),
    A_Application_TradeNotFinish("A10010","订单状态未完成!"),
    A_Application_IOException("A10011","订单通知处理超时!"),
    A_Application_ServiceNotSupport("A10012","该应用服务目前不支持!"),
    A_Application_TimeOut("A10013","服务通讯超时!"),
	A_Application_Unionpay_Error("A10014","银联交易错误!"),
    A_Application_Recharge_GenetorOrderError("A10015","生成充值订单出现错误!"),
    A_Application_Recharge_EnterError("A10016","充值订单入账出错!"),
    A_Application_Version_Notsupported("A10017","一卡通版本目前不支持需要升级!"),
    A_Application_ConvertError("A10018","Map数据转换出错!"),
	A_Application_LSmart_Error("A10019","一码通交易错误!"),
	A_Application_CCB_Error("A10020","建行交易错误!"),
	A_Application_USERINFO_Error("A10021","用户未开启代扣应用!"),
	A_Application_Request_Error("A10022","非法请求!"),
	A_Application_DOCK_getOrderInfoError("A10023","获取一卡通订单信息失败!"),
	A_Application_DOCK_getPayOrderError("A10024","获取支付方订单失败或者支付方少扣!"),
	A_Application_CCBEMT_Error("A10025","建行e码通交易错误!"),
	A_Application_DECODE_Error("A10026","解码失败!"),
	A_Application_MOULDMSG_Error("A10027","发送模板消息请启用微信开发者模式!"),
	A_Application_MOULDMSG_UNABLE("A10028","该应用未启用该服务!"),
	A_Application_RechargePay_GenetorOrderError("A10029","生成充值消费订单出现错误!"),
	A_Application_Gyrel_Error("A10030","工银融e联交易错误!"),
	A_Application_CMB_Error("A10031","招行交易错误!"),
	A_Application_Again_Oauth("A10032","请回到应用页点击应用进行重新认证!"),
    ;
    private String errorCode;
    
    private String message;
    
    ApiErrorEnum(String code,String message){
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
