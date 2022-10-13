package com.bikego.env.management.controller.testCase.part15;

import org.junit.Test;

import java.io.*;

public class IO {

    /**
     * 不管是文件还是目录都是使用File来操作的，File能新建、删除、重命名文件和目录，File不能访问文件内容本身。
     * 如果需要访问文件内容本身，则需要使用输入/输出流。
     */

    /**
     * Java对象的序列化机制，使用序列化机 制可以把内存中的Java对象转换成二进制字节流，这样就可以把Java
     * 对象存储到磁盘里，或者在网络上传输Java对象。这也是Java提供分
     * 布式编程的重要基础。
     */

    /**
     * 理解Java的IO流
     * Java的IO流是实现输入/输出的基础，它可以方便地实现数据的输入/输出操作，在Java中把不同的输入/输出源（键盘、文件、网络连 接等）抽象表述为“流”（stream），
     * 通过流的方式允许Java程序使用相同的方式来访问不同的输入/输出源。stream是从起源（source）到接收（sink）的有序数据。
     *
     * 提示：因为Java提供了这种IO流的抽象，所以开发者可以使用一致的IO代码去读写不同的IO流节点。
     *
     * 1.输入流和输出流
     * 按照流的流向来分，可以分为输入流和输出流。
     * ➢ 输入流：只能从中读取数据，而不能向其写入数据。
     * ➢ 输出流：只能向其写入数据，而不能从中读取数据。
     * 划分输入/输出流时是从程序运行所在内存的角度来考虑的
     *
     * Java的输入流主要由InputStream和Reader作为基类，而输出流则主要由OutputStream和Writer作为基类。
     * 它们都是一些抽象基类，无法直接创建实例。
     *
     * 2.字节流和字符流字节流和字符流的用法几乎完全一样，区别在于字节流和字符流所操作的数据单元不同——字节流操作的数据单元是8位的字节，
     * 而字符流操作的数据单元是16位的字符。
     * 字节流主要由InputStream和OutputStream作为基类，而字符流则主要由Reader和Writer作为基类。
     */


    /**
     * Java的IO流的40多个类都是从如下4个抽象基类派生的。
     * ➢ InputStream/Reader：所有输入流的基类，前者是字节输入流，后者是字符输入流。
     * ➢ OutputStream/Writer：所有输出流的基类，前者是字节输出流，后者是字符输出流。
     * 对于InputStream和Reader而言，它们把输入设备抽象成一个“水管”，这个水管里的每个“水滴”依次排列
     */

    /**
     * InputStream 和 Reader 都是抽象类，本身不能创建实例，但它们分别有一个用于读取文件的输入流：
     * FileInputStream 和 FileReader，它们都是节点流——会直接和指定文件关联。
     */

    /**
     * 提示：由于PrintStream类的输出功能非常强大，通常如果需要输出文
     * 本内容，都应该将输出流包装成PrintStream后进行输出。
     */

    /**
     * 通常有一个规则：
     * 如果进行输入/输出的内容是文本内容，则应该考虑使用字符流；
     * 如果进行输入/输出的内容是二进制内容，则应该考虑使用字节流。
     */

    /**
     * 比特(bit)
     * 信息的最小单位,0或1
     *
     * 字节（Byte）
     * 是计算机信息技术用于计量存储容量的一种计量单位，也表示一些计算机编程语言中的数据类型和语言字符
     * 一个字节存储8位无符号数，储存的数值范围为0-255。如同字元一样，字节型态的变数只需要用一个位元组（8位元）的内存空间储存
     * 信息存储量是度量存储器存放程序和数据的数量。其主要度量单位是字节，1个字节（Byte）等于8位（bit）二进制。
     * ByteDance 字节跳动
     */

