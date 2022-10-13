package com.bikego.env.management.controller.testCase.part18;

import org.junit.Test;

import java.lang.reflect.*;
import java.util.List;

public class ClassLoaderReflect {

    /**
     * JVM和类
     * 当调用java命令运行某个Java程序时，该命令将会启动一个Java虚拟机进程，不管该Java程序有多么复杂，该程序启动了多少个线程，它们都处于该Java虚拟机进程里。
     * 正如前面介绍的，同一个JVM的所有线程、所有变量都处于同一个进程里，它们都使用该JVM进程的内存区。当系统出现以下几种情况时，JVM进程将被终止。
     * ➢ 程序运行到最后正常结束。
     * ➢ 程序运行到使用System.exit() 或Runtime.getRuntime().exit()代码处结束程序。
     * ➢ 程序执行过程中遇到未捕获的异常或错误而结束。
     * ➢ 程序所在平台强制结束了JVM进程。
     */

    /**
     * 类的加载
     * 当程序主动使用某个类时，如果该类还未被加载到内存中，则系统会通过加载、连接、初始化三个步骤来对该类进行初始化。如果没有意外，JVM将会连续完成这三个步骤，
     * 所以有时也把这三个步骤统称为类加载或类初始化。
     * 类加载指的是将类的class文件读入内存，并为之创建一个java.lang.Class对象，也就是说，当程序中使用任何类时，系统都会为之建立一个java.lang.Class对象。
     *
     * 提示：前面介绍面向对象时提到：类是某一类对象的抽象，类是概念层次的东西。但不知道读者有没有想过：类也是一种对象。
     * 就像平常说概念主要用于定义、描述其他事物，但概念本身也是一种事物，那么概念本身也需要被描述——这有点像一个哲学命题。
     * 但事实就是这样，每个类是一批具有相同特征的对象的抽象（或者说概念），而系统中所有的类实际上也是实例，它们都是java.lang.Class的实例。
     */

    /**
     * 类的加载由类加载器完成，类加载器通常由JVM提供，这些类加载器也是前面所有程序运行的基础，JVM提供的这些类加载器通常被称为系统类加载器。
     * 除此之外，开发者可以通过继承ClassLoader基类来创建自己的类加载器。
     * ➢ 从本地文件系统加载class文件，这是前面绝大部分示例程序的类加载方式。
     * ➢ 从JAR包加载class文件，这种方式也是很常见的，前面介绍JDBC编程时用到的数据库驱动类就放在JAR文件中，JVM可以从JAR文件中直接加载该class文件。
     * ➢ 通过网络加载class文件。
     * ➢ 把一个Java源文件动态编译，并执行加载。
     */

    /**
     * JVM初始化一个类包含如下几个步骤。
     * ① 假如这个类还没有被加载和连接，则程序先加载并连接该类。
     * ② 假如该类的直接父类还没有被初始化，则先初始化其直接父类。
     * ③ 假如类中有初始化语句，则系统依次执行这些初始化语句。
     */

    /**
     * 类的连接
     * 当类被加载之后，系统为之生成一个对应的Class对象，接着将会进入连接阶段，连接阶段负责把类的二进制数据合并到JRE中。类连接又可分为如下三个阶段。
     * （1）验证：验证阶段用于检验被加载的类是否有正确的内部结构，并和其他类协调一致。
     * （2）准备：类准备阶段则负责为类的类变量分配内存，并设置默认初始值。
     * （3）解析：将类的二进制数据中的符号引用替换成直接引用。
     */

    /**
     * 类初始化的时机
     * 当Java程序首次通过下面6种方式来使用某个类或接口时，系统就会初始化该类或接口。
     * ➢ 创建类的实例。为某个类创建实例的方式包括：使用new操作符来创建实例，通过反射来创建实例，通过反序列化的方式来创建实例。
     * ➢ 调用某个类的类方法（静态方法）。
     * ➢ 访问某个类或接口的类变量，或为该类变量赋值。
     * ➢ 使用反射方式来强制创建某个类或接口对应的java.lang.Class对象。例如代码：Class.forName（"Person"），如果系统还未初始化Person类，
     *    则这行代码将会导致该Person类被初始化，并返回Person类对应的java.lang.Class对象。关于Class的forName方法请参考18.3节。
     * ➢ 初始化某个类的子类。当初始化某个类的子类时，该子类的所有父类都会被初始化。
     * ➢ 直接使用java.exe命令来运行某个主类。当运行某个主类时，程序会先初始化该主类。
     */

