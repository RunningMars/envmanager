package com.bikego.env.management.controller.testCase.part5;

import org.junit.Test;

public class Oop2 {

    /**
     * Java允许同一个类里定义多个同名方法，只要形参列表不同就行。
     * 如果同一个类中包含了两个或两个以上方法的方法名相同，但形参列表不同，则被称为方法重载
     */


    /**
     * 局部变量根据定义形式的不同，又可以被分为如下三种。
     * - 形参：在定义方法签名时定义的变量，形参的作用域在整个方法内有效。
     * - 方法局部变量：在方法体内定义的局部变量，它的作用域是从定义该变量的地方生效，到该方法结束时失效。
     * - 代码块局部变量：在代码块中定义的局部变量，这个局部变量的作用域从定义该变量的地方生效，到该代码块结束时失效。
     * 与成员变量不同的是，局部变量除形参之外，都必须显式初始 化。也就是说，必须先给方法局部变量和代码块局部变量指定初始值，否则不可以访问它们。
     */


    /**
     *
     * 局部变量的初始化和内存中的运行机制局部变量定义后，必须经过显式初始化后才能使用，系统不会为局部变量执行初始化。这意味着定义局部变量后，
     * 系统并未为这个变量分配内存空间，直到等到程序为这个变量赋初始值时，系统才会为局部变量分配内存，并将初始值保存到这块内存中。
     *
     * 栈内存中的变量无须系统垃圾回收，往往随方法或代码块的运行结束而结束。因此，局部变量的作用域是从初始化该变量开始，直到该方法或该代码块运行完成而结束。
     * 因为局部变量只保存基本类型的值或者对象的引用，因此局部变量所占的内存区通常比较小。
     */

    @Test
    public void test()
    {
        int b =6;
        {
            int a;
            a = 5;
            System.out.println(a);
            System.out.println(b);
        }
        //编译报错:a不存在
//        System.out.println(a);
    }

    @Test
    public void t4()
    {
        TestProtectedInSamePackage testProtectedInSamePackage = new TestProtectedInSamePackage(123);
        testProtectedInSamePackage.protectedMethod();

        Oop2 oop2 = new Oop2();
        oop2.t5();
    }

    @Test
    protected void t5()
    {
        System.out.println("t5");
    }

    @Test
    public void t1()
    {
        int b =6;
        /**
         * 变量i ,是代码块局部变量,作用域仅为在for循环代码块中
         */
        /**
         *  区别于php,在php中在循环后依然可以访问到变量
         *  for($i=0;$i<10;$i++){
         *      $temp = 'temp';
         *      var_dump("sss");
         *  }
         *  var_dump('$i=',$i); // $i=10
         *  var_dump('$temp=',$temp); //$temp=temp
         */
        for(var i = 0;i<10;i++)
        {
            var s = "ss";
            System.out.println(s);
            System.out.println("Hello!");
        }
        //报错:找不到变量i
//        System.out.println(i);
        //报错:找不到变量s
//        System.out.println(s);
    }

    /**
     * 封装
     * 封装实际上有两个方面的含义：把该隐藏的隐藏起来，把 该暴露的暴露出来。这两个方面都需要通过使用Java提供的访问控制符来实现。
     *
     * 提示：
     * Java类里实例变量的setter和getter方法有非常重要的意义。 例如，某个类里包含了一个名为abc的实例变量，则其对应的setter
     * 和getter方法名应为setAbc()和getAbc()（即将原实例变量名的首字母大写，并在前面分别增加set和get动词，就变成setter和getter方法名）。如果一个Java类的每个实例变量都被使用private
     * 修饰，并为每个实例变量都提供了public修饰setter和getter方 法，那么这个类就是一个符合JavaBean规范的类。因此，JavaBean总是一个封装良好的类。
     * setter和getter方法合起来变成属性，如果只有getter方法，则是只读属性。
     *
     * 提示：一个类常常就是一个小的模块，应该只让这个模块公开必须让外界知道的内容，而隐藏其他一切内容。
     * 进行程序设计时，应尽量避免一个模块直接操作和访问另一个模块的数据，
     * 模块设计追求高内聚（尽可能把模块的内部数据、功能实现细节隐藏在模块内部独 立完成，不允许外部直接干预）
     * 、低耦合（仅暴露少量的方法给外部使用）。正如日常常见的内存条，内存条里的数据及其实现细节被完全隐藏在内存条里面，外部设备（如主机板）只能通过内存条
     * 的金手指（提供一些方法供外部调用）来和内存条进行交互。
     */

