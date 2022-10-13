/**  
 * All rights Reserved, Copyright @ www.chinaso.com
 * @Title:  CommonException.java
 * @Package com.chinaso.appstore.common.exception
 * @Description:    Code
 * @author: harry(huanghonglin2008@foxmail.com)
 * @date:   Dec 18, 2018 1:48:15 PM   
 * @version V1.0 
 * @Copyright: 2018 www.chinaso.com Inc. All rights reserved.
 * 
 */
package com.bikego.env.management.exception;

/**   
 * @ClassName:  CommonException
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harry huang 
 * @date:   Dec 18, 2018 1:48:15 PM   
 *     
 * @Copyright: 2018 www.chinaso.com. All rights reserved.
 */
public class CommonException extends BusinessException {

	public CommonException(int code, String msg) {
		super(code, msg);
	}
	
	public CommonException(int code) {
		super(code, Code.getMsg(code));
	}
	
	public CommonException() {
		
	}
	
	public static CommonException newf(int code, Object... args) {
		CommonException be = new CommonException();
		be.setCode(code);
		be.setMsg(Code.printf(code, args));
		return be;
	}

	/**   
	 * @Fields serialVersionUID : TODO  
	 */ 
	private static final long serialVersionUID = -1581691624996589202L;

}