    /**
     * 类加载机制
     * 类加载器负责加载所有的类，系统为所有被载入内存中的类生成一个java.lang.Class实例。一旦一个类被载入JVM中，同一个类就不会被再次载入了。现在的问题是，怎么样才算“同一个类”？
     * 正如一个对象有一个唯一的标识一样，一个载入JVM中的类也有一个唯一的标识。在Java中，一个类用其全限定类名（包括包名和类名）作为标识；但在JVM中，
     * 一个类用其全限定类名和其类加载器作为唯一标识。例如，如果在pg的包中有一个名为Person的类，被类加载器ClassLoader的实例kl负责加载，则该Person类对应的Class对象在JVM
     * 中表示为（Person、pg、kl）。这意味着两个类加载器加载的同名类：（Person、pg、kl）和（Person、pg、kl2）是不同的，它们所加载的类也是完全不同、互不兼容的。
     * 当JVM启动时，会形成由三个类加载器组成的初始类加载器层次结构。
     * ➢ Bootstrap ClassLoader：根类加载器。
     * ➢ Extension ClassLoader：扩展类加载器。
     * ➢ System ClassLoader：系统类加载器。
     *
     * Bootstrap ClassLoader被称为引导（也称为原始或根）类加载器，它负责加载Java的核心类。
     *
     * 注意：
     * JVM的根类加载器并不是Java实现的，而且由于程序通常无须访问根类加载器，因此访问扩展类加载器的父类加载器时返回null。
     */


    /**
     * JVM的类加载机制主要有如下三种。
     * ➢ 全盘负责。所谓全盘负责，就是当一个类加载器负责加载某个Class时，该Class所依赖的和引用的其他Class也将由该类加载器负责载入，除非显式使用另外一个类加载器来载入。
     * ➢ 父类委托。所谓父类委托，则是先让parent（父）类加载器试 图加载该Class，只有在父类加载器无法加载该类时才尝试从自己的类路径中加载该类。
     * ➢ 缓存机制。缓存机制将会保证所有加载过的Class都会被缓存，当程序中需要使用某个Class时，类加载器先从缓存区中搜寻该Class，只有当缓存区中不存在该Class对象时，
     * 系统才会读取该类对应的二进制数据，并将其转换成Class对象，存入缓存区中。这就是为什么修改了Class后，必须重新启动JVM，程序所做的修改才会生效的原因。
     */

    /**
     * JVM中除根类加载器之外的所有类加载器都是ClassLoader子类的实例，开发者可以通过扩展ClassLoader的子类，并重写该ClassLoader所包含的方法来实现自定义的类加载器。
     * 查阅API文档中关于ClassLoader的方法不难发现，ClassLoader中包含了大量的protected方法——这些方法都可被子类重写。
     * ClassLoader类有如下两个关键方法。
     * ➢ loadClass(String name, boolean resolve)：该方法为ClassLoader的入口点，根据指定名称来加载类，系统就是调用ClassLoader的该方法来获取指定类对应的Class对象。
     * ➢ findClass(String name)：根据指定名称来查找类。
     */


    /**
     * 自定义类加载器通常有如下的流程:
     * 找到该类的源文件,读取文件
     * 将读取的文件进行javac编译,检查编译结果
     * 使用源文件读取到的二进制数据来定义并返回一个对应的java.lang.Class实例
     * 中途遇到不可执行的障碍,抛出异常
     *
     * 本示例程序提供的类加载器功能比较简单，仅仅提供了在运行之前先编译Java源文件的功能。实际上，使用自定义的类加载器，可以实现如下常见功能。
     * ➢ 执行代码前自动验证数字签名。
     * ➢ 根据用户提供的密码解密代码，从而可以实现代码混淆器来避免反编译*.class文件。
     * ➢ 根据用户需求来动态地加载类。
     * ➢ 根据应用需求把其他数据以字节码的形式加载到应用中。
     */