    /**
     * 访问控制级别
     * private（当前类访问权限）：如果类里的一个成员（包括成员变量、方法和构造器等）使用private访问控制符来修饰，则这个成员只能在当前类的内部被访问。
     * 很显然，这个访问控制符用于修饰成员变量最合适，使用它来修饰成员变量就可以把成员变量隐藏在该类的内部。
     * default（包访问权限）：如果类里的一个成员（包括成员变量、方法和构造器等）或者一个外部类不使用任何访问控制符修饰，就称它是包访问权限的，default访问控制的成员或外部
     * 类可以被相同包下的其他类访问。关于包的介绍请看5.4.3节。
     * protected（子类访问权限）：如果一个成员（包括成员变 量、方法和构造器等）使用protected访问控制符修饰，那么这 个成员既可以被同一个包中的其他类访问，也可以被不同包中的子类访问。
     * 在通常情况下，如果使用protected来修饰一个方法，通常是希望其子类来重写这个方法。关于父类、子类的介绍请参考5.6节的内容。
     * public（公共访问权限）：这是一个最宽松的访问控制级别，如果一个成员（包括成员变量、方法和构造器等）或者一个外 部类使用public访问控制符修饰，那么这个成员或外部类就可
     * 以被所有类访问，不管访问类和被访问类是否处于同一个包中，是否具有父子继承关系。
     *
     *
     * 关于访问控制符的使用，存在如下几条基本原则。
     * ➢ 类里的绝大部分成员变量都应该使用private修饰，只有一些static修饰的、类似全局变量的成员变量，才可能考虑使用
     * public修饰。除此之外，有些方法只用于辅助实现该类的其他方法，这些方法被称为工具方法，工具方法也应该使用private修饰。
     * ➢ 如果某个类主要用做其他类的父类，该类里包含的大部分方法可能仅希望被其子类重写，而不想被外界直接调用，则应该使用protected修饰这些方法。
     * ➢ 希望暴露出来给其他类自由调用的方法应该使用public修饰。因此，类的构造器通过使用public修饰，从而允许在其他地方创建该类的实例。
     * 因为外部类通常都希望被其他类自由使用,所以大部分外部类都使用public修饰。
     */

    /**
     * 使用import语句导入指定包下全部类的用法如下：
     * import com.iapps.env.management.controller...*;
     * import com.iapps.env.management.controller.*;
     *
     * 上面错误提示：在HelloTest.java文件的第25行使用了Date类，而import语句导入的java.sql和java.util包下都包含了Date类，系统糊涂了！
     * 再次提醒读者：不要把系统搞糊涂，系统一糊涂就是你错了。在这种情况下，如果需要指定包下的Date类，则只能使用该类的全名。
     *
     * java.sql.Date d = new java.sql.Date();
     * java.util.Date d2 = new java.util.Date();
     */


    /**
     * 静态导入
     * 导入指定类的某个静态成员变量、方法或全部的静态成员变量、方法。
     * import static com.iapps.env.management.service.impl.VariableServiceImpl.*;
     */

    /**
     * Java的常用包
     * Java的核心类都放在java包以及其子包下，Java扩展的许多类都放在javax包以及其子包下。这些实用类也就是前面所说的API（应用程序接口），
     * Oracle按这些类的功能分别放在不同的包下。下面几个包是Java语言中的常用包。
     * ➢ java.lang：这个包下包含了Java语言的核心类，如String、Math、System和Thread类等，使用这个包下的类无须使用import语句导入，系统会自动导入这个包下的所有类。
     * ➢ java.util：这个包下包含了Java的大量工具类/接口和集合框架类/接口，例如Arrays和List、Set等。
     * ➢ java.net：这个包下包含了一些Java网络编程相关的类/接口。
     * ➢ java.io：这个包下包含了一些Java输入/输出编程相关的类/接口。
     * ➢ java.text：这个包下包含了一些Java格式化相关的类。
     * ➢ java.sql：这个包下包含了Java进行JDBC数据库编程的相关类/接口。
     * ➢ java.awt：这个包下包含了抽象窗口工具集（Abstract Window Toolkits）的相关类/接口，这些类主要用于构建图形用户界面（GUI）程序。
     * ➢ java.swing：这个包下包含了Swing图形用户界面编程的相关类/接口，这些类可用于构建平台无关的GUI程序。
     */


