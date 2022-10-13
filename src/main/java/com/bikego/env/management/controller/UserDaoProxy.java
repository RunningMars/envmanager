package com.bikego.env.management.controller;


import java.lang.reflect.Method;
import java.util.Arrays;

public class UserDaoProxy implements java.lang.reflect.InvocationHandler {
    //1 把创建的是谁的代理对象，把谁传递过来InvocationHandler
    // 有参数构造传递

     private Object obj;

     public UserDaoProxy(Object obj)
     {
        this.obj = obj;
     }

    // 增强的逻辑
     @Override
     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
     {
         //方法之前
         System.out.println("方法之前执行...."+method.getName()+" :传递的参数..."+ Arrays.toString(args));
         //被增强的方法执行
         Object res = method.invoke(obj, args);
         //方法之后
          System.out.println("方法之后执行...."+obj);

         return "res 1";
//         return res;
     }

}

