package com.lph.rsa.Utils;

import java.security.SecureRandom;
import java.util.Date;
import java.util.UUID;


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

    /**
     *  @param passLength : 要生成多少长度的字符串
     *  @param type      : 需要哪种类型
     *
     *  type=0：纯数字(0-9)
     *  type=1：全小写字母(a-z)
     *  type=2：全大写字母(A-Z)
     *  type=3: 数字+小写字母
     *  type=4: 数字+大写字母
     *  type=5：大写字母+小写字母
     *  type=6：数字+大写字母+小写字母
     *  type=7：固定长度33位：根据UUID拿到的随机字符串，去掉了四个"-"(相当于长度33位的小写字母加数字)
     */
    //asd
    public static String getCode(int passLength, int type) {
        StringBuffer buffer = null;
        StringBuffer sb = new StringBuffer();
        random.setSeed(new Date().getTime());
        switch (type) {
            case 0:
                buffer = new StringBuffer("0123456789");
                break;
            case 1:
                buffer = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
                break;
            case 2:
                buffer = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                break;
            case 3:
                buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyz");
                break;
            case 4:
                buffer = new StringBuffer("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                break;
            case 5:
                buffer = new StringBuffer("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
                break;
            case 6:
                buffer = new StringBuffer("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
                sb.append(buffer.charAt(random.nextInt(buffer.length() - 10)));
                passLength -= 1;
                break;
            case 7:
                String s = UUID.randomUUID().toString();
                sb.append(s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24));
        }

        if (type != 7) {
            int range = buffer.length();
            for (int i = 0; i < passLength; ++i) {
                sb.append(buffer.charAt(random.nextInt(range)));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getRandom(5));
        System.out.println(getRandomNum(14));
        System.err.println(getCode(10, 6));
    }

}
