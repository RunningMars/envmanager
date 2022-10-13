package com.bikego.env.management.controller.testCase.part6;

import org.junit.Test;

public class 内部类 {

    /**
     * 如果一个外部类不使用任何访问控制符修饰，则只能被同一个包中其他类访问。而内部类的上一级程序单元是外部类，
     * 它就具有4个作用域：同一个类、同一个包、父子类和任何位置，因此可以使用4种访问控制权限
     */


    /**
     * 就是在CowLeg类的方法内直接访问 其外部类的private实例变量。这是因为在非静态内部类对象里，
     * 保存了一个它所寄生的外部类对象的引用（当调用非静态内部类的实例方法时，必须有一个非静态内部类实例，
     * 非静态内部类实例必须寄生在外部类实例里）。图6.6显示了上面程序运行时的内存示意图。
     */


    /**
     * 当在非静态内部类的方法内访问某个变量时，系统优先在该方法内查找是否存在该名字的局部变量，如果存在就使用该变量；
     * 如果不存在，则到该方法所在的内部类中查找是否存在该名字的成员变量，如果存在则使用该成员变量；
     * 如果不存在，则到该内部类所在的外部类中查找是否存在该名字的成员变量，如果存在则使用该成员变量；
     * 如果依然不存在，系统将出现编译错误：提示找不到该变量。
     *
     * 因此，如果外部类成员变量、内部类成员变量与内部类里方法的局部变量同名，
     * 则可通过使用this、外部类类名.this作为限定来区分。如下程序所示。
     * DashClinic.this.name 表示外部类的name成员变量
     */


    /**
     * 注意：
     * static关键字的作用是把类的成员变成类相关，而不是实例相关，即static修饰的成员属于整个类，而不属于单个对象。
     * 外部类的上一级程序单元是包，所以不可使用static修饰；而内部类的上一级程序单元是外部类，使用static修饰可以将内部类变成外部类相关，而不是外部类实例相关。
     * 因此static关键字不可修饰外部类，但可修饰内部类。
     */


    /**
     * Java还允许在接口里定义内部类，接口里定义的内部类默认使用public static修饰，也就是说，接口内部类只能是静态内部类。
     */

    /**
     * 在外部类以外使用非静态内部类
     * 如果希望在外部类以外的地方访问内部类（包括静态和非静态两种），则内部类不能使用private访问控制权限，
     * private修饰的内部类只能在外部类内部使用。对于使用其他访问控制符修饰的内部类，则能在访问控制符对应的访问权限内使用。
     * ➢ 省略访问控制符的内部类，只能被与外部类处于同一个包中的其他类所访问。
     * ➢ 使用protected修饰的内部类，可被与外部类处于同一个包中的其他类和外部类的子类所访问。
     * ➢ 使用public修饰的内部类，可以在任何地方被访问。
     */

    /**
     * 在外部类以外的地方定义内部类（包括静态和非静态两种）变量的语法格式如下：
     * OuterClass.InnerClass varName
     */
    @Test
    public void t8()
    {
        Out.In in = new Out().new In("test new in");

        /**
         * 上面代码可以改为如下三行代码
         */
        Out.In inObj;

        Out out = new Out();

        inObj = out.new In("test");

    }

    /**
     * 如果把一个内部类放在方法里定义，则这个内部类就是一个局部内部类，局部内部类仅在该方法里有效。
     * 由于局部内部类不能在外部类的方法以外的地方使用，因此局部内部类也不能使用访问控制符和static修饰符修饰。
     */

    /**
     * 匿名内部类
     * 匿名内部类适合创建那种只需要一次使用的类，例如前面介绍命令模式时所需要的Command对象。
     * 匿名内部类的语法有点奇怪，创建匿名内部类时会立即创建一个该类的实例，这个类定义立即消失，匿名内部类不能重复使用。
     */

    /**
     * 关于匿名内部类还有如下两条规则。
     * ➢ 匿名内部类不能是抽象类，因为系统在创建匿名内部类时，会立即创建匿名内部类的对象。因此不允许将匿名内部类定义成抽象类。
     * ➢ 匿名内部类不能定义构造器。由于匿名内部类没有类名，所以无法定义构造器，但匿名内部类可以定义初始化块，可以通过实例初始化块来完成构造器需要完成的事情。
     */
    @Test
    public void t9()
    {
        this.testFor(new Product(){
            @Override
            public double getPrice() {
                return 108;
            }
            @Override
            public String getName() {
                return "paocai";
            }
        });
    }
    public void testFor(Product p)
    {
        System.out.println(p.getName() + p.getPrice());
    }

}
interface Product{
    double getPrice();
    String getName();
}
class Out{
    class In{
        public In(String msg)
        {
            System.out.println(msg);
        }
    }
}
class SubClass extends Out.In{

    public SubClass(Out out) {
        out.super("rdg");
    }
}
class Outer {
    int prop_out = 10;

    public static void test()
    {
        /**
         * 根据静态成员不能访问非静态成员的规则，外部类的静态方法、静态代码块不能访问非静态内部类，
         * 包括不能使用非静态内部类定义变量、创建实例等。总之，不允许在外部类的静态成员中直接使用非静态内部类。
         */
        //编译不通过
        //Inner inner = new Inner();
    }

    public void accessInnerProp()
    {
        //报错
        //System.out.println(prop_inner);
        System.out.println(new Inner().prop_inner);
    }

    class Inner{
        int prop_inner = 10;

        public void accessOuterProp()
        {
            System.out.println(Outer.this.prop_out);
        }
    }
}

class TestOuter{

    static int p1 = 1;
    int p2 = 2;

    public void testOne()
    {
        /**
         * 外部类依然不能直接访问静态内部类的成员，但可以使用静态内部类的类名作为调用者来访问静态内部类的类成员，
         * 也可以使用静态内部类对象作为调用者来访问静态内部类的实例成员。下面程序示范了这条规则。
         */
        //报错
        //System.out.println(p3);

        System.out.println(TestInner.p3);

        System.out.println(new TestInner().p4);
    }

    static class TestInner{

        static int p3 = 3;
        int p4 = 4;

        public void test()
        {
            System.out.println(p1);

            /**
             * 静态内部类可以包含静态成员，也可以包含非静态成员。根据静态成员不能访问非静态成员的规则，静态内部类不能访问外部类的实例成员，只能访问外部类的类成员。
             * 即使是静态内部类的实例方法也 不能访问外部类的实例成员，只能访问外部类的静态成员。
             */
            //报错
            //System.out.println(p2);
            /**
             * 因为静态内部类是外部类的类相关的，而不是外部类的对象相关的。也就是说，静态内部类对象不是寄生在外部类的实例中，而是寄生在外部类的类本身中。
             * 当静态内部类对象存在时，并不存在一个被它寄生的外部类对象，静态内部类对象只持有外部类的类引用，没有持有外部类对象的引用。
             * 如果允许静态内部类的实例方法访问外部类的实例成员，但找不到被寄生的外部类对象，这将引起错误。
             */
        }
    }
}


