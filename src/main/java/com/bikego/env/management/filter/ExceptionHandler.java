/**  
 * All rights Reserved, Copyright @ www.chinaso.com
 * @Title:  ExceptionHandler.java   
 * @Package com.chinaso.appstore.admin.filter
 * @Description:    TODO  
 * @author: harry(huanghonglin2008@foxmail.com)
 * @date:   Dec 18, 2018 6:18:13 PM   
 * @version V1.0 
 * @Copyright: 2018 www.chinaso.com Inc. All rights reserved.
 * 
 */
package com.bikego.env.management.filter;

import com.bikego.env.management.exception.Code;
import com.bikego.env.management.exception.CommonException;
import com.bikego.env.management.utils.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName: ExceptionHandler
 * @Description:全局异常处理
 * @author: harry huang
 * @date: Dec 18, 2018 6:18:13 PM
 * 
 * @Copyright: 2018 www.chinaso.com. All rights reserved.
 */
@RestControllerAdvice
public class ExceptionHandler {
	
	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	
	@ResponseBody
	@org.springframework.web.bind.annotation.ExceptionHandler
	public JSON exceptionHandle(Exception e) { // 处理方法参数的异常类型
		if (e instanceof CommonException) {
			CommonException be = (CommonException)e;
			return JSON.err(be.getCode(), be.getMsg());
		} else if (e instanceof IllegalStateException) {
			return JSON.err(Code.PARAM_ERROR, "参数错误");
		} else {
			logger.error(e.getMessage(), e);
			return JSON.err(Code.INTERNAL_ERROR, "系统异常,请联系管理员处理");

		}
	}
}
