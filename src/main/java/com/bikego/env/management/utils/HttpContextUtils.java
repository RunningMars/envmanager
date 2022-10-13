/**  
 * All rights Reserved, Copyright @ www.chinaso.com
 * @Title:  HttpContextUtils.java   
 * @Package com.chinaso.gateway.util
 * @Description:    TODO  
 * @author: harry(huanghonglin2008@foxmail.com)
 * @date:   Nov 23, 2018 11:26:50 AM   
 * @version V1.0 
 * @Copyright: 2018 www.chinaso.com Inc. All rights reserved.
 * 
 */
package com.bikego.env.management.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName:  HttpContextUtils   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harry huang 
 * @date:   Nov 23, 2018 11:26:50 AM   
 *     
 * @Copyright: 2018 www.chinaso.com. All rights reserved.
 */
public class HttpContextUtils {
	public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
	
	public static HttpServletResponse getHttpServletResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }
}
