package com.bikego.env.management.controller.testCase.part6;

import org.junit.Test;
import org.springframework.asm.Type;
import org.springframework.cglib.core.ProcessArrayCallback;

public class 接口 {


    /**
     * 接口主要有如下用途。
     * ➢ 定义变量，也可用于进行强制类型转换。
     * ➢ 调用接口中定义的常量。
     * ➢ 被其他类实现。
     */

    /**
     * 接口里定义的方法只能是抽象方法、类方法、默认方法或私有方法，因此如果不是定义默认方法、类方法或私有方法，系统将自动为普通方法增加abstract修饰符；
     * 定义接口里的普通方法时不管是否使用public abstract修饰符，接口里的普通方法总是使用public abstract来修饰。接口里的普通方法不能有方法实现（方法体）；
     * 但类方法、默认方法、私有方法都必须有方法实现（方法体）
     */


    /**

         [修饰符] interface 接口名 extends 父接口1,父接口2..
         {
             零个到多个常量定义...
             零个到多个抽象方法定义...
             零个到多个内部类、接口、枚举定义...
             零个到多个私有方法、默认方法或类方法定义...
         }

     */


    /**
     * 从Java 8开始，在接口里允许定义默认方法，默认方法必须使用default修饰，该方法不能使用static修饰，无论程序是否指定，
     * 默认方法总是使用public修饰——如果开发者没有指定public，系统会自动为默认方法添加public修饰符。由于默认方法并没有static修饰，
     * 因此不能直接使用接口来调用默认方法，需要使用接口的实现类的实例来调用这些默认方法。
     */


    @Test
    public void t1()
    {
        /**
         * 该成员变量是public访问权限的，而且可通过接口来访问该成员变量，表明这个成员变量是一个类变量；
         */
        int maxSize = InterfaceA.MAX_SIZE;

        /**
         * 当为这个成员变量赋值时引发"为final变量赋值"的编译异常，表明这个成员变量使用了final修饰。
         */
//        InterfaceA.MAX_SIZE = 20;
    }

    /**
     * 实现接口与继承父类相似，一样可以获得所实现接口里定义的常量（成员变量）、方法（包括抽象方法和默认方法）。
     */

    @Test
    public void t2()
    {
        B b = new B();
        /**
         * 相当于继承了接口的默认方法
         */
        b.test();

        int prop_0 = b.prop_0;
        System.out.println(prop_0);
        //不可调用接口的私有方法
//        b.foo();
    }

    /**
     * 接口和抽象类很像，它们都具有如下特征。
     * ➢ 接口和抽象类都不能被实例化，它们都位于继承树的顶端，用于被其他类实现和继承。
     * ➢ 接口和抽象类都可以包含抽象方法，实现接口或继承抽象类的普通子类都必须实现这些抽象方法。
     *
     * 接口作为系统与外界交互的窗口，接口体现的是一种规范。对于接口的实现者而言，接口规定了实现者必须向外提供哪些服务（以方法的形式来提供）；
     * 对于接口的调用者而言，接口规定了调用者可以调用哪些服务，以及如何调用这些服务（就是如何来调用方法）。
     * 当在一个程序中使用接口时，接口是多个模块间的耦合标准；当在多个应用程序之间使用接口时，接口是多个程序之间的通信标准。
     *
     * 抽象类则不一样，抽象类作为系统中多个子类的共同父类，它所体现的是一种模板式设计。抽象类作为多个子类的抽象父类，可以被当成系统实现过程中的中间产品，
     * 这个中间产品已经实现了系统的部分功能（那些已经提供实现的方法），但这个产品依然不能当成最终产品，必须有更进一步的完善，这种完善可能有几种不同方式。
     *
     * 除此之外，接口和抽象类在用法上也存在如下差别。
     * ➢ 接口里只能包含抽象方法、静态方法、默认方法和私有方法，不能为普通方法提供方法实现；抽象类则完全可以包含普通方法。
     * ➢ 接口里只能定义静态常量，不能定义普通成员变量；抽象类里则既可以定义普通成员变量，也可以定义静态常量。
     * ➢ 接口里不包含构造器；抽象类里可以包含构造器，抽象类里的构造器并不是用于创建对象，而是让其子类调用这些构造器来完成属于抽象类的初始化操作。
     * ➢ 接口里不能包含初始化块；但抽象类则完全可以包含初始化块。
     * ➢ 一个类最多只能有一个直接父类，包括抽象类；但一个类可以直接实现多个接口，通过实现多个接口可以弥补Java单继承的不足。
     */

    @Test
    public void t5()
    {
        TestOne.test();
    }
}

interface Interface0{
    int prop_0 = 5;
}
interface Interface1{
    int prop_1 = 6;
}

interface InterfaceA extends Interface0,Interface1{

    //定义的成员变量都是常量
    int MAX_SIZE = 50;

    //接口里定义的普通方法只能是public的抽象方法
    void out();
    void getData(String msg);

    //在接口中定义默认方法,需要使用default修饰
    default void test()
    {
        System.out.println("默认的test()方法");
    }

    default void print(String... msgs)
    {
        for (var msg : msgs)
        {
            System.out.println(msg);
        }
    }

    //定义类方法
    static String staticTest()
    {
        return "接口的类方法";
    }

    //定义私有方法
    private void foo()
    {
        System.out.println("foo 私有方法");
    }

    //定义私有静态方法
    private static void bar()
    {
        System.out.println("bar 私有静态方法");
    }
}

class B implements InterfaceA{


    @Override
    public void out() {

    }

    @Override
    public void getData(String msg) {

    }
}

/**
 * 命令模式 (设计模式)
 */
interface Command{

    public void process(int element);
}

class PrintCommand implements Command{

    @Override
    public void process(int element) {
        System.out.println("PrintCommand " + element);
    }
}
class SquareCommand implements Command{

    @Override
    public void process(int element) {
        System.out.println("SquareCommand " + element);
    }
}

class TestOne{
    public static void test()
    {
//        Command command = new PrintCommand();
        Command command = new SquareCommand();
        int[] arr = new int[]{234,654,67,9,91};
        for (var i :arr)
        {
            command.process(i);
        }

//        pa = new ProcessArrayCallback() {
//            @Override
//            public void processElement(Type type) {
//
//            }
//        };
//        arr.process();
    }

}