
public class Oop {


    public static void main(String[] args)
    {
//        var p = new Oop();
//        p.test();
//        System.out.println("finished");//277

        var dw = new DataWarp();
        dw.a =  6;
        dw.b =  9;

        swap(dw);

        System.out.println(dw.a);
        System.out.println(dw.b);

    }

    private static void swap(DataWarp dw) {

        dw = null;
//        var temp = dw.a;
//
//        dw.a = dw.b;
//        dw.b = temp;
    }


    public void test()
    {

        System.out.println("method test()");
    }

    /**
     * 类里各成员之间的定义顺序没有任何影响，各成员之间可以相互 调用，但需要指出的是，static修饰的成员不能访问没有static修饰的成员。
     */

    /**
     * 成员变量
     *
     * 修饰符可以省略，也可以是public、protected、private、static、final，
     * 其中public、protected、private三个最多只能出现其中之一，可以与static、final组合起来修饰成员变量。
     *
     * 注意： 成员变量由英文单词field意译而来，早期有些书籍将成员变量 称为属性。但实际上在Java世界里属性（由property翻译而来）指 的是一组setter方法和getter方法。比如说某个类有age属性，意味
     * 着该类包含setAge()和getAge()两个方法。另外，也有些资料、书籍将field翻译为字段、域。
     */


    /**
     * 成员方法
     *
     * static是一个特殊的关键字，它可用于修饰方法、成员变量等成 员。static修饰的成员表明它属于这个类本身，而不属于该类的单个实例，因为通常把static修饰的成员变量和方法也称为类变量、类方法。
     * static相当于一个标志，有static修饰的成员属于类本身，没有static修饰的成员属于该类的实例。
     *
     * 静态成员不能直接访问非静态成员
     * 提示：正如前面提到的，Java允许通过实例来访问static修饰的成员 变量本身就是一个错误，因此读者以后看到通过实例来访问static
     * 成员变量的情形，都可以将它替换成通过类本身来访问static成员变量的情形，这样程序的可读性、明确性都会大大提高。
     */

    /**
     * 构造器
     *
     * 值得指出的是，构造器既不能定义返回值类型，也不能使用void声明构造器没有返回值。如果为构造器定义了返回值类型，或使用
     * void声明构造器没有返回值，编译时不会出错，但Java会把这个所谓的构造器当成方法来处理——它就不再是构造器。
     */

    /**
     * 实例化
     *
     * 对于var p=new Person();这样的代码，使用var定义变量不仅更简洁，而且也不会降低程序的可读性（根据所赋的值一眼就能判断出变量p的类型），因此使用var定义变量会更好。
     */

    /**
     * 上面代码把p变量的值赋值给p2变量，也就是将p变量保存的地址值赋给p2变量，这样p2变量和p变量将指向堆内存里的同一个Person对象。
     * 不管访问p2变量的成员变量和方法，还是访问p变量的成员变量和方法，它们实际上是访问同一个Person对象的成员变量和方法，将会返回相同的访问结果。
     */

    /**
     * 方法确实是由传统的函数发展而来的，方法与传统的函数有着显著不同：在结构化编程语言里，函数是一等公民，整个软件由一个个的函数组成；
     * 在面向对象编程语言里，类才是一等公民，整个系统由一个个的类组成。因此在Java语言里，方法不能独立存在，方法必须属于类或对象。
     * 所有方法都必须使用“类.方法”或“对象. 方法”的形式来调用。
     */

    /**
     * 参数传递机制
     *
     * Java的实参值是如何传入方法的呢？这是由Java方法的参 数传递机制来控制的，Java里方法的参数传递方式只有一种：值传递。
     * 所谓值传递，就是将实际参数值的副本（复制品）传入方法内，而参数本身不会受到任何影响
     * Java对于引用类型的参数传 递，一样采用的是值传递方式。
     */



}


class DataWarp
{
    int a;
    int b;
}