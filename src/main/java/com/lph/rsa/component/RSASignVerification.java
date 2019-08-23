package com.lph.rsa.component;

import com.lph.rsa.Utils.HzsunHashMap;
import com.lph.rsa.Utils.HzsunSignature;
import com.lph.rsa.constant.HzsunConstants;

/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2018年4月19日  
**/
public class RSASignVerification implements SignVerification{

    @Override
    public boolean verfiy(HzsunHashMap map, String sign, String publicKey, String charset, String signType) {
                //TODO  
        map.remove(HzsunConstants.SIGN);
        String content= HzsunSignature.getSignContent(map);
        return HzsunSignature.rsaCheck(content, sign, publicKey, charset, signType);
    }

    @Override
    public String rsa256Sign(HzsunHashMap content, String privateKey, String charset) {
        return HzsunSignature.rsa256Sign(HzsunSignature.getSignContent(content), privateKey,
                charset);
    }


}
  
    