/**  
 * All rights Reserved, Copyright @ www.chinaso.com
 * @Title:  JSON.java
 * @Package com.chinaso.appstore.common.admin.util
 * @Description:    TODO  
 * @author: harry(huanghonglin2008@foxmail.com)
 * @date:   Dec 6, 2018 10:01:13 AM   
 * @version V1.0 
 * @Copyright: 2018 www.chinaso.com Inc. All rights reserved.
 * 
 */
package com.bikego.env.management.utils;

import com.alibaba.fastjson.JSONObject;
import com.bikego.env.management.exception.Code;

/**   
 * @ClassName:  JsonPackage   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harry huang 
 * @date:   Sep 6, 2020 10:01:13 AM
 *     
 * @Copyright: 2020 www.chinaso.com. All rights reserved.
 */
public class JSON extends JSONObject {

	/**   
	 * @Fields serialVersionUID : TODO  
	 */ 
	private static final long serialVersionUID = -766482377518087041L;
	
	public final static String CODE = "code";
	public final static String MSG = "msg";
	public final static String INFO = "data";
	public final static int CODE_SUCC = Code.SUCCESS;

	public static JSON create(String key, Object value) {
		JSON jp = new JSON();
		jp.put(key, value);
		return jp;
	}
	
	public static JSON message(int code, String msg, Object info) {
		JSON jp = new JSON();
		jp.put(CODE, code);
		jp.put(MSG, msg);
		jp.put(INFO, info);
		return jp;
	}

	public static JSON messageInfoString(int code, String msg, String info) {
		JSON jp = new JSON();
		jp.put(CODE, code);
		jp.put(MSG, msg);
		jp.put(INFO, (String)info);
		return jp;
	}
	
	public static JSON err(int code, String msg) {
		JSON jp = new JSON();
		jp.put(CODE, code);
		jp.put(MSG, msg);
		return jp;
	}
	
	public static JSON succ() {
		JSON jp = new JSON();
		jp.put(CODE, CODE_SUCC);
		jp.put(MSG, "SUCCESS");
		return jp;
	}
	
	public JSON put(String key, Object value) {
		super.put(key, value);
		return this;
	}
	
	public JSON data(String key, Object value) {
		Object info = this.get(INFO);
		if (info == null) {
			JSON j = new JSON();
			j.put(key, value);
			info = j;
			this.put(INFO, info);
		} else {
			if (!(info instanceof JSON)) {
				throw new RuntimeException("JSON info is not JSON Object");
			}
			JSON d = (JSON) info;
			d.put(key, value);
		}
		return this;
	}
	
	public JSON data(Object data) {
		this.put(INFO, data);
		return this;
	}
	
	public JSON data() {
		Object info = this.get(INFO);
		if (info == null) {
			JSON j = new JSON();
			info = j;
			this.put(INFO, info);
		}
		return this;
	}
}
