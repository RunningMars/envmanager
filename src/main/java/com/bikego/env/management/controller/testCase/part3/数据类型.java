package com.bikego.env.management.controller.testCase.part3;

public class 数据类型 {

    /**
     * 整数类型：byte、short、int、long
     * -- Java各整数类型有固定的表数范围和字段长度，不受具体OS的影响，以保证java程序的可移植性。
     * -- java的整型常量默认为 int 型，声明long型常量须后加‘l’或‘L’
     * -- java程序中变量通常声明为int型，除非不足以表示较大的数，才使用long
     * 类型     占用存储空间     表数范围
     * byte    1字节=8bit位    -128 ~ 127
     * short   2字节           -2^15 ~ 2^15 - 1
     * int     4字节           -2^31 ~ 2^31(约21亿)
     * long    8字节           -2^63 ~ 2^63
     */

    /**
     * 浮点型 float,double
     * float:单精度，尾数可以精确到7位有效数字。很多情况下，精度很难满足需求。
     * double:双精度，精度是float的两倍。通常采用此类型。
     */

    /**
     * 字符类型：char
     * 型数据用来表示通常意义上“字符”(2字节)
     * 字符常量是用单引号(‘ ’)括起来的单个字符。 例如：char c1 = 'a'; char c2 = '中'; char c3 = '9';
     */

    /**
     * 布尔类型：boolean
     */

    /**
     * String不是基本数据类型，属于引用数据类型
     */
}
