package com.bikego.env.management.interceptor.auth;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bikego.env.management.context.ThreadContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String authInfo = request.getHeader("authInfo");
        if (authInfo == null) {
            return false;
        }

        // 将用户信息注入线路上下文
        JSONObject j = JSON.parseObject(authInfo);
        Map<String, JSONObject> map = new HashMap<>();
        map.put("authInfo", j);
        ThreadContext.set(map);
        return true;
    }
}
