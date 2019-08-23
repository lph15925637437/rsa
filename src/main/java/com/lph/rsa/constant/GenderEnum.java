/*
 * Copyright (C), 2014-2017, u51.com
 * FileName: GenderEnum.java
 * Author:   chentao
 * Date:     2017年3月16日 下午3:22:22
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.lph.rsa.constant;


/**
 * 性别枚举
 *
 * @version V1.0
 * @author: lph
 * @date: 2019/8/23 9:31
 */
public enum GenderEnum {

    Unknown("0", "未知"),
    Male("1", "男性"),
    Female("2", "女性");

    private String sex;

    private String desc;

    private GenderEnum(String sex, String desc) {

        this.sex = sex;
        this.desc = desc;
    }

    public String getSex() {
        return sex;
    }

    public String getDesc() {
        return desc;
    }
}