    /**
     * 重定向标准输入/输出
     * Java的标准输入/输出分别通过System.in和System.out来代表，在默认情况下它们分别代表键盘和显示器，当程序通过System.in来获取输入时，
     * 实际上是从键盘读取输入；当程序试图通过System.out执行输出时，程序总是输出到屏幕。
     * 在System类里提供了如下三个重定向标准输入/输出的方法。
     * ➢ static void setErr(PrintStream err)：重定向 “标准”错误输出流。
     * ➢ static void setIn(InputStream in)：重定向“标准”输入流。
     * ➢ static void setOut(PrintStream out)：重定向 “标准”输出流。
     * 下面程序通过重定向标准输出流，将System.out的输出重定向到文件输出，而不是在屏幕上输出。
     *
     */
    @Test
    public void t0()
    {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("test-system.log");
            PrintStream printStream = new PrintStream(fileOutputStream);

            System.setOut(printStream);

            System.out.println("test system out23234");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Java虚拟机读写其他进程的数据
     * 使用Runtime对象的exec()方法可以运行平 台上的其他程序，该方法产生一个Process对象，Process对象代表由 该Java程序启动的子进程。
     * Process类提供了如下三个方法，用于让程序和其子进程进行通信。
     *
     * ➢ InputStream getErrorStream()：获取子进程的错误流。
     * ➢ InputStream getInputStream()：获取子进程的输入流。
     * ➢ OutputStream getOutputStream()：获取子进程的输出流。
     *
     * 注意： 此处的输入流、输出流非常容易混淆，如果试图让子进程读取程序中的数据，那么应该用输入流还是输出流？
     * 不是输入流，而是输出流。要站在Java程序的角度来看问题，子进程读取Java程序的数据，就是让Java程序把数据输出到
     * 子进程中（就像把数据输出到文件中一样，只是现在由子进程节点代替了文件节点），所以应该使用输出流。
     */
    @Test
    public void t1() throws IOException {
        Process p = Runtime.getRuntime().exec("javac");

        InputStreamReader inputStreamReader = new InputStreamReader(p.getInputStream());

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String buff = null;

        while((buff = bufferedReader.readLine()) != null )
        {
            System.out.println(buff);
        }

    }

    /**
     * RandomAccessFile
     * 它既可以读取文件内容，也可以向文件输出数据。与普通的输入/输出流不同的是，RandomAccessFile支持“随机访问”的方式，
     * 程序可以直接跳转到文件的任意地方来读写数据。
     *
     * 由于RandomAccessFile可以自由访问文件的任意位置，所以如果只需要访问文件部分内容，而不是把文件从头读到尾，
     * 使用RandomAccessFile将是更好的选择。
     */

    /**
     * Java 9改进的对象序列化
     *
     * 对象序列化的目标是将对象保存到磁盘中，或允许在网络中直接传输对象。对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，
     * 从而允许把这种二进制流持久地保存在磁盘上，通过网络将这种二进制流传输到另一个网络节点。其他程序一旦获得了这种二进制流
     * （无论是从磁盘中获取的，还是通过网络获取的），都可以将这种二进制流恢复成原来的Java对象。
     */

    /**
     * 序列化的含义和意义
     * 序列化机制允许将实现序列化的Java对象转换成字节序列，这些字节序列可以保存在磁盘上，或通过网络传输，以备以后重新恢复成
     * 原来的对象。序列化机制使得对象可以脱离程序的运行而独立存在。
     * 对象的序列化（Serialize）指将一个Java对象写入IO流中，与此对应的是，对象的反序列化（Deserialize）则指从IO流中恢复该Java对象。
     * Java 9增强了对象序列化机制，它允许对读入的序列化数据进行过滤，这种过滤可在反序列化之前对数据执行校验，从而提高安全性和健壮性。
     * 如果需要让某个对象支持序列化机制，则必须让它的类是可序列化的（serializable）。为了让某个类是可序列化的，该类必须实现如下两个接口之一。
     * ➢ Serializable
     * ➢ Externalizable
     * Java的很多类已经实现了Serializable，该接口是一个标记接口，实现该接口无须实现任何方法，它只是表明该类的实例是可序列化的。
     * 所有可能在网络上传输的对象的类都应该是可序列化的，否则程序将会出现异常，比如RMI（Remote Method Invoke，即远程方法调用，是Java EE的基础）
     * 过程中的参数和返回值；所有需要保存到磁盘里的对象的类都必须可序列化，比如Web应用中需要保存到HttpSession或ServletContext属性的Java对象。
     * 因为序列化是RMI过程的参数和返回值都必须实现的机制，而RMI又是Java EE技术的基础——所有的分布式应用常常需要跨平台、跨网络，
     * 所以要求所有传递的参数、返回值必须实现序列化。因此序列化机制是Java EE平台的基础。通常建议：程序创建的每个JavaBean类都实现Serializable。
     */
    @Test
    public void t3() throws IOException {
        Person p = new Person("孙悟空", 500);

        FileOutputStream fileOutputStream = new FileOutputStream("object.txt");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(p);

        System.out.println("done");
    }

    @Test
    public void t4() throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("object.txt");

        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Object o = objectInputStream.readObject();

        if (o instanceof Person)
        {
            var o2 = (Person)o;

            System.out.println( o2);
            System.out.println( o2.getName());
            System.out.println( o2.getAge());
        }

    }

