/**  
 * All rights Reserved, Copyright @ www.chinaso.com
 * @Title:  SecurityUtils.java   
 * @Package com.chinaso.appstore.common.util
 * @Description:    TODO  
 * @author: harry(huanghonglin2008@foxmail.com)
 * @date:   Dec 19, 2018 10:38:36 AM   
 * @version V1.0 
 * @Copyright: 2018 www.foxmail.com Inc. All rights reserved.
 * 
 */
package com.bikego.env.management.utils;

import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: SecurityUtils
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: harry huang
 * @date: Dec 19, 2018 10:38:36 AM
 * 
 * @Copyright: 2018 www.chinaso.com. All rights reserved.
 */
public class SecurityUtils {

	private final static Logger logger = LoggerFactory.getLogger(SecurityUtils.class);

	private final static String KEY_SHA = "SHA-256";

	public static String SHA(String plain) {
		byte[] inputData = plain.getBytes();
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
			messageDigest.update(inputData);
			return byte2Hex(messageDigest.digest());
		} catch (Exception e) {
			logger.error("SecurityUtils", e);
			return null;
		}
	}

	private static String byte2Hex(byte[] bytes) {
		StringBuffer stringBuffer = new StringBuffer();
		String temp = null;
		for (int i = 0; i < bytes.length; i++) {
			temp = Integer.toHexString(bytes[i] & 0xFF);
			if (temp.length() == 1) {
				stringBuffer.append("0");
			}
			stringBuffer.append(temp);
		}
		return stringBuffer.toString();
	}
}
