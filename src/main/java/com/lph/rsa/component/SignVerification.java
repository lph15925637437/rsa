package com.lph.rsa.component;


import com.lph.rsa.Utils.HzsunHashMap;

/**
 * 验签，加密
 * @author: lph
 * @date:  2019/8/23 14:53
 * @version V1.0
 */
public interface SignVerification {
    /**
     * @Description 校验签名认证信息
     * @param content 校验内容
     * @param sign 签名
     * @param publicKey 公钥
     * @param charset
     * @param signType 加密类型
     * @return 签名成功失败
     * **/
    boolean  verfiy(HzsunHashMap content, String sign, String publicKey, String charset, String signType);

    /**
     * 签名
     * @param content 签名内容
     * @param privateKey 加密私钥
     * @param charset 编码类型
     * @return
     */
    String rsa256Sign(HzsunHashMap content, String privateKey, String charset);
}
