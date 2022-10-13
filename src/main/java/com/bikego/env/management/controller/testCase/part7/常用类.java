package com.bikego.env.management.controller.testCase.part7;

import org.junit.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class 常用类 {

    /**
     * 字符串就是一连串的字符序列，Java提供了String、StringBuffer和StringBuilder三个类来封装字符串，并提供了一系列方法来操作字符串对象。
     * String类是不可变类，即一旦一个String对象被创建以后，包含在这个对象中的字符序列是不可改变的，直至这个对象被销毁。
     * StringBuffer对象则代表一个字符序列可变的字符串，当一个StringBuffer被创建以后，通过StringBuffer提供的append()、
     * insert()、reverse()、setCharAt()、setLength()等方法可以改变这个字符串对象的字符序列。
     * 一旦通过StringBuffer生成了最终想要的字符串，就可以调用它的toString()方法将其转换为一个String对象。
     * StringBuilder类是JDK 1.5新增的类，它也代表可变字符串对象。实际上，StringBuilder和StringBuffer基本相似，两个类的构造器和方法也基本相同。
     * 不同的是，StringBuffer是线程安全的，而StringBuilder则没有实现线程安全功能，所以性能略高。因此在通常 情况下，如果需要创建一个内容可变的字符串对象，
     * 则应该优先考虑使用StringBuilder类。
     */

    /**
     * Math类
     * 是一个工具类，它的构造器被定义成private的，因此无法创建Math类的对象；Math类中的所有方法都是类方法，可以直接通过类名来调用它们。
     * Math类除提供了大量静态方法之外，还提供了两个类变量：PI和E，正如它们名字所暗示的，它们的值分别等于π和e
     */

    /**
     * BigDecimal
     * 查看BigDecimal类的BigDecimal(double val)构造器的详细说明时，可以看到不推荐使用该构造器的说明，
     * 主要是因为使用该构造器时有一定的不可预知性。当程序使用new BigDecimal(0.1)来创建一个BigDecimal对象时，
     * 它的值并不是0.1，它实际上等于一个近似0.1的。这是因为0.1无法准确地表示为double浮点数，所以传入
     * BigDecimal构造器的值不会正好等于0.1（虽然表面上等于该值。如果使用BigDecimal(String val)构造器的结果是可预知的——
     * 写入new BigDecimal("0.1")将创建一个BigDecimal，它正好等于预期的0.1。因此通常建议优先使用基于String的构造器。
     * 如果必须使用double浮点数作为BigDecimal构造器的参数时，不要直接将该double浮点数作为构造器参数创建BigDecimal对象，
     * 而是应该通过BigDecimal.valueOf(double value)静态方法来创建BigDecimal对象。
     */
    @Test
    public void t1()
    {
        BigDecimal f1 = new BigDecimal("0.05");
        BigDecimal f2 = BigDecimal.valueOf(0.01);
        BigDecimal f3 = new BigDecimal(0.05);

        System.out.println(f1.add(f2));
        System.out.println(f1.subtract(f2));
        System.out.println(f1.multiply(f2));
        System.out.println(f1.divide(f2));

        System.out.println("********************");

        System.out.println(f3.add(f2));
        System.out.println(f3.subtract(f2));
        System.out.println(f3.multiply(f2));
        System.out.println(f3.divide(f2));
//        Calendar.YEAR
    }

    /**
     * Date
     * Java 8吸取了Joda-Time库（一个被广泛使用的日期、时间库）的经验，提供了一套全新的日期时间库。
     * 两个构造器如下。
     * ➢ Date()：生成一个代表当前日期时间的Date对象。该构造器在底层调用System.currentTimeMillis()获得long整数作为日期参数。
     * ➢ Date(long date)：根据指定的long型整数来生成一个Date对象。该构造器的参数表示创建的Date对象
     * 和GMT 1970年1月1日 00：00：00之间的时间差，以毫秒作为计时单位。
     *
     * Java 8专门新增了一个java.time包，该包下包含了如下常用的类。Clock,Duration,Instant,LocalDate,LocalTime,LocalDateTime ... 等
     */

    /**
     * 正则表达式
     */

    /**
     * Java 9 引入了一个新的VarHandle类，并增强了原有的MethodHandle类。通过这两个类，
     * 允许Java像动态语言一样引用变量、引用方法，并调用它们。
     */
    @Test
    public void t2() throws Throwable {
        MethodType methodType = MethodType.methodType(Void.class);
        MethodHandle methodHandle = MethodHandles.lookup().findStatic(MethodHandleTest.class, "hello",methodType );
        methodHandle.invoke();

        MethodHandle methodHandle1 = MethodHandles.lookup().findVirtual(MethodHandleTest.class, "hello", MethodType.methodType(String.class, String.class));
        methodHandle1.invoke(new MethodHandleTest(),"rdddgg");
    }
    @Test
    public void t3() throws Throwable {
        VarHandle varHandle = MethodHandles.lookup().findVarHandle(MethodHandleTest.class, "name", String.class);
        MethodHandleTest methodHandleTest = new MethodHandleTest();
        Object o = varHandle.get(methodHandleTest);
        varHandle.set(methodHandleTest,"rdg");
        System.out.println(o);

        Object o2 = varHandle.get(methodHandleTest);
        System.out.println(o);
        System.out.println(o2);

    }

    /**
     * 使用 DateTimeFormatter 格式化日期
     */
    @Test
    public void t4()
    {
        var formatters = new DateTimeFormatter[]{
                //直接使用常量创建格式器
                DateTimeFormatter.ISO_LOCAL_DATE,
                DateTimeFormatter.ISO_LOCAL_TIME,
                DateTimeFormatter.ISO_LOCAL_DATE_TIME,
                //使用本地化的不同风格来创建格式器
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL,FormatStyle.MEDIUM),
                DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG),
                //
                DateTimeFormatter.ofPattern("Gyyyy%%MMM%%dd HH:mm:ss"),
        };

        var now = LocalDateTime.now();

        for( var i : formatters)
        {
            System.out.println(now.format(i));
            System.out.println(i.format(now));
        }
    }
}

class MethodHandleTest{
    public String name;
    private String address;
    public static void hello()
    {
        System.out.println("hello world");
    }
    private String hello(String name)
    {
        System.out.println("private hello method");
        return name + " 您好!  " ;
    }
}

