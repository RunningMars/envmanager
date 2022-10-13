package com.bikego.env.management.controller.testCase.part14;

import org.junit.Test;

import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.List;

public class 注解 {

    /**
     * 注意：注解是一个接口，程序可以通过反射来获取指定程序元素的java.lang.annotation.Annotation 对象，
     * 然后通过 ava.lang.annotation.Annotation 对象来取得注解里的元数据。
     */

    /**
     * Override
     * 可能丝毫看不出程序中的@Override有何作用，因为@Override的作用是告诉编译器检查这个方法，保证父类要包含一个被该方法重写的方法，
     * 否则就会编译出错。@Override主要是帮助程序员避免一些低级错误，例如把上面Apple类中的info方法不小心写成了inf0，
     * 这样的“低级错误”可能会成为后期排错时的巨大障碍。
     */

    @Test
    public void t0()
    {
        List<String> objects = new ArrayList();
        System.out.println(objects);
    }

    /**
     * 函数式接口 与 @FunctionalInterface
     * 从Java 8开始：如果接口中只有一个抽象方法（可以包含多个默认方法或多个static方法），该接口就是函数式接口。
     * @FunctionalInterface 就是用来指定某个接口必须是函数式接口。
     */

    /**
     * JDK的元注解
     * JDK 除在java.lang下提供了5个基本的注解之外，还在java.lang.annotation包下提供了6个Meta注解（元注解），用于修饰注解
     */

    /**
     * @Retention
     * @Retention 只能用于修饰注解定义，用于指定被修饰的注解可以保留多长时间，@Retention包含一个RetentionPolicy类型的value成
     * 员变量，所以使用@Retention时必须为该value成员变量指定值。value成员变量的值只能是如下三个。
     * ➢ RetentionPolicy.CLASS：编译器将把注解记录在class文件中。当运行Java程序时，JVM不可获取注解信息。这是默认值。
     * ➢ RetentionPolicy.RUNTIME：编译器将把注解记录在class文件中。当运行Java程序时，JVM也可获取注解信息，程序可以通过反射获取该注解信息。
     * ➢ RetentionPolicy.SOURCE：注解只保留在源代码中，编译器直接丢弃这种注解。
     */

    /**
     * @Target 也只能修饰注解定义，它用于指定被修饰的注解能用于修饰哪些程序单元。@Target元注解也包含一个名为value的成员变量，该成员变量的值只能是如下几个。
     * ➢ ElementType.ANNOTATION_TYPE：指定该策略的注解只能修饰注解。
     * ➢ ElementType.CONSTRUCTOR：指定该策略的注解只能修饰构造器。
     * ➢ ElementType.FIELD：指定该策略的注解只能修饰成员变量。
     * ➢ ElementType.LOCAL_VARIABLE：指定该策略的注解只能修饰局部变量。
     * ➢ ElementType.METHOD：指定该策略的注解只能修饰方法定义。
     * ➢ ElementType.PACKAGE：指定该策略的注解只能修饰包定义。
     * ➢ ElementType.PARAMETER：指定该策略的注解可以修饰参数。
     * ➢ ElementType.TYPE：指定该策略的注解可以修饰类、接口（包括注解类型）或枚举定义。
     */

    /**
     * @Documented 用于指定被该元注解修饰的注解类将被javadoc工具提取成文档，如果定义注解类时使用了@Documented修饰，
     * 则所有使用该注解修饰的程序元素的API文档中将会包含该注解说明。
     */

    /**
     * @Inherited 元注解指定被它修饰的注解将具有继承性——如果某个类使用了@Xxx注解（定义该注解时使用了@Inherited修饰）修饰，则其子类将自动被@Xxx修饰。
     */

    /**
     * 注意： 重复注解只是一种简化写法，这种简化写法是一种假象：多个重复注解其实会被作为“容器”注解的value成员变量的数组元素。
     * 例如上面的重复的@FkTag注解其实会被作为@FkTags注解的value成员变量的数组元素处理。
     */

    /**
     * 类型注解
     * Java 8为ElementType枚举增加了TYPE_PARAMETER、TYPE_USE两个枚举值，这样就允许定义注解时使用
     * @Target（ElementType.TYPE_USE）修饰，这种注解被称为类型注解（Type Annotation），类型注解可用于修饰在任何地方出现的类型。
     */

    /**
     * Java 8提供了类型注解之后，第三方组织在发布他们的框架时，可能会随着框架一起发布类型注解检查工具，
     * 这样普通 发者即可直接使用第三方框架提供的类型注解，从而让编译器执行更严格的检查，保证代码更加健壮。
     */

    /**
     *  编译时处理注解
     * APT（Annotation Processing Tool）是一种注解处理工具，它对源代码文件进行检测，并找出源文件所包含的注解信息，
     * 然后针对注解信息进行额外的处理。
     */
}

//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.PACKAGE)
//@Documented
interface FunInterface0
{
}

@TestAnnotation(name="rdg",age=6)
@FunctionalInterface
interface FunInterface1{
    void test();

    default void foo()
    {
        System.out.println("foo");
    }
    static void bar()
    {
        System.out.println("bar");
    }
}

/**
 * 自定义注解 定义新的注解类型使用@interface关键字（在原有的interface关 键字前增加@符号）定义一个新的注解类型与定义一个接口非常像，如
 * 下代码可定义一个简单的注解类型。
 */
@interface TestAnnotation{
    String name() default  "rdg";
    int age() default 0;
}