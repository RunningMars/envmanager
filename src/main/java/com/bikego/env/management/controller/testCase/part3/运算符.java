package com.bikego.env.management.controller.testCase.part3;

import org.junit.Test;

public class
运算符 {

    @Test
    /**
     * 除法运算符。除法运算符有些特殊，如果除法运算符的两个操 作数都是整数类型，则计算结果也是整数，就是将自然除法的结果截 断取整，例如19/4的结果是4，而不是5。如果除法运算符的两个操作
     * 数都是整数类型，则除数不可以是0，否则将引发除以零异常。
     * 但如果除法运算符的两个操作数有一个是浮点数，或者两个都是 浮点数，则计算结果也是浮点数，这个结果就是自然除法的结果。而 且此时允许除数是0，或者0.0，得到结果是正无穷大或负无穷大。看
     * 下面代码。
     */
    public void test()
    {
        var a = 5.2;
        var b = 3.1;
        var div = a / b;
        System.out.println(div);

        /**
         * 有一个是浮点数,就可以0作为被除数,得出正负无穷大
         */
        var div2 = 5.1 / 0;
        System.out.println(div2);  //Infinity

        var div3 = -5 / 0.0;
        System.out.println(div3);  //-Infinity

        /**
         * by zero 异常
         */
        var div34 = -5 / 0;
        System.out.println(div3);
    }

    @Test
    /**
     *  在java浮点数值计算都遵循IEEE 754规范，具体来说，下面是用于表示溢出和出错情况的三个特殊的浮点数值：
     *  正无穷大
     *  负无穷大
     *  NaN(不是一个数字)
     *
     *  例如，一个正整数除以0的结果为正无穷大，计算0/0或者负数的平方根结果为NaN。
     *  常量Double.POSITIVE_INFINITY,Double_NEGATIVE_INFINITY和Double.NaN分别表示这三个特殊的值。
     *  检测一个特定值是否等于Double.NaN:
     */
    public void t2()
    {
        var a = 5.2;
        var b = 3.1;
        var mod = a % b;
        System.out.println(mod);


        var n = 5 % 0.0;
        System.out.println(n);

        /**
         * 检测一个特定值是否等于Double.NaN
         */
        boolean isNaN = Double.isNaN(n);
        System.out.println(isNaN);
        //if(n==NaN) //这个是永远不对的
    }

    /**
     * ++ 自加
     * 运算符既可以出现在操作数的 左边，也可以出现在操作数的右边。但出现在左边和右边的效果是不 一样的。如果把++放在左边，则先把操作数加1，然后才把操作数放入 表达式中运算；如果把++放在右边，则先把操作数放入表达式中运
     * 算，然后才把操作数加1。
     *
     * 注意： 自加和自减只能用于操作变量，不能用于操作数值直接量、常
     * 量或表达式。例如，5++、6--等写法都是错误的。
     */
    @Test
    public void t3()
    {
        var a = 5;

        var b = a++  + 6;

        System.out.println(b);

        var c = ++a + 6;

        System.out.println(c);
    }

    @Test
    /**
     *  Java并没有提供其他更复杂的运算符，如果需要完成乘方、开方 等运算，则可借助于java.lang.Math类的工具方法完成复杂的数学运算，见如下代码
     */
    public void t4()
    {
        var a = 3.2;
        /**
         * a的5次方
         */
        double b = Math.pow(a,5);
        System.out.println(b);
        /**
         * 求a的平方根
         */
        double c = Math.sqrt(a);
        System.out.println(c);

        double d = Math.random();
        System.out.println(d);

        double e = Math.sin(1.57);
        System.out.println(e);
    }
}
