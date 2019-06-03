package com.lph.rsa.Utils;

import org.apache.tomcat.util.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @Description:
 * @Author: dingjl
 * @Date: 2018年4月16日
 **/
public class DesAlgorithmUtil {
	private static final String CHARSET = "UTF-8";
	
	private static final String Algorithm = "DESede";

	public static String encrypt(String plainText, String secretKey) throws Exception {
		DESKeySpec keySpec = new DESKeySpec(secretKey.getBytes(CHARSET));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(keySpec);
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(keySpec.getKey()));
		byte[] result = cipher.doFinal(plainText.getBytes(CHARSET));
		return new BASE64Encoder().encode(result);
	}

	public static String decrypt(String cipherText, String secretKey) throws Exception {
		DESKeySpec keySpec = new DESKeySpec(secretKey.getBytes(CHARSET));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(keySpec);
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(keySpec.getKey()));

		byte[] result = cipher.doFinal(new BASE64Decoder().decodeBuffer(cipherText));
		return new String(result, CHARSET);
	}

	//3DES加密
	public static String  encode3Des(String key,String srcStr){
		byte[] keybyte = key.getBytes();
		byte[] src = srcStr.getBytes();
		try {
			//生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, "DESede");
			//加密
			Cipher c1 = Cipher.getInstance("DESede");
			c1.init(Cipher.ENCRYPT_MODE, deskey);

			String pwd = Base64.encodeBase64String(c1.doFinal(src));
//           return c1.doFinal(src);//在单一方面的加密或解密
			return pwd;
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}catch(javax.crypto.NoSuchPaddingException e2){
			e2.printStackTrace();
		}catch(Exception e3){
			e3.printStackTrace();
		}
		return null;
	}

	// 3DES 解密
	public static String decode3Des(String key, String desStr) {
		Base64 base64 = new Base64();
		byte[] keybyte = key.getBytes();
		byte[] src = base64.decode(desStr);

		try {
			//生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, "DESede");
			//解密
			Cipher c1 = Cipher.getInstance("DESede");
			c1.init(Cipher.DECRYPT_MODE, deskey);
			String pwd = new String(c1.doFinal(src));
//            return c1.doFinal(src);
			return pwd;
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}
	// 3DESECB解密,key必须是长度大于等于 3*8 = 24 位哈
	public static String decrypt3DESCBC(final String src, final String key, final String offset) throws Exception {
		final DESedeKeySpec dks = new DESedeKeySpec(key.getBytes());//Base64.decodeBase64(key)
		final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		final SecretKey securekey = keyFactory.generateSecret(dks);
		final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, securekey, new IvParameterSpec(offset.getBytes()));
		
		final byte[] retByte = cipher.doFinal(Base64.decodeBase64(src));
		return new String(retByte);//Base64 hex ...最终byte[]转换结果,考量好
	}
	
	@SuppressWarnings("deprecation")
	 public static String decryptMode(String message, String key) {
	  String desMessage = null;
	  try {
	   BASE64Decoder dec = new BASE64Decoder();
	   byte[] messageBytes = dec.decodeBuffer(URLDecoder.decode(message));
	   SecretKey securekey = new SecretKeySpec(build3DesKey(key), Algorithm);
	   Cipher cipher = Cipher.getInstance(Algorithm);
	   cipher.init(Cipher.DECRYPT_MODE, securekey);
	   byte[] resultByte = cipher.doFinal(messageBytes);
	   desMessage = new String(resultByte);
	  } catch (java.security.NoSuchAlgorithmException ex) {
	   // log.error(ex.getMessage());
	  } catch (javax.crypto.NoSuchPaddingException ex) {
	   // log.error(ex.getMessage());
	  } catch (Exception ex) {
	   // log.error(ex.getMessage());
	  }
	  if (StringUtil.isEmpty(desMessage)) {
	   throw new RuntimeException("Decrypt failed");
	  }
	  return desMessage;
	 }
	 private static byte[] build3DesKey(String keyStr) throws UnsupportedEncodingException {
	  byte[] key = new byte[24]; // 声明一个24位的字节数组，默认里面都是0
	  byte[] temp = keyStr.getBytes(CHARSET); // 将字符串转成字节数组
	  if (key.length > temp.length) {
	   System.arraycopy(temp, 0, key, 0, temp.length);
	  } else {
	   System.arraycopy(temp, 0, key, 0, key.length);
	  }
	  return key;
	 }


}











