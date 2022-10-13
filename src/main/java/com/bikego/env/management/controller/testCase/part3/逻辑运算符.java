package com.bikego.env.management.controller.testCase.part3;

import org.junit.Test;

public class 逻辑运算符 {

    /**
     * 逻辑运算符 逻辑运算符用于操作两个布尔型的变量或常量。逻辑运算符主要
     * 有如下6个。
     * &&：与，前后两个操作数必须都是true才返回true，否则返回false。 同php一样,当第一个判断成功时会短路,不执行后面的语句
     * &：不短路与，作用与&&相同，但不会短路。
     * ||：或，只要两个操作数中有一个是true，就可以返回true，否则返回false。
     * |：不短路或，作用与||相同，但不会短路。
     * ！：非，只需要一个操作数，如果操作数为true，则返回false；如果操作数为false，则返回true。
     * ^：异或，当两个操作数不同时才返回true，如果两个操作数
     * 相同则返回false。
     */

    /**
     * 三目运算符和if else写法 的区别在于：
     * if后的代码块可以有多个语句，但三目运算符是不支持多个语句的。
     */


    @Test
    public void t1()
    {

        System.out.println(5 > 3 && '6' > 10); //true

        System.out.println(4 >= 5 && 'c' > 'a'); //true

        System.out.println(4 >=5 ^ 'c' > 'a'); //true
    }

    @Test
    public void t2()
    {

        var a = 5;
        var b = 10;
        if (a > 4 | b++ > 10)
        {
            System.out.println(a);
            System.out.println(b);
        }

        var a1 = 5;
        var b1 = 10;
        if (a1 > 4 || b1++ > 10)
        {
            System.out.println(a1);
            System.out.println(b1);
        }
    }
}
