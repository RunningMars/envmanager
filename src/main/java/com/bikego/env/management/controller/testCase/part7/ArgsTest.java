package com.bikego.env.management.controller.testCase.part7;

public class ArgsTest {
    /**
     * 运行Java程序的参数
     * 回忆Java程序的入口——main()方法的方法签名：下面详细讲解main()方法为什么采用这个方法签名。
     * ➢ public修饰符：Java类由JVM调用，为了让JVM可以自由调用这个main()方法，所以使用public修饰符把这个方法暴露出来。
     * ➢ static修饰符：JVM调用这个主方法时，不会先创建该主类的对象，然后通过对象来调用该主方法。JVM直接通过该类来调用主方法，因此使用static修饰该主方法。
     * ➢ void返回值：因为主方法被JVM调用，该方法的返回值将返回给JVM，这没有任何意义，因此main()方法没有返回值。
     * 上面方法中还包括一个字符串数组形参，根据方法调用的规则：谁调用方法，谁负责为形参赋值。也就是说，main()方法由JVM调用，即args形参应该由JVM负责赋值。
     * 但JVM怎么知道如何为args数组赋值呢？
     */



//class ArgsTest{
    public static void main(String[] args)
    {
        System.out.println(args.length);
        for (var i:args)
        {
            System.out.println(i);
        }
    }
}