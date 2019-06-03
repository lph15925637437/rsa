package com.lph.rsa.Utils;


import com.lph.rsa.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author: lph
 * @date:  2019/6/3 17:17
 * @version V1.0
 */
public class DES {

	private static final Logger logger = LoggerFactory.getLogger(DES.class);

	public static String encrypt(String plainText, String secretKey) {
		String cipherText = null;
		try {
			cipherText = DesAlgorithmUtil.encrypt(plainText, StringUtil.filRight(secretKey, '0', 8));
		} catch (Exception e) {
			throw new ServiceException("加密错误：" + e.getMessage());
		}
		return cipherText;
	}
	
	public static String decrypt(String cipherText, String secretKey) {
		String plainText = null;
		try {
			plainText = DesAlgorithmUtil.decrypt(cipherText, StringUtil.filRight(secretKey, '0', 8));
		} catch (Exception e) {
			throw new ServiceException("解密错误：" + e.getMessage());
		}
		return plainText;
	}
	
	public static void main(String[] args) {
		String cipherText = encrypt("88888888", "100001");
		System.out.println(cipherText);
		
		String plainText = decrypt("n1UvYuaCHEeGLuDXQ0HsOQ==", "100001");
		System.out.println(plainText);
    }

}
