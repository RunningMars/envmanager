package com.bikego.env.management.controller.testCase.part3;

import org.junit.Test;

public class
表达式类型的自动提升 {

    @Test
    public void test()
    {
        short sValue = 5;
        /**
         sValue = sValue - 2;
         上面的“sValue-2”表达式的类型将被提升到int类型，这样就把右边的int类型值赋给左边的short类型变量，从而引起错误。
         */

        double ii = 5.0d;
        short shortValue = 5;
        /**
         * 获取基础类型变量的类型
         * 基础类型没有包装类,没有类的折射,需要强转化为类后获取类名
         */
        //System.out.println(ii.getClass().toString());
        //System.out.println(shortValue.getClass().toString());

        System.out.println(((Object)ii).getClass().toString());
        System.out.println(((Object)shortValue).getClass().toString());
    }

    @Test
    public void t2()
    {
        byte b = 40;
        var c = 'a';
        System.out.println((int)c); // 97
        var i = 23;
        var d = .314;
        //必须指出，表达式的类型将严格保持和表达式中最高等级操作数 相同的类型。
        double result = b + c + i * d;

        System.out.println(result); // 144.222
    }

    @Test
    public void t3()
    {
        var val = 3;
        int result = 23 / val;
        System.out.println(result); // 7
    }

    @Test
    public void t4()
    {
        System.out.println("hello!" + 'a' + 7); //hello!a7
        System.out.println( 'a' + 7 + "hello!"); //104hello!
    }

    /**
     * 直接量
     * 一般是基本数据类型
     * char boolean int long float double (byte short同int)
     * string
     * null
     * 在上面的8种类型的直接量中，null类型是一种特殊类型，它只有 一个值：null，而且这个直接量可以赋给任何引用类型的变量，
     * 用以 表示这个引用类型变量中保存的地址为空，即还未指向任何有效对象。
     */

    /**
     * 类型转换 (自动转换和强制转换)
     * 箭头左边类型的直接量可以直接赋给箭头右边类型的变量；如果需要把图3.10中箭头右边类型的直接量赋给箭头左边类型的变量，则需要强制类型转换。
     * String类型的直接量不能赋给其他类型的变量，null类型的直接 量可以直接赋给任何引用类型的变量，包括String类型。
     * boolean类型 的直接量只能赋给boolean类型的变量，不能赋给其他任何类型的变量。
     */

    @Test
    public void t5()
    {
        var s0 = "hello";
        var s1 = "hello";
        var s2 = "he" + "llo";
        System.out.println(s0 == s1);  //true
        System.out.println(s0 == s2);   //true
    }

}
