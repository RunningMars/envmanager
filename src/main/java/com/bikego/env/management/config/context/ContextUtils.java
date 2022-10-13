package com.bikego.env.management.config.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ContextUtils implements ApplicationContextAware {

    /**
     * 上下文
     */
    private static ApplicationContext appContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ContextUtils.appContext = applicationContext;

        System.out.print("注册成功");
        System.out.print(ContextUtils.appContext);
    }

    /**
     * 返回指定的类型
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> tClass) {
        if (appContext == null) {
            throw new RuntimeException("applicationContext注入失败");
        }
        return appContext.getBean(tClass);
    }

    public static Object getBean(String name) {
        if (appContext == null) {
            throw new RuntimeException("applicationContext注入失败");
        }
        return appContext.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> tClass) {
        if (appContext == null) {
            throw new RuntimeException("applicationContext注入失败");
        }

        return appContext.getBean(name, tClass);
    }

}
