package com.bikego.env.management.filter;

import com.bikego.env.management.exception.Code;
import com.bikego.env.management.utils.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class MyResponseBody implements ResponseBodyAdvice {
    private static final Logger logger = LoggerFactory.getLogger(MyResponseBody.class);

    @Override
    public Object beforeBodyWrite(Object resBody, MethodParameter arg1, MediaType arg2, Class arg3, ServerHttpRequest req,
                                  ServerHttpResponse res) {
        //resBody就是controller方法中返回的值，对其进行修改后再return就可以了
        String uri = req.getURI().toString();
        if (resBody instanceof String) {
            return JSON.messageInfoString(Code.SUCCESS, "成功", (String) resBody).toJSONString();
        } else if (resBody instanceof JSON) { //全局异常处理在该Advice之前处理，会返回JSON数据，不做处理。
            return resBody;
        } else {
            if (uri.contains("swagger") || uri.contains("api-docs")) {
                return resBody;
            }
            return JSON.message(Code.SUCCESS, "成功", resBody);
        }
    }

    @Override
    public boolean supports(MethodParameter arg0, Class arg1) {
        //这里直接返回true,表示对任何handler的responsebody都调用beforeBodyWrite方法
        return true;
    }

}