    /**
     *  URLClassLoader类
     * Java为ClassLoader提供了一个URLClassLoader实现类，该类也是系统类加载器和扩展类加载器的父类（此处的父类，就是指类与类之间的继承关系）。
     * URLClassLoader功能比较强大，它既可以从本地文件系统获取二进制文件来加载类，也可以从远程主机获取二进制文件来加载类。
     *
     * 一旦得到了URLClassLoader对象之后，就可以调用该对象的loadClass()方法来加载指定类。下面程序示范了如何直接从文件系统中加载MySQL驱动，并使用该驱动来获取数据库连接。
     * 通过这种方式来获取数据库连接，可以无须将MySQL驱动添加到CLASSPATH环境变量中。
     */


    /**
     * 通过反射查看类信息
     * Java程序中的许多对象在运行时都会出现两种类型：编译时类型和运行时类型，例如代码：Person p=new Student();，这行代码将会生成一个p变量，该变量的编译时类型为Person，
     * 运行时类型为Student；除此之外，还有更极端的情形，程序在运行时接收到外部传入的一个对象，该对象的编译时类型是Object，但程序又需要调用该对象运行时类型的方法。
     * 为了解决这些问题，程序需要在运行时发现对象和类的真实信息。解决该问题有以下两种做法。
     * ➢ 第一种做法是假设在编译时和运行时都完全知道类型的具体信息，在这种情况下，可以先使用instanceof运算符进行判断，再利用强制类型转换将其转换成其运行时类型的变量即可。
     * 关于这种方式请参考5.7节的内容。
     * ➢ 第二种做法是编译时根本无法预知该对象和类可能属于哪些类，程序只依靠运行时信息来发现该对象和类的真实信息，这就必须使用反射。
     */

    /**
     * 获得Class对象
     * 前面已经介绍过了，每个类被加载之后，系统就会为该类生成一个对应的Class对象，通过该Class对象就可以访问到JVM中的这个类。在Java程序中获得Class对象通常有如下三种方式。
     * ➢ 使用Class类的forName(String clazzName)静态方法。该方法需要传入字符串参数，该字符串参数的值是某个类的全限定类名（必须添加完整包名）。
     * ➢ 调用某个类的class属性来获取该类对应的Class对象。例如，Person.class将会返回Person类对应的Class对象。
     * ➢ 调用某个对象的getClass()方法。该方法是java.lang.Object类中的一个方法，所以所有的Java对象都可以调用该方法，该方法将会返回该对象所属类对应的Class对象。
     * 对于第一种方式和第二种方式都是直接根据类来取得该类的Class对象，相比之下，第二种方式有如下两种优势。
     * ➢ 代码更安全。程序在编译阶段就可以检查需要访问的Class对象是否存在。
     * ➢ 程序性能更好。因为这种方式无须调用方法，所以性能更好。
     *
     */

    /**
     * 从Class中获取信息
     * Class类提供了大量的实例方法来获取该Class对象所对应类的详细信息，Class类大致包含如下方法，下面每个方法都可能包括多个重载的版本，读者应该查阅API文档来掌握它们。
     */

    @Test
    public void t0() throws NoSuchMethodException {
        Class<TestReflect> testReflectClass = TestReflect.class;

        Method replace = testReflectClass.getMethod("replace", String.class, List.class);

        System.out.println("方法的参数个数: " + replace.getParameterCount());

        Parameter[] parameters = replace.getParameters();

        var index = 1;

        for (var p:parameters)
        {
            if (p.isNamePresent())
            {
                System.out.println("---第" + index++ + "个参数信息---");
                System.out.println("参数名" + p.getName());
                System.out.println("参数类型" + p.getType());
                System.out.println("泛型类型" + p.getParameterizedType());
            }
        }
    }

    /**
     * 使用反射生成并操作对象
     * 创建对象
     * 通过反射来生成对象需要先使用Class对象获取指定的Constructor对象，再调用Constructor对象的newInstance()方法来创建该Class对象对应类的实例。
     * 通过这种方式可以选择使用指定的构造器来创建实例。
     */

