///**
// * All rights Reserved, Copyright @ www.chinaso.com
// * @Title:  TokenValidator.java
// * @Package com.chinaso.appstore.admin.filter
// * @Description:
// * @author: harry(huanghonglin2008@foxmail.com)
// * @date:   Dec 19, 2018 10:59:04 AM
// * @version V1.0
// * @Copyright: 2018 www.chinaso.com Inc. All rights reserved.
// *
// */
//package com.bikego.messagecenter.filter;
//
//import com.bikego.messagecenter.exception.Code;
//import com.bikego.messagecenter.utils.JSON;
//import com.bikego.messagecenter.utils.JwtUtil;
//
//import java.io.IOException;
//import java.util.HashMap;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @ClassName: TokenValidator
// * @Description: 登陆token验证，token放在header中 eg. token:abcvdddafafXXXXX
// * @author: harry huang
// * @date: Dec 19, 2018 10:59:04 AM
// *
// * @Copyright: 2018 www.chinaso.com. All rights reserved.
// */
//
////@Component
//public class TokenValidatorFilter implements Filter {
//
//	@Override
//	public void destroy() {
//	}
//
//	@Override
//	public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
//	        throws IOException, ServletException {
//		HttpServletRequest request = (HttpServletRequest) srequest;
//		request.setCharacterEncoding("UTF-8");
//
//		((HttpServletResponse)sresponse).setContentType("application/json;UTF-8");
//		String path = request.getServletPath();
//		if (path.contains("auth")) {
//			filterChain.doFilter(srequest, sresponse);
//		} else {
//			//token在header中处理
//			String token = request.getHeader("token");
//			if (token == null) {
//				//测试环境跳过
//				if ("dev".equals(System.getProperty("spring.profiles.active"))) {
//					filterChain.doFilter(srequest, sresponse);
//				} else {
//					sresponse.getOutputStream().write(JSON.err(Code.LOGIN_REQUIRED, "未登陆").toJSONString().getBytes());
//				}
//			} else {
//				HashMap<String,String> data = JwtUtil.useVerityInfo(token);
//				Long userId = Long.valueOf(data.get("userId"));
//				String phone = data.get("mobilePhone");
//				request.setAttribute("userId",userId);
//				//request.getSession().setAttribute("userId",userId);
//				filterChain.doFilter(srequest, sresponse);
//				/*
//				User user = userService.isLogin(token);
//				if (user != null){
//					srequest.setAttribute("user", user);
//					filterChain.doFilter(srequest, sresponse);
//				} else {
//					sresponse.getOutputStream().write(info.qinxin.common.util.JSON.err(info.qinxin.common.exception.Code.LOGIN_REQUIRED, "未登陆").toJSONString().getBytes());
//				}
//
//			 */
//			}
//		}
//	}
//
//	@Override
//	public void init(FilterConfig arg0) throws ServletException {
//	}
//}
