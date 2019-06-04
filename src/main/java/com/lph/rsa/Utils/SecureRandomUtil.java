package com.lph.rsa.Utils;

import java.security.SecureRandom;


/**
 * 随机生成字符串类
 * @author: lph
 * @date:  2019/6/3 20:16
 * @version V1.0
 */
public class SecureRandomUtil {

    public static SecureRandom random = new SecureRandom();

    /**
     *  生成带字母的字符串
     * @param length
     * @return
     */
    public static String getRandom(int length) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < length; i++) {
            boolean isChar = (random.nextInt(2) % 2 == 0);// 输出字母还是数字
            if (isChar) { // 字符串
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
                ret.append((char) (choice + random.nextInt(26)));
            } else { // 数字
                ret.append(Integer.toString(random.nextInt(10)));
            }
        }
        return ret.toString();
    }

    /**
     *  生成纯数字字符串
     * @param length
     * @return
     */
    public static String getRandomNum(int length) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < length; i++) {
            ret.append(Integer.toString(random.nextInt(10)));
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(getRandom(5));
    }

}
