package com.bikego.env.management.controller.testCase.part5;

import org.junit.Test;

import java.util.Arrays;

public class 多形参 {

    /**
     * 从JDK 1.5之后，Java允许定义形参个数可变的参数，从而允许为方法指定数量不确定的形参。如果在定义方法时，在最后一个形参的类型后增加三点（...），
     * 则表明该形参可以接受多个参数值，多个参数值被当成数组传入。
     *
     * 个数可变的形参只能处于形参列表的最后。也就是说，一个方法中最多只能有一个个数可变的形参。
     * 注意：个数可变的形参只能处于形参列表的最后。一个方法中最多只能包含一个个数可变的形参。个数可变的形参本质就是一个数组类型的形参，
     * 因此调用包含个数可变形参的方法时，该个数可变的形参既可以传入多个参数，也可以传入一个数组。
     */

    @Test
    public void test()
    {
        sss(12,"java","php","go");
        sss(12, new String[]{"java", "php", "go"});
    }
    protected void sss(int a,String... books)
    {
        System.out.println(a);
        System.out.println(Arrays.toString(books));
    }
}