    /**
     *
     * 很多Java EE框架中都需要根据配置文件信息来创建Java对象，从配置文件读取的只是某个类的字符串类名，程序需要根据该字符串来创建对应的实例，就必须使用反射。
     * 下面程序就实现了一个简单的对象池，该对象池会根据配置文件读取key-value对，然后创建这些对象，并将这些对象放入一个HashMap中。
     *
     * 提示：这种使用配置文件来配置对象，然后由程序根据配置文件来创建对象的方式非常有用，大名鼎鼎的Spring框架就采用这种方式大大简化了Java EE应用的开发。
     * 当然，Spring采用的是XML配置文件 —— 毕竟属性文件能配置的信息太有限了，而XML配置文件能配置的信息就丰富多了。
     */

    /**
     * 调用方法
     * 当获得某个类对应的Class对象后，就可以通过该Class对象的getMethods()方法或者getMethod()方法来获取全部方法或指定方法 —— 这两个方法的返回值是Method数组，或者Method对象。
     * 每个Method对象对应一个方法，获得Method对象后，程序就可通过该Method来调用它对应的方法。在Method里包含一个invoke()方法，该方法的签名如下。
     * ➢ Object invoke(Object obj, Object...args)：该方法中的obj是执行该方法的主调，后面的args是执行该方法时传入该方法的实参。
     *
     * 当通过Method的invoke()方法来调用对应的方法时，Java会要求程序必须有调用该方法的权限。如果程序确实需要调用某个对象的private方法，则可以先调用Method对象的如下方法。
     * ➢ setAccessible(boolean flag)：将Method对象的accessible设置为指定的布尔值。值为true，指示该Method在使用时应该取消
     * Java语言的访问权限检查；值为false，则指示该Method在使用时要实施Java语言的访问权限检查。
     */

    /**
     * 访问成员变量值 通过Class对象的getFields()或getField()方法可以获取该类所包括的全部成员变量或指定成员变量。Field提供了如下两组方法来读取或设置成员变量值。
     * ➢ getXxx(Object obj)：获取obj对象的该成员变量的值。此处的Xxx对应8种基本类型，如果该成员变量的类型是引用类型，则取消get后面的Xxx。
     * ➢ setXxx(Object obj, Xxx val)：将obj对象的该成员变量设置成val值。此处的Xxx对应8种基本类型，如果该成员变量的类型是引用类型，则取消set后面的Xxx。
     * 使用这两个方法可以随意地访问指定对象的所有成员变量，包括private修饰的成员变量。
     */
    @Test
    public void t2() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> clazz = Person.class;

        Person p = clazz.getConstructor().newInstance();

        Field age = clazz.getDeclaredField("age");
        Field name = clazz.getDeclaredField("name");

        age.setAccessible(true);
        name.setAccessible(true);

        age.setInt(p,22);
        name.set(p,"rdgrdg");

        System.out.println(p);
    }


    /**
     * 下面程序比上面程序稍微复杂一点，下面程序使用Array类创建了一个三维数组
     */
    @Test
    public void t4()
    {
        Object arr = Array.newInstance(String.class,10);
        Array.set(arr,5,"crazyJava");
        Array.set(arr,7,"crazyPHP");

        System.out.println(Array.get(arr,5));

        System.out.println("***********************");
        Object as = new String[4];
        Array.set(as,2,"crazyJava");
        Array.set(as,3,"crazyPHP");
        for (var i : (String[])as)
        {
            System.out.println(i);
        }
        System.out.println(as);
        System.out.println("***********************");

        Object arr2 = Array.newInstance(String.class,3,4,10);
        Object arrObj = Array.get(arr2,2);
        Array.set(arrObj,2,new String[]{"sdfs","ffff"});

        Object anArr = Array.get(arrObj, 3);
        Array.set(anArr,8,"讲义");

        var cast = (String[][][])arr2;
        System.out.println(cast[2][3][8]);

        System.out.println(cast);
    }
}

class TestReflect{
    public void replace(String str, List<String> list){}
}
class Person{
    public Person() { }
    private int age;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String name;
    @Override
    public String toString() {
        return "Person{" + "age=" + age + ", name='" + name + '\'' + '}';
    }
}