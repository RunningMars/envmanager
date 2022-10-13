package com.bikego.env.management.controller.testCase.part6;

import com.bikego.env.management.controller.testCase.part5.Oop2;
import org.junit.Test;

import java.util.Arrays;

public class 面向对象下 {
    /**
     * 包装类还可实现基本类型变量和字符串之间的转换。
     * 把字符串类型的值转换为基本类型的值有两种方式。
     * ➢ 利用包装类提供的parseXxx(String s)静态方法（ 除Character之外的所有包装类都提供了该方法。
     * ➢ 利用包装类提供的valueOf(String s)静态方法。String类也提供了多个重载valueOf()方法，用于将基本类型变量转换成字符串，下面程序示范了这种转换关系。
     */

    @Test
    public void test()
    {
        Oop2 oop2 = new Oop2();
        System.out.println(oop2.toString());

        var obj = new Apple("红色");
//        obj.equals(1);
        System.out.println(obj);
    }

    /**
     * 对初学者而言，String还有一个非常容易迷惑的地方："hello"直接量和new String("hello")有什么区别呢？
     * 当Java程序直接使用形 如"hello"的字符串直接量（包括可以在编译时就计算出来的字符串值）时，JVM将会使用常量池来管理这些字符串；
     * 当使用new String("hello")时，JVM会先使用常量池来管理"hello"直接量，再调用String类的构造器来创建一个新的String对象，
     * 新创建的String对象被保存在堆内存中。换句话说，new String("hello")一共产生了两个字符串对象。
     *
     * JVM常量池保证相同的字符串直接量只有一个，不会产生多个副本。例子中的s1、s4、s5所引用的字符串可以在编译期就确定下来，
     * 因此它们都将引用常量池中的同一个字符串对象。使用new String()创建的字符串对象是运行时创建出来的，它被保存在运行时内存区（即堆内存）内，不会放入常量池中。
     */

    @Test
    public void t1()
    {
        var s1 = "疯狂Java";
        var s2 = "疯狂";
        var s3 = "Java";
        var s4 = "疯狂" + "Java";
        var s5 = "疯" + "狂" + "Java";
        var s6 = s2 + s3;
        var s7 = new String( "疯狂Java");

        System.out.println(s1 == s4); //true
        System.out.println(s1 == s5); //true
        System.out.println(s1 == s6); //false
        System.out.println(s1 == s7); //false
    }

    @Test
    public void t5()
    {
        System.out.println("this is T5");
    }

    /**
     * final修饰基本类型变量和引用类型变量的区别
     * 当使用final修饰基本类型变量时，不能对基本类型变量重新赋值，因此基本类型变量不能被改变。
     * 但对于引用类型变量而言，它保存的仅仅是一个引用，final只保证这个引用类型变量所引用的地址不会改变，
     * 即一直引用同一个对象，但这个对象完全可以发生改变。
     */
    @Test
    public void test6()
    {
        final int[] arr = new int[]{3,67,23,132};

        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        arr[2] = 12;
        System.out.println(Arrays.toString(arr));

        /**
         * 不能对arr重新赋值,非法
         */
//        arr = null;
    }

    @Test
    public void t7()
    {
        var a1 = new Integer("6");
        var a2 = Integer.valueOf("6");
        var a3 = Integer.valueOf("6");
        System.out.println(a1 == a2);
        System.out.println(a2 == a3);

        /**
         * 由于Integer只缓存-128～127之间的Integer对象，
         * 因此两次通过Integer.valueOf(200);方法生成的Integer对象不是同一个对象
         */
        var a4 = Integer.valueOf("200");
        var a5 = Integer.valueOf("200");
        System.out.println(a4 == a5);

        /**
         * Integer 源码
         * Returns an {@code Integer} instance representing the specified
         * {@code int} value.  If a new {@code Integer} instance is not
         * required, this method should generally be used in preference to
         * the constructor {@link #Integer(int)}, as this method is likely
         * to yield significantly better space and time performance by
         * caching frequently requested values.
         *
         * This method will always cache values in the range -128 to 127,
         * inclusive, and may cache other values outside of this range.
         *
         * @param  i an {@code int} value.
         * @return an {@code Integer} instance representing {@code i}.
         * @since  1.5
         */
//        @HotSpotIntrinsicCandidate
//        public static Integer valueOf(int i) {
//        if (i >= Integer.IntegerCache.low && i <= Integer.IntegerCache.high)
//            return Integer.IntegerCache.cache[i + (-Integer.IntegerCache.low)];
//        return new Integer(i);
//        }
    }

}

class Apple{

    private String color;

    public Apple(String c)
    {
        color = c;
    }

    public String toString()
    {
        return "苹果:" + color;
    }
}

class FinalVariableTest{
    final int a = 6;
//    final String str;
    final int c;
    final static double d = 6;

    /**
     * 实例final变量,在普通初始化块和构造器中都没有指定初始值是不合法的(编译不通过)
     * 所以,普通方法不能为final赋值的
     */
    //final char ch;

    public FinalVariableTest() {
            c = 6;
    }
//
//    public FinalVariableTest(String str) {
//        this.str = str;
//    }

    {
//        str = "Hello";
        //不能对final变量重新赋值;
//        a = 9;
    }

    static {
//        d = 5.6;
    }

    public void test (final int a)
    {
        /**
         * 不能对final修饰的形参赋值,报错
         */
        //a = 56;
    }


}

class CacheObj{

    public static CacheObj[] containers;

    private static final int MAX_SIZE = 10;

    static {
        containers = new CacheObj[MAX_SIZE];
    }

    public static int index = 0;

    private String name;

    public CacheObj(String name) {
        this.name = name;
    }

    public static CacheObj cacheObject(String name)
    {
        for (int i = 0;i < MAX_SIZE - 1; i++)
        {
            if (containers[i] != null && containers[i].getName().equals(name) )
            {
                return containers[i];
            }
        }

        if (index < MAX_SIZE - 1)
        {
            index += 1;
            containers[index] = new CacheObj(name);
        }else{
            index = 0;
            containers[index] = new CacheObj(name);
        }

        return containers[index];
    }


    public String getName() {
        return name;
    }

}