/**  
 * All rights Reserved, Copyright @ www.chinaso.com
 * @Title:  StringUtils.java   
 * @Package com.chinaso.appstore.common.util
 * @Description:    TODO  
 * @author: harry(huanghonglin2008@foxmail.com)
 * @date:   Dec 10, 2018 4:30:07 PM   
 * @version V1.0 
 * @Copyright: 2018 www.chinaso.com Inc. All rights reserved.
 * 
 */
package com.bikego.env.management.utils;

import java.util.Random;

/**
 * @ClassName:  StringUtils   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harry huang 
 * @date:   Dec 10, 2018 4:30:07 PM   
 *     
 * @Copyright: 2018 www.chinaso.com. All rights reserved.
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
	//方法五：用ascii码 
	public static boolean isNumeric(String str){
		if (isBlank(str))
			return false;
	    for(int i=str.length();--i>=0;){
	        int chr=str.charAt(i);
	        if(chr<48 || chr>57) {
	            return false;
	        }
	    }
	   return true;
	}

	/**
	 * 获取一个随机6位数
	 * @Author: sun JinShuang
	 * @Date: 2020/9/30
	 */
	public static String getCode() {
		Random rand = new Random();
		int a = rand.nextInt(1000000);
		String val = a + "000000";
		val = val.substring(0, 6);
		return val;
	}

	/**
	 * 校验字符串是否为空
	 * @Author: sun JinShuang
	 * @Date: 2020/9/30
	 */
	public static boolean isBlank(CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 截取字符串
	 *
	 * @param str 字符串
	 * @param start 开始
	 * @param end 结束
	 * @return 结果
	 */
	public static String substring(final String str, int start, int end)
	{
		if (str == null) { return ""; }
		if (end < 0) { end = str.length() + end; }
		if (start < 0) { start = str.length() + start; }
		if (end > str.length()) { end = str.length(); }
		if (start > end) { return ""; }
		if (start < 0) { start = 0; }
		if (end < 0) { end = 0; }
		return str.substring(start, end);
	}
}
