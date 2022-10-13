package com.bikego.env.management.controller.testCase.part9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class 泛型 {

    /**
     * Generic
     * 因为Java 5增加泛型支持在很大程度上都是为了让集合能记住其元素的数据类型。在没有泛型之前，一旦把一个对象“丢进”Java集合中，集合就会忘记对象的类型，
     * 把所有的对象当成Object类型处理。当程序从集合中取出对象后，就需要进行强制类型转换，这种强制类型转换不仅使代码臃肿，
     * 而且容易引起ClassCastException异常。
     * 增加了泛型支持后的集合，完全可以记住集合中元素的类型，并可以在编译时检查集合中元素的类型，如果试图向集合中添加不满足类型要求的对象，编译器就会提示错误。
     * 增加泛型后的集合，可以让代码更加简洁，程序更加健壮（Java泛型可以保证如果程序在编译时没有发出警告，运行时就不会产生ClassCastException异常）。
     */

    /**
     * 可以把ArrayList<String>类当成ArrayList的子类，事实上，ArrayList<String>类也确实像一种特殊的ArrayList类：
     * 该ArrayList<String>对象只能添加String对象作为集合元素。但实际上，系统并没有为ArrayList<String>生成新的class文件，而且也不
     * 会把ArrayList<String>当成新类来处理。
     *
     * Collection<String> 不能当成Collection<Object>来使用
     */

    /**
     * 不管为泛型形参传入哪一种类型实参，对于Java来说，它们依然被当成同一个类处理，在内存中也只占用一块内存空间，
     * 因此在静态方法、静态初始化块或者静态变量（它们都是类相关的）的声明和初始化中不允许使用泛型形参。
     */

    /**
     * 注意：数组和泛型有所不同，假设Foo是Bar的一个子类型（子类或者子接口），那么Foo[]依然是Bar[]的子类型；但G<Foo>不是G<Bar>
     * 的子类型。Foo[]自动向上转型为Bar[]的方式被称为型变。也就是* 说，Java的数组支持型变，但Java集合并不支持型变。
     */

    /**
     * 与使用普通通配符相似的是，shapes.add()的第二个参数类型是？extends Shape，它表示Shape未知的子类，程序无法确定这个类
     * 型是什么，所以无法将任何对象添加到这种集合中。简而言之，这种指定通配符上限的集合，只能从集合中取元素（取出的元素总是上限的类型或其子类），
     * 不能向集合中添加元素（因为编译器没法确定集合元素实际是哪种子类型）。对于更广泛的泛型类来说，指定通配符上限就是为了支持类型型变。
     * 比如Foo是Bar的子类，这样A<Foo>就相当于A<? extends Bar>的子类，可以将A<Foo>赋值给A<? extends Bar>类型的变量，这种型变
     * 方式被称为协变。对于协变的泛型而言，它只能调用泛型类型作为返回值类型的方法（编译器会将该方法返回值当成通配符上限的类型）；而不能调用
     * 泛型类型作为参数的方法。口诀是：协变只出不进！
     */

    /**
     * 指定通配符的下限就是为了支持类型型变。比如Foo是Bar的子类，当程序需要一个A<? super Foo>变量时，程序可以将A<Bar>、
     * A<Object>赋值给A<? super Foo>类型的变量，这种型变方式被称为逆变。对于逆变的泛型集合来说，编译器只知道集合元素是下限的父类型，
     * 但具体是哪种父类型则不确定。因此，这种逆变的泛型集合能向 其中添加元素（因为实际赋值的集合元素总是逆变声明的父类），
     * 从集合中取元素时只能被当成Object类型处理（编译器无法确定取出的到底是哪个父类的对象）。对于逆变的泛型而言，它只能调用泛型类型作为参数的方法；
     */

    /**
     * 泛型方法
     * 与接口、类声明 中定义的泛型不同的是，方法声明中定义的泛型只能在该方法里使用，而接口、类声明中定义的泛型则可以在整个接口、类中使用。
     * 与类、接口中使用泛型参数不同的是，方法中的泛型参数无须显式传入实际类型参数,因为编 译器根据实参推断出泛型所代表的类型，它通常推断出最直接的类型
     *
     * 这个方法签名可以代替前面的方法签名。但注意上面的泛型形参 S，它仅使用了一次，其他参数的类型、方法返回值的类型都不依赖于它，那泛型形参S就没有存在的必要，即可以用通配符来代替S。
     * 使用通配符比使用泛型方法（在方法签名中显式声明泛型形参）更加清晰和准确，因此Java设计该方法时采用了通配符，而不是泛型方法。
     * 类型通配符与泛型方法（在方法签名中显式声明泛型形参）还有一个显著的区别：类型通配符既可以在方法签名中定义形参的类型，也可以用于定义变量的类型；
     * 但泛型方法中的泛型形参必须在对应方法中显式声明。
     */
    static <T,S extends T> void copyTo(Collection<S> from , Collection<T> to)
    {
        for (var ele : from)
        {
            to.add(ele);
        }
    }
    static <T> void copyTo2(Collection<? extends T> from , Collection<T> to)
    {
        for (var ele : from)
        {
            to.add(ele);
        }
    }

    @Test
    public void t0() {
        List<Object> to   = new ArrayList<>();
        List<String> from = new ArrayList<>();
        copyTo(from,to);
    }

    @Test
    public void t5() {
        class MyClass<E>
        {
            public <T> MyClass(T t)
            {
                System.out.println("t参数的值为" + t);
            }
        }

        MyClass<String> objectMyClass = new MyClass<>(5);

        MyClass<String> myClass = new <Integer>MyClass<String>(5);
    }

    @Test
    public void t1()
    {
        /**
         * 泛型为String
         */
        ArrayList<String> list = new ArrayList<>();

        /**
         * ? 泛型通配符,相当于通配符的上限为Object
         */
        ArrayList<?> list2 = new ArrayList<>();

        /**
         * ? 泛型通配符,通配符的上限为Number
         */
        ArrayList<? extends Number> list3 = new ArrayList<>();

    }

    @Test
    public void t2()
    {
        Apple apple = new Apple();
        apple.t();
    }

    /**
     * 当把一个具有泛型信息的对象赋给另一个没有泛型信息的变量时 ，所有在尖括号之间的类型信息都将被扔掉。比如一个
     * List<String>类型被转换为List，则该List对集合元素的类型检查变成了泛型参数的上限（即Object）。
     */

    /**
     * Java不支持创建泛型数组
     */
}
class Apple<T>
{
    public void t()
    {
        System.out.println("apple tree");
    }
}

class MyUtils{
    static <T> void copy (Collection<T> dest,Collection<? extends T> src)
    {}
    static <T> void copy2 (Collection<? super T> dest,Collection<T> src)
    {}
}