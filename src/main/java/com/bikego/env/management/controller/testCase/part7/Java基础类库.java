package com.bikego.env.management.controller.testCase.part7;

import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class Java基础类库 {

    /**
     * Scanner
     * 用Scanner类可以很方便地获取用户的键盘输入，Scanner是一 个基于正则表达式的文本扫描器，
     * 它可以从文件、输入流、字符串中解析出基本类型值和字符串值。Scanner类提供了多个构造器，
     * 不同的构造器可以接收文件、输入流、字符串作为数据源，用于从文件、输入流、字符串中解析数据。
     * Scanner主要提供了两个方法来扫描输入。
     * ➢ hasNextXxx()：是否还有下一个输入项，其中Xxx可以是Int、Long等代表基本数据类型的字符串。
     * 如果只是判断是否包含下一个字符串，则直接使用hasNext()。
     * ➢ nextXxx()：获取下一个输入项。Xxx的含义与前一个方法中的Xxx相同。
     */


    /**
     * System Runtime
     * Java程序在不同操作系统上运行时，可能需要取得平台相关的属性，或者调用平台命令来完成特定功能。
     * Java提供了System类和Runtime类来与程序的运行平台进行交互。
     * System类代表当前Java程序的运行平台，程序不能创建System类的对象，System类提供了一些类变量和类方法，
     * 允许直接通过System类来调用这些类变量和类方法。
     */

    @Test
    public void t1() throws IOException {
        Map<String, String> env = System.getenv();
        for (var name : env.keySet())
        {
            System.out.println(name + " = " + env.get(name));
        }

        System.out.println(System.getenv("JAVA_HOME"));
        Properties properties = System.getProperties();

        properties.store(new FileOutputStream("props.txt"),"System Properties");

        System.out.println(System.getProperty("os.name"));
    }

    @Test
    public void t2()
    {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());

        System.out.println(runtime.freeMemory());

        System.out.println(runtime.totalMemory());

        System.out.println(runtime.maxMemory());
    }

    @Test
    public void t3() throws IOException {
        Runtime runtime = Runtime.getRuntime();

        //java.io.IOException: Cannot run program "/Users/rdg/Desktop/fun.md": error=13, Permission denied
        //runtime.exec("/Users/rdg/Desktop/fun.md");

        //让电脑操作系统打开指定文件
        Desktop.getDesktop().open(new File("/Users/rdg/Desktop/fun.md"));

        //让电脑操作系统打开指定软件
        Desktop.getDesktop().open(new File("/System/Applications/Mail.app"));
    }

    @Test
    public void t4() throws CloneNotSupportedException {
        User user = new User();
        User user2 = user.clone();

        //false
        System.out.println(user == user2);
        /**
         * Object类
         * Object类提供的Clone机制只对对象里各实例变量进行“简单复制”，如果实例变量的类型是引用类型，
         * Object的Clone机制也只是简单地复制这个引用变量，这样原有对象的引用类型的实例变量与克隆对象的引用类型的实例变量依然指向内存中的同一个实例，
         * 所以下面程序处输出true。
         */
        //true
        System.out.println(user.address == user2.address);
    }

    /**
     * Objects工具类
     * Objects工具类，它提供了一些工具方法来操作对象，这些工具方法大多是“空指针”安全的。比如你不能确定一个引用变量是否为null，
     * 如果贸然地调用该变量的toString()方法，则可能引发NullPointerExcetpion异常；但如果使用Objects类提供的toString（Object o）方法，
     * 就不会引发空指针异常，当o为null时，程序将返回一个"null"字符串。
     */
    @Test
    public void t5()
    {
        User user = new User();
        System.out.println(Objects.hashCode(user));
        System.out.println(Objects.toString(user));
        user = null;
        System.out.println(Objects.requireNonNull(user,"user 不能为空"));
    }
}
class Address{
    public String detail;
    public Address(String s)
    {
        detail = s;
    }
}
class User implements Cloneable{
    public int age;
    public Address address;

    public User()
    {
        address = new Address("xinchuan");
    }

    public User clone() throws CloneNotSupportedException {
        User u = (User)super.clone();
        return u;
    }
}