    /**
     * 对象引用的序列化
     * 前面介绍的Person类的两个成员变量分别是String类型和int类型，如果某个类的成员变量的类型不是基本类型或String类型，
     * 而是另一个引用类型，那么这个引用类必须是可序列化的，否则拥有该类型成员变量的类也是不可序列化的。
     * 如下Teacher类持有一个Person类的引用，只有Person类是可序列化的，Teacher类才是可序列化的。
     * 如果Person类不可序列化，则无论Teacher类是否实现Serilizable、Externalizable接口，则Teacher类都是不可序列化的。
     */

    /**
     * Java序列化机制采用了一种特殊的序列化算法，其算法内容如下。
     * ➢ 所有保存到磁盘中的对象都有一个序列化编号。
     * ➢ 当程序试图序列化一个对象时，程序将先检查该对象是否已经被序列化过，只有该对象从未（在本次虚拟机中）被序列化
     * 过，系统才会将该对象转换成字节序列并输出。
     * ➢ 如果某个对象已经序列化过，程序将只是直接输出一个序列化编号，而不是再次重新序列化该对象。
     */

    /**
     * 注意： 当使用Java序列化机制序列化可变对象时一定要注意，只有第 一次调用wirteObject()方法来输出对象时才会
     * 将对象转换成字节序列，并写入到ObjectOutputStream；在后面程序中即使该对象的实例变量发生了改变，
     * 再次调用writeObject()方法输出该对象时，改变后的实例变量也不会被输出。
     */

    /**
     * Java 9 为 ObjectInputStream 增加了
     * setObjectInputFilter() 、getObjectInputFilter()两个方法，其中第一个方法用于为对象输入流设置过滤器。
     * 当程序通过ObjectInputStream反序列化对象时，过滤器的checkInput()方法会被自动激发，用于检查序列化数据是否有效。
     * 使用checkInput()方法检查序列化数据时有3种返回值。
     * ➢ Status.REJECTED：拒绝恢复。
     * ➢ Status.ALLOWED：允许恢复。
     * ➢ Status.UNDECIDED：未决定状态，程序继续执行检查。
     */

    /**
     * 提示：
     * transient关键字只能用于修饰实例变量，不可修饰Java程序中的其他成分。
     */

