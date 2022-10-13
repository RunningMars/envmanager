package com.bikego.env.management.controller.testCase.part3;

import org.junit.Test;

public class 比较运算符 {

    /**
     * 比较运算符用于判断两个变量或常量的大小，比较运算的结果是
     * 一个布尔值（true或false）。Java支持的比较运算符如下。
     * >：大于，只支持左右两边操作数是数值类型。如果前面变量
     * 的值大于后面变量的值，则返回true。
     * >=：大于等于，只支持左右两边操作数是数值类型。如果前面
     * 变量的值大于等于后面变量的值，则返回true。
     * <：小于，只支持左右两边操作数是数值类型。如果前面变量
     * 的值小于后面变量的值，则返回true。
     * <=：小于等于，只支持左右两边操作数是数值类型。如果前面
     * 变量的值小于等于后面变量的值，则返回true。
     * ==：等于，如果进行比较的两个操作数都是数值类型，即使它 们的数据类型不相同，只要它们的值相等，也都将返回true。
     * !=：不等于，如果进行比较的两个操作数都是数值类型，无论 它们的数据类型是否相同，只要它们的值不相等，也都将返回
     * true。如果两个操作数都是引用类型，只有当两个引用变量的 类型具有父子关系时才可以比较，只要两个引用指向的不是同
     * 一个对象就会返回true。
     *
     * 例如97=='a'返回true，5.0==5也返回true。
     * 如果两个操作数都 是引用类型，那么只有当两个引用变量的类型具有父子关系时 才可以比较，而且这两个引用必须指向同一个对象才会返回true。
     * Java也支持两个boolean类型的值进行比较，例如，true==false将返回false。
     */

    /**
     * 注意： 基本类型的变量、值不能和引用类型的变量、值使用==进行比 较；boolean类型的变量、值不能与其他任意类型的变量、值使用==
     * 进行比较；如果两个引用类型之间没有父子继承关系，那么它们的
     * 变量也不能使用==进行比较。
     */
    @Test
    public void t1()
    {
        System.out.println(5 > 4.0 ); // true
        System.out.println(5 == 5.0 );  // true
        System.out.println(97 == 'a' );  // true

        var t1 = new 比较运算符();
        var t2 = new 比较运算符();
        var t3 = t1;
        System.out.println(t1 == t2 );  // false
        System.out.println(t1 == t3 );  // true

    }

    @Test
    public void t2()
    {
        byte a = 5;
        //a = a+5; 报错:int型赋值给byte型
        a = (byte)(a+5);

        byte b = 5;
        b += 5;
    }
}
