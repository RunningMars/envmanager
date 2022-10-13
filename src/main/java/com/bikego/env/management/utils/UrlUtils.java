/**  
 * All rights Reserved, Copyright @ www.chinaso.com
 * @Title:  UrlUtils.java   
 * @Package com.chinaso.appstore.common.util
 * @Description:    TODO  
 * @author: harry(huanghonglin2008@foxmail.com)
 * @date:   Nov 21, 2018 10:39:41 AM   
 * @version V1.0 
 * @Copyright: 2018 www.foxmail.com Inc. All rights reserved.
 * 
 */
package com.bikego.env.management.utils;

/**   
 * @ClassName:  UrlUtils   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harry huang 
 * @date:   Nov 21, 2018 10:39:41 AM   
 *     
 * @Copyright: 2018 www.chinaso.com. All rights reserved.
 */
public class UrlUtils {

	public static String buildUrl(String host, int port, String path) {
		StringBuilder sb = new StringBuilder();
		sb.append("http://");
		sb.append(host);
		if (port != 80 && port > 0) {
			sb.append(':');
			sb.append(port);
		}
		sb.append(path);
		return sb.toString();
	}
	
	public static String buildUrl(String host, String path) {
		return buildUrl(host, -1, path);
	}
}
