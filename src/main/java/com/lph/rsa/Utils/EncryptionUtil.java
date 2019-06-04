package com.lph.rsa.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * 非对称加密工具类
 * @author: lph
 * @date:  2019/6/3 19:16
 * @version V1.0
 */
public class EncryptionUtil {

    public static final Logger log = LoggerFactory.getLogger(EncryptionUtil.class);
    public static final String ENCODE = "UTF-8";

    /**
     * 对字符串进行md5加密
     *
     * @param str
     * @return
     */
    public static String md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return byteToHex(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 对字符串进行sha256加密
     *
     * @param str
     * @return
     */
    public static String sha256(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(str.getBytes());
            return byteToHex(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 对字符串进行sha1加密
     *
     * @param str
     * @return
     */
    public static String sha1(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());
            return byteToHex(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String digest(String content) {
        return digest(content, ENCODE);

    }

    public static String digest(String content, String encoding) {
        content = content.trim();
        byte value[];
        try {
            value = content.getBytes(encoding);
        } catch (UnsupportedEncodingException e) {
            value = content.getBytes();
        }
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA");
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(), e);
            return null;
        }
        return ConvertUtils.toHex(md.digest(value));
    }

    /**
     * 字节数组转16进制字符串
     *
     * @param data
     * @return
     */
    public static String byteToHex(byte[] data) {
        final StringBuilder builder = new StringBuilder();
        for(byte b : data) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    public static void main(String[] args){
        String s = md5("123456");

        System.err.println(s);
    }
}
