/**  
 * All rights Reserved, Copyright @ www.chinaso.com
 * @Title:  ExceptionCode.java   
 * @Package com.chinaso.appstore.common.exception
 * @Description:    错误码常量
 * @author: harry(huanghonglin2008@foxmail.com)
 * @date:   Sep 18, 2020 10:13:40 AM
 * @version V1.0 
 * @Copyright: 2020 www.chinaso.com Inc. All rights reserved.
 * 
 */
package com.bikego.env.management.exception;

import java.util.HashMap;
import java.util.Map;

/**   
 * @ClassName:  ExceptionCode   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harry huang 
 * @date:   Sep 18, 2020 10:13:40 AM
 *     
 * @Copyright: 2018 www.chianso.com. All rights reserved.
 */
public class Code {
	public final static int SUCCESS = 0;
	public final static int INTERNAL_ERROR = 500;
	public final static int NOTFOUND_ERROR = 404;
	
	public final static int PARAM_ERROR = 1000;
	public final static int PARAM_REQUIRED = 1001;
	public final static int PARAM_TYPE_ERROR = 1002;

	
	public final static int DB_NOT_EXISTED = 2000;
	public final static int DB_OP_ERROR = 2001;
	public final static int DB_EXISTED = 2002;
    public final static int DB_DELETE_ERROR = 2003;
	
	public final static int LOGIN_FAIL = 3000;
	public final static int LOGIN_REQUIRED = 3001;

	public final static int CODE_SEND_SUCCESS = 4000;
	public final static int VERIFY_CODE_FREQUENTLY = 4001;
	public final static int VERIFY_CODE_TIMEOUT = 4002;
	public final static int VERIFY_CODE_ERROR = 4003;
	public final static int VERIFY_CODE_USED = 4004;

	public final static int CODE_SEND_ERROR = 4005;
	public final static int TOKEN_INVALIDATED = 4006;
	public final static int PHONE_VERIFICATION_FAILED = 4007;

	public final static int PHONE_TYPE_ERROR = 4100;
    public final static int PHONE_NOT_EXISTED = 4101;
    public final static int PHONE_INVALID = 4102;
	public final static int PHONE_EXISTED = 4106;
	public final static int PHONE_IS_DELETE = 4105;
	public final static int REGISTER_FAILED = 4107;
	public final static int PHONE_PASSWORD_ERROR = 4108;
	public final static int PASSWORD_ERROR = 4109;


	public final static int INTERFACE_CALL_EXCEPTION = 5000;
	public final static int EMAIL_URL_ERROR = 5001;
	public final static int EMAIL_URL_BOUND = 5002;

	public final static int NOT_PERMISSION = 5004;
	public final static int EXISTS_PUBLISH_APP = 8001;
	
	private final static Map<Integer, String> map = new HashMap<Integer, String>();
	static {
		map.put(SUCCESS, "操作成功");
        map.put(INTERNAL_ERROR, "系统繁忙,请稍后再试...");
		map.put(NOTFOUND_ERROR, "NOT FOUND");

		map.put(PARAM_ERROR, "参数%s错误");
		map.put(PARAM_REQUIRED, "参数%s缺失");
		map.put(PARAM_TYPE_ERROR, "参数%s类型错误");
		
		map.put(DB_NOT_EXISTED, "数据%s不存在");
		map.put(DB_OP_ERROR, "数据写入失败");
		map.put(DB_EXISTED, "数据%s已存在");
        map.put(DB_DELETE_ERROR, "数据%s删除失败");

		map.put(VERIFY_CODE_FREQUENTLY, "验证码发送频繁");
		map.put(VERIFY_CODE_TIMEOUT, "验证码失效");
		map.put(VERIFY_CODE_ERROR, "验证码错误");
		map.put(VERIFY_CODE_USED, "验证码已使用");
		map.put(CODE_SEND_ERROR, "验证码发送失败");
		map.put(CODE_SEND_SUCCESS, "验证码发送成功");

		map.put(TOKEN_INVALIDATED, "token校验失效");
        map.put(PHONE_VERIFICATION_FAILED, "用户认证检验失败");

        map.put(INTERFACE_CALL_EXCEPTION, "第三方接口异常");
        map.put(EMAIL_URL_ERROR, "邮箱地址不正确");
        map.put(EMAIL_URL_BOUND, "邮箱已被绑定");

        map.put(PHONE_TYPE_ERROR, "用户类型错误");
        map.put(PHONE_NOT_EXISTED, "账号不存在");
        map.put(PHONE_IS_DELETE, "账号已被删除或禁用");
		map.put(PHONE_INVALID, "手机号不合法");
		map.put(PHONE_EXISTED, "手机号已经注册");
		map.put(REGISTER_FAILED, "注册失败");
		map.put(PHONE_PASSWORD_ERROR, "用户名或密码错误");
		map.put(PASSWORD_ERROR, "密码错误");

		map.put(NOT_PERMISSION,"权限不足");

		map.put(EXISTS_PUBLISH_APP,"已存在发布成功的应用");

		/*map.put(NOT_GROUP_OWNER, "群管理权限不足");
		map.put(NOT_GROUP_MEMBER, "该用户不是群成员");
		map.put(NOT_QUIT_GROUP_OWNER, "群主不允许退出");
		map.put(MAX_GROUP_MEMBER_COUNT, "超过群成员上限%s");*/
	}
	
	public static String printf(Integer code, Object... args) {
		String f = map.get(code);
		if (f == null) {
			return "";
		} else {
			for (int i = 0; i < args.length; i++) {
				args[i] = " [" + args[i] + "] ";
			}
			return String.format(f, args);
		}
	}
	
	public static String getMsg(int code) {
		return map.get(code).replace("%s", "");
	}
}