    /**
     *  序列化版本
     * Java序列化机制允许为序列化类提供一个private static final
     * 的serialVersionUID值，该类变量的值用于标识该Java类的序列化版 本，也就是说，如果一个类升级后，只要它的serialVersionUID类变
     * 量值保持不变，序列化机制也会把它们当成同一个序列化版本。
     *
     * 如果类的修改确实会导致该类反序列化失败，则应该为该类的serialVersionUID类变量重新分配值。那么对类的哪些修改可能导致
     * 该类实例的反序列化失败呢？下面分三种情况来具体讨论。
     * ➢ 如果修改类时仅仅修改了方法，则反序列化不受任何影响，类定义无须修改serialVersionUID类变量的值。
     * ➢ 如果修改类时仅仅修改了静态变量或瞬态实例变量，则反序列化不受任何影响，类定义无须修改serialVersionUID类变量的值。
     * ➢ 如果修改类时修改了非瞬态的实例变量，则可能导致序列化版本不兼容。如果对象流中的对象和新类中包含同名的实例变量，
     * 而实例变量类型不同，则反序列化失败，类定义应该更新
     * serialVersionUID类变量的值。如果对象流中的对象比新类中包含更多的实例变量，则多出的实例变量值被忽略，序列化版本可以兼容，
     * 类定义可以不更新serialVersionUID类变量的值；如果新类比对象流中的对象包含更多的实例变量，则序列化版本也可以兼容，
     * 类定义可以不更新serialVersionUID类变量的值；但反序列化得到的新对象中多出的实例变量值都是
     * null（引用类型实例变量）或0（基本类型实例变量）。
     */

    /**
     * Java新IO概述 NIO
     * 新IO和传统的IO有相同的目的，都是用于进行输入/输出，但新IO使用了不同的方式来处理输入/输出，新IO采用内存映射文件的方式来
     * 处理输入/输出，新IO将文件或文件的一段区域映射到内存中，这样就可以像访问内存一样来访问文件了（这种方式模拟了操作系统上的虚
     * 拟内存的概念），通过这种方式来进行输入/输出比传统的输入/输出要快得多。
     *
     * Channel（通道）和Buffer（缓冲）是新IO中的两个核心对象，
     * Channel是对传统的输入/输出系统的模拟，在新IO系统中所有的数据 都需要通过通道传输；Channel与传统的InputStream、OutputStream
     * 最大的区别在于它提供了一个map()方法，通过该map()方法可以直接 将“一块数据”映射到内存中。如果说传统的输入/输出系统是面向流
     * 的处理，则新IO则是面向块的处理。
     *
     * Buffer可以被理解成一个容器，它的本质是一个数组，发送到
     * Channel中的所有对象都必须首先放到Buffer中，而从Channel中读取 的数据也必须先放到Buffer中。此处的Buffer有点类似于前面介绍的 “竹筒”，但该Buffer既可以像“竹筒”那样一次次去Channel中取
     * 水，也允许使用Channel直接将文件的某块数据映射成Buffer。
     */

    /**
     * 字符集
     * Java 7 新增了一个StandardCharsets类，该类里包含了ISO_8859_1、UTF_8、UTF_16等类变量，
     * 这些类变量代表了最常用的字符集对应的Charset对象。
     */

    /**
     * 文件锁
     * 文件锁在操作系统中是很平常的事情，如果多个运行的程序需要并发修改同一个文件时，程序之间需要某种机制来进行通信，
     * 使用文件锁可以有效地阻止多个进程并发修改同一个文件，所以现在的大部分操作系统都提供了文件锁的功能。
     * lock()和tryLock()方法存在区别：当lock()试图锁定某个文件时，如果无法得到文件锁，程序将一直阻塞；而
     * tryLock()是尝试锁定文件，它将直接返回而不是阻塞，如果获得了文件锁，该方法则返回该文件锁，否则将返回null。
     *
     * 当参数shared为true时，表明该锁是一个共享锁，它将允许多个进程来读取该文件，但阻止其他进程获得对该文件的排他锁。
     * 当shared为false时，表明该锁是一个排他锁，它将锁住对该文件的读写。程序可以通过调用FileLock的isShared来判断
     * 它获得的锁是否为共享锁。
     */

}



class Person implements Serializable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age ;

    public Person(String name,int age)
    {
        this.name = name;
        this.age = age;
    }
}