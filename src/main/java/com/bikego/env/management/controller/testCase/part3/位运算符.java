package com.bikego.env.management.controller.testCase.part3;

import org.junit.Test;

public class 位运算符 {

    /**
     * 位运算符
     * Java支持的位运算符有如下7个。
     * &：按位与。当两位同时为1时才返回1。
     * |：按位或。只要有一位为1即可返回1。
     * ～：按位非。单目运算符，将操作数的每个位（包括符号位）
     * 全部取反。
     * ^：按位异或。当两位相同时返回0，不同时返回1。
     * <<：左移运算符。
     * >>：右移运算符。
     * >>>：无符号右移运算符。
     * 一般来说，位运算符只能操作整数类型的变量或值。位运算符的
     * 运算法则如表3.3所示
     */

    @Test
    public void t1()
    {
        System.out.println(5 & 9 ); // 1
        System.out.println(5 | 9 );  // 13

    }

    @Test
    public void t2()
    {
        System.out.println(~-5); //4
        System.out.println(5 ^ 9); //12

        System.out.println(5 << 2); //20
        System.out.println(-5 << 2); //-20

        System.out.println(-5 >> 2); //-2
        System.out.println(-5 >>> 2); //1073741822
    }
}
