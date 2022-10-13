/**  
 * All rights Reserved, Copyright @ www.chinaso.com
 * @Title:  BusinessException.java   
 * @Package com.chinaso.appstore.common.exception
 * @Description: 异常处理
 * @author: harry(huanghonglin2008@foxmail.com)
 * @date:   Sep 18, 2020 10:07:20 AM
 * @version V1.0 
 * @Copyright: 2020 www.chinaso.com Inc. All rights reserved.
 * 
 */
package com.bikego.env.management.exception;

/**   
 * @ClassName:  BusinessException   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harry huang 
 * @date:   Dec 18, 2018 10:07:20 AM   
 *     
 * @Copyright: 2018 www.yunniao.cn. All rights reserved. 
 */
public class BusinessException extends RuntimeException {

	/**   
	 * @Fields serialVersionUID : TODO  
	 */ 
	private static final long serialVersionUID = 1815973071274297220L;
	
	private int code;
	
	private String msg;
	
	public BusinessException(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public BusinessException() {
		
	}
	
	@Override
    public Throwable fillInStackTrace() {
        return this;
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
