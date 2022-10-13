package com.bikego.env.management.controller.testCase.part18;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AOP {

    /**
     * AOP
     */
    @Test
    public void t0()
    {
        Dog target = new GunDog();
        var dog = (Dog)MyProxyFactory.getProxy(target);
        dog.info();
        dog.run();
    }

    /**
     *
     */
}

interface Dog{
    void info();
    void run();
}

class GunDog implements Dog{
    @Override
    public void info() {
        System.out.println("是一只金毛");
    }
    @Override
    public void run() {
        System.out.println("跑得快");
    }
}

class DogUtil{
    public void method1()
    {
        System.out.println("=====模拟第1个通用方法=====");
    }
    public void method2()
    {
        System.out.println("=====模拟第2个通用方法=====");
    }
}

class MyInvocationHandler2 implements InvocationHandler
{
    private Object target;

    public void setTarget(Object target)
    {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        var tool = new DogUtil();

        tool.method1();

        Object result = method.invoke(target,args);

        tool.method2();

        return result;
    }
}

class MyProxyFactory{
    public static Object getProxy(Object target)
    {
        MyInvocationHandler2 myInvocationHandler2 = new MyInvocationHandler2();
        myInvocationHandler2.setTarget(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),myInvocationHandler2);
    }
}