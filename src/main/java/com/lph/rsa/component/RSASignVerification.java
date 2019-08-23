package com.lph.rsa.component;

import com.lph.rsa.Utils.HzsunHashMap;
import com.lph.rsa.Utils.HzsunSignature;
import com.lph.rsa.constant.HzsunConstants;


/**
 * @version V1.0
 * @author: lph
 * @date: 2019/8/23 15:40
 */
public class RSASignVerification implements SignVerification {

    @Override
    public boolean verfiy(HzsunHashMap map, String sign, String publicKey, String charset, String signType) {
        //TODO
        map.remove(HzsunConstants.SIGN);
        String content = HzsunSignature.getSignContent(map);
        return HzsunSignature.rsaCheck(content, sign, publicKey, charset, signType);
    }

    @Override
    public String rsa256Sign(HzsunHashMap content, String privateKey, String charset) {
        return HzsunSignature.rsa256Sign(HzsunSignature.getSignContent(content), privateKey,
                charset);
    }


}
  
    