    /**
     * 构造器
     * 学生提问：构造器是创建Java对象的途径，是不是说构造器完全负责创建Java对象？
     * 答：不是！构造器是创建Java对象的重要途径，通过new关键字调用构造器时，构造器也确实返回了该类的对象，但这个对象并不是完全由构造器负责创建的。
     * 实际上，当程序员调用构造器时，系统会先为该对象分配内存空间，并为这个对象执行默认初始化，这个对象已经产生了——这些操作在构造器执行之前就都完成了。
     * 也就是说，当系统开始执行构造器的执行体之前，系统已经创建了一个对象，只是这个对象还不能被外部程序访问，只能在该构造器中通过this来引用。
     * 当构造器的执行体执行结束后，这个对象作为构造器的返回值被返回，通常还会赋给另一个引用类型的变量，从而让外部程序可以访问该对象。
     */


    /**
     * 继承
     * Java语言摒弃了C++中难以理解的多继承特征，即每个类最多只有一个直接父类。
     *
     * 重写方法后,返回值类型和异常类型不得大于被重写方法
     * 方法的重写要遵循“两同两小一大”规则，“两同”即方法名相同、形参列表相同；“两小”指的是子类方法返回值类型应比父类方法返回值类型更小或相等，
     * 子类方法声明抛出的异常类应比父类方法声明抛出的异常类更小或相等；“一大”指的是子类方法的访问权限应比父类方法的访问权限更大或相等。
     * 尤其需要指出的是，覆盖方法和被覆盖方法要么都是类方法，要么都是实例方法，不能一个是类方法，一个是实例方法。例如，如下代码将会引发编译错误。
     *
     * 尤其需要指出的是，覆盖方法和被覆盖方法要么都是类方法，要么都是实例方法，不能一个是类方法，一个是实例方法。
     *
     * 如果在某个方法中访问名为a的成员变量，但没有显式指定调用者，则系统查找a的顺序为：
     * ①查找该方法中是否有名为a的局部变量。
     * ②查找当前类中是否包含名为a的成员变量。
     * ③查找a的直接父类中是否包含名为a的成员变量，依次上溯a的所有父类，直到java.lang.Object类，如果最终不能找到名为a的成员变量，则系统出现编译错误。
     */

    /**
     * super是Java提供的一个关键字
     * super用于限定该对象调用它从父类继承得到的实例变量或方法。
     * 正如this不能出现在static修饰的方法中一样，super也不能出现在static修饰的方法中。
     * static修饰的方法是属于类的，该方法的调用者可能是一个类，而不是对象，因而super限定也就失去了意义。
     *
     */

    /**
     * 如果子类定义了和父类同名的实例变量，则会发生子类实例变量隐藏父类实例变量的情形。
     * 在正常情况下，子类里定义的方法直接访问该实例变量默认会访问到子类中定义的实例变量，无法访问到父类中被隐藏的实例变量。
     * 在子类定义的实例方法中可以通过super来访问父类中被隐藏的实例变量
     */


}

    /**
     * 子类调用父类构造器
     */
    class TestProtectedInSamePackage{
        public TestProtectedInSamePackage(int s){

        }
        protected void protectedMethod()
        {
            System.out.println("It's Protected Method In Same Package");
        }
    }

    class TestProtectedInSamePackageChild extends TestProtectedInSamePackage{
        public TestProtectedInSamePackageChild(int s)
        {
            super(s);
            System.out.println("It's Protected Method In Same Package");
        }
    }

    /**
     * 构造器重载
     */
    class Apple{

        public String name;
        public String color;
        public double weight;

        public Apple()
        {

        }

        public Apple(String name,String color)
        {
            this.name = name;
            this.color = color;
        }

        public Apple(String name,String color,double w)
        {
            this(name,color);
            weight = w;
        }

    }

    class SubApple extends  Apple
    {
        @Test
        public void t7()
        {
            //报错
            SubApple subApple = new SubApple();
            System.out.println(123);
        }
    }


    /**
     * 子类构造器调用父类构造器分如下几种情况。
     * ➢ 子类构造器执行体的第一行使用super显式调用父类构造器，系统将根据super调用里传入的实参列表调用父类对应的构造器。
     * ➢ 子类构造器执行体的第一行代码使用this显式调用本类中重载的构造器，系统将根据this调用里传入的实参列表调用本类中的另一个构造器。执行本类中另一个构造器时也会先调用父类构造器。
     * ➢ 子类构造器执行体中既没有super调用，也没有this调用，系统将会在执行子类构造器之前，隐式调用父类无参数的构造器。
     * 不管上面哪种情况，当调用子类构造器来初始化子类对象时，父类构造器总会在子类构造器之前执行；不仅如此，执行父类构造器时，系统会再次上溯执行其父类构造器……依此类推，
     * 创建任何Java对象，最先执行的总是java.lang.Object类的构造器。
     */


