package com.bikego.env.management.controller.testCase.part18;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy {

    /**
     * 使用反射生成JDK动态代理在Java的java.lang.reflect包下提供了一个Proxy类和一个InvocationHandler接口，通过使用这个类和接口可以生成JDK动态代理类或动态代理对象。
     *
     * 提示：计算机是很“蠢”的，当程序使用反射方式为指定接口生成系列动态代理对象时，这些动态代理对象的实现类实现了一个或多个接口。动态代理对象就需要实现一个或多个接口里定义的所有方法，
     * 但问题是：系统怎么知道如何实现这些方法？这个时候就轮到InvocationHandler对象登场了——当执行动态代理对象里的方法时，实际上会替换成调用InvocationHandler对象的invoke方法。
     */
    @Test
    public void t0()
    {
        MyInvocationHandler handler = new MyInvocationHandler();
        Person2 p = (Person2) java.lang.reflect.Proxy.newProxyInstance(Person2.class.getClassLoader(), new Class[]{Person2.class}, handler);

        p.walk();
        p.sayHello("rrrdgg");
    }

}

interface Person2{
    void walk();
    void sayHello(String name);
}

class MyInvocationHandler implements InvocationHandler
{

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-----正在执行的方法:" + method);
        if (args != null)
        {
            System.out.println("下面执行该方法时传入的实参为:");
            for (var val:args)
            {
                System.out.println(val);
            }
        }else{
            System.out.println("调用该方法没有实参!");
        }
        return null;
    }
}
