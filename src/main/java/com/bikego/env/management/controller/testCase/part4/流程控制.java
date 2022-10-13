package com.bikego.env.management.controller.testCase.part4;

import org.junit.Test;

public class 流程控制 {

    /**
     * 分支结构
     * Java提供了两种常见的分支控制结构：if语句和switch语句，
     * 其中if语句使用布尔表达式或布尔值作为分支条件来进行分支控制；
     * 而switch语句则用于对多个整型值进行匹配，从而实现分支控制。
     */

    /**
     * switch
     * 和if语句不 同的是，switch语句后面的控制表达式的数据类型只能是byte、short、char、int四种整数类型，枚举类型和java.lang.String类型,不能是boolean类型
     * 如果省略了case后代码块的break;，将引入一个陷阱,Java 11编译器会生成警告：“[fallthrough]可能无法实 现case”。。
     */

    /**
     * Java的数组类型是一种引用类型的变量
     */

    @Test
    public void t1()
    {
        for(int i=0,a=1,b=2;i<a && a<b;i++,a++)
        {
            System.out.println(i);
            System.out.println(a);
            System.out.println(b);
        }
    }

    @Test
    public void t2()
    {
        var count = 0;
        for( ;count<10; )
        {
            System.out.println(count);
            count++;
            if (count > 5)
            {
                break;
            }
        }
    }


    /**
     * Java中的标签就是一个紧跟着英文冒号（:）的标识符
     * 在break后紧跟一个标签，这个标签用于标识一个外层循环
     *
     * 注意： 通常紧跟break之后的标签，必须在break所在循环的外层循环之前定义才有意义。
     */
    @Test
    public void t3()
    {
        //循环标签
        outer:
        for (var i = 0;i < 10;i++)
        {
            for (var j = 0 ;j < 10 ; j++)
            {
                System.out.println("i:" + i + " j:" + j);

                if (j >1)
                {
                    //结束循环标签
                    break outer;
                }
            }
        }
    }

    @Test
    public void t4()
    {
        //循环标签
        outer:
        for (var i = 0;i < 10;i++)
        {
            for (var j = 0 ;j < 10 ; j++)
            {
                System.out.println("i:" + i + " j:" + j);

                if (j >1)
                {
                    //结束循环标签
                    continue outer;
                }
            }
        }
    }
}
