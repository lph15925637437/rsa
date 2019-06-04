package com.lph.rsa.Utils;

import com.lph.rsa.exception.FormatErrorEnum;
import com.lph.rsa.exception.FormatException;
import com.lph.rsa.exception.ServiceErrorEnum;
import com.lph.rsa.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.*;


public class CheckUtils {

	public static final Logger logger = LoggerFactory.getLogger(CheckUtils.class);

	public static final String COMMON_FIELD = "flowID,initiator,";


	/**
	 * 验证对象是否为NULL,空字符串，空数组，空的Collection或Map(只有空格的字符串也认为是空串)
	 * @param obj 被验证的对象
	 * @param message 异常信息
	 */
	@SuppressWarnings("rawtypes")
	public static void notEmpty(Object obj, String message) {
		if (obj == null){
			throw new IllegalArgumentException(message + " must be specified");
		}
		if (obj instanceof String && obj.toString().trim().length()==0){
			throw new IllegalArgumentException(message + " must be specified");
		}
		if (obj.getClass().isArray() && Array.getLength(obj)==0){
			throw new IllegalArgumentException(message + " must be specified");
		}
		if (obj instanceof Collection && ((Collection)obj).isEmpty()){
			throw new IllegalArgumentException(message + " must be specified");
		}
		if (obj instanceof Map && ((Map)obj).isEmpty()){
			throw new IllegalArgumentException(message + " must be specified");
		}
	}

	/**
	 * @description 检查字符串
	 * @param param 参数
	 * @param isNull ture 可以为空 false 不为空
	 * @param length 长度
	 * @param name 提示名称
	 *
	 *
	 * **/
	public  static  void checkString(String param,Boolean isNull,int length,String name){
		if(!isNull){
			if(StringUtil.isEmpty(param)){
				throw new FormatException(FormatErrorEnum.Paramer_Format_IsNull,name+"不能为空!");
			}
		}
		if(StringUtil.isEmpty(param)){
			int len=param.getBytes().length;
			if (length != 0) {
				if(len>length){
					throw new FormatException(FormatErrorEnum.Paramer_Format_length,name+"格式错误!");
				}
			}
		}

	}

	/**
	 *  校验集合中是否存在相同元素
	 *  result true表示不存在相同元素, false表示存在相同元素
	 * @param list
	 */
	public static void isRepeatElement(List<?> list) throws ServiceException{
		HashSet set = new HashSet<>(list);
		Boolean result = set.size() == list.size() ? true : false;

		if (!result) {
			throw new ServiceException(ServiceErrorEnum.ELEMENT_IS_REPEAT);
		}
	}

	public static void main(String[] args){
		try {
			notEmpty("", "传入的字符串不能为空");
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
		}
	}
	

}