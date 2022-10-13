package com.bikego.env.management.controller.testCase.part6;

import org.junit.Test;

public class Lambda {
    /**
     * Lambda表达式的主要作用就是代替匿
     * 名内部类的烦琐语法。它由三部分组成。
     * ➢ 形参列表。形参列表允许省略形参类型。如果形参列表中只有一个参数，甚至连形参列表的圆括号也可以省略。
     * ➢ 箭头（->）。必须通过英文中画线和大于符号组成。
     * ➢ 代码块。如果代码块只包含一条语句，Lambda表达式允许省略代码块的花括号，那么这条语句就不要用花括号表示语句结束。
     * Lambda代码块只有一条return语句，甚至可以省略return
     * 关键字。Lambda表达式需要返回值，而它的代码块中仅有一条省略了return的语句，Lambda表达式会自动返回这条语句的值。
     */


    /**
     * Lambda表达式的类型，也被称为“目标类型（target type）”，
     * Lambda 表达式的目标类型必须是“函数式接口（functional interface）”。函数式接口代表只包含一个抽象方法的接口。
     * 函数式接口可以包含多个默认方法、类方法，但只能声明一个抽象方法。
     */

    public void eat(Eatable e)
    {
        System.out.println(e);
        e.taste();
    }
    public void drive(Flyable f)
    {
        System.out.println("我正在驾驶" + f);
        f.fly("晴天");
    }
    public void add(Addable a)
    {
        System.out.println("5+3的和是:" + a.add(5,3));
    }

    @Test
    public void t1()
    {
        this.eat(()-> System.out.println("馋一下"));

        this.drive(weather -> System.out.println("今天的天气是:"+weather));

        this.add((a,b)-> a * b);
    }

    @Test
    public void t2()
    {
        Runnable run = ()-> System.out.println("implements runnable");
    }

    /**
     *
     * 为了保证Lambda表达式的目标类型是一个明确的函数式接口，可以有如下三种常见方式。
     * ➢ 将Lambda表达式赋值给函数式接口类型的变量。
     * ➢ 将Lambda表达式作为函数式接口类型的参数传给某个方法。
     * ➢ 使用函数式接口对Lambda表达式进行强制类型转换。
     */
    @Test
    public void t3()
    {
        this.t4(()-> System.out.println("ss"),12);
    }
    public void t4(Runnable run,int a)
    {
        run.run();
    }

    @Test
    public void t5()
    {
        Object obj = (Runnable)()-> System.out.println("sdfd");
        Runnable run = ()-> System.out.println("implements runnable");
    }

    @Test
    public void t6()
    {
        //调用其他类的静态方法
        TF.t1();
        //报错
        //TF::t1();

        Converter con = Integer::valueOf;

        Converter2 con2 = from -> TF.test2(from);

        con2.convert("sss");


        /**
         *
         */
        Runnable r1 = ()-> new TF();
        r1.run();

        System.out.println("****");
        Runnable r2 = TF::new;
        r2.run();


        new TF().run();
    }

    /**
     * Lambda表达式是匿名内部类的一种简化，因此它可以部分取代匿名内部类的作用，Lambda表达式与匿名内部类存在如下相同点。
     * ➢ Lambda 表达式与匿名内部类一样，都可以直接访问“effectively final”的局部变量，以及外部类的成员变量（包括实例变量和类变量）。
     * ➢ Lambda 表达式创建的对象与匿名内部类生成的对象一样，都可以直接调用从接口中继承的默认方法。
     *
     * Lambda表达式与匿名内部类主要存在如下区别。
     * ➢ 匿名内部类可以为任意接口创建实例—不管接口包含多少个抽象方法，只要匿名内部类实现所有的抽象方法即可；但Lambda表达式只能为函数式接口创建实例。
     * ➢ 匿名内部类可以为抽象类甚至普通类创建实例；但Lambda表达式只能为函数式接口创建实例。
     * ➢ 匿名内部类实现的抽象方法的方法体允许调用接口中定义的默认方法；但Lambda表达式的代码块不允许调用接口中定义的默认方法。
     */
    @Test
    public void t8()
    {
        LambdaAndInner.t1();
    }
}

interface Eatable{
    void taste();
}
interface Flyable{
    void fly(String weather);
}
interface Addable{
    int add(int a,int b);
}

interface Converter{
    Integer convert (String from);
}

@FunctionalInterface
interface Converter2{
    Integer convert (String from);
}
class TF implements Runnable{
    public static void t1()
    {
        System.out.println("TF - static t1()");
    }
     void test()
    {
        System.out.println("TF - test()");
    }
    static Integer test2(String from)
    {
        System.out.println("TF  test2  " + from);
        return 12;
    }

    @Override
    public void run() {
        System.out.println("run  dsd");
    }
}


@FunctionalInterface
interface Displayable{
    void display();

    default  int add (int a,int b)
    {
        return a + b;
    }
}

class LambdaAndInner
{
    private int age = 12;
    private static String name = "my name";

    public void test()
    {
        var book = "java";
        Displayable dis = ()-> {
            System.out.println("book is:" + book);
            System.out.println("age is:" + age);
            System.out.println("name is:" + name);
            //无法调用函数式接口的default 默认类
            //System.out.println(add(3,5));
        };

        dis.display();
        System.out.println(dis.add(3,5));
    }

    public static void t1()
    {
        LambdaAndInner lambdaAndInner = new LambdaAndInner();
        lambdaAndInner.test();
    }
}