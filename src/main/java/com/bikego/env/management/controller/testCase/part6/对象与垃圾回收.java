package com.bikego.env.management.controller.testCase.part6;

public class 对象与垃圾回收 {

    /**
     * 垃圾回收机制具有如下特征。
     * ➢ 垃圾回收机制只负责回收堆内存中的对象，不会回收任何物理资源（例如数据库连接、网络IO等资源）。
     * ➢ 程序无法精确控制垃圾回收的运行，垃圾回收会在合适的时候进行。当对象永久性地失去引用后，系统就会在合适的时候回收它所占的内存。
     * ➢ 在垃圾回收机制回收任何对象之前，总会先调用它的finalize()方法，该方法可能使该对象重新复活（让一个引用变量重新引用该对象），
     *    从而导致垃圾回收机制取消回收。
     */

    /**
     * 对象在内存中的状态当一个对象在堆内存中运行时，根据它被引用变量所引用的状态，可以把它所处的状态分成如下三种。
     * ➢ 可达状态：当一个对象被创建后，若有一个以上的引用变量引用它，则这个对象在程序中处于可达状态，程序可通过引用变
     * 量来调用该对象的实例变量和方法。
     * ➢ 可恢复状态：如果程序中某个对象不再有任何引用变量引用它，它就进入了可恢复状态。在这种状态下，系统的垃圾回收机制准备回收该对象所占用的内存，
     * 在回收该对象之前，系统会调用所有可恢复状态对象的finalize()方法进行资源清理。如果系统在调用finalize()方法时重新让一个引用变量引用该对象，
     * 则这个对象会再次变为可达状态；否则该对象将进入不可达状态。
     * ➢ 不可达状态：当对象与所有引用变量的关联都被切断，且系统已经调用所有对象的finalize()方法后依然没有使该对象变成可达状态，那么这个对象将永久性地失去引用，
     * 最后变成不可达状态。只有当一个对象处于不可达状态时，系统才会真正回收该对象所占有的资源。
     */

    /**
     * 强制系统垃圾回收有如下两种方式。
     * ➢ 调用System类的gc()静态方法：System.gc()。
     * ➢ 调用 Runtime 对象的gc()实例方法：Runtime.getRuntime().gc()。
     */

    /**
     * finalize()方法具有如下4个特点。
     * ➢ 永远不要主动调用某个对象的finalize()方法，该方法应交给垃圾回收机制调用。
     * ➢ finalize()方法何时被调用，是否被调用具有不确定性，不要把finalize()方法当成一定会被执行的方法。
     * ➢ 当JVM执行可恢复对象的finalize()方法时，可能使该对象或系统中其他对象重新变成可达状态。
     * ➢ 当JVM执行finalize()方法时出现异常时，垃圾回收机制不会报告异常，程序继续执行。
     *
     * 注意：由于finalize()方法并不一定会被执行，因此如果想清理某个类里打开的资源，则不要放在finalize()方法中进行清理。
     */


    /**
     * 当开发了一个应用程序后，这个应用程序包含了很多类，如果需要把这个应用程序提供给别人使用，通常会将这些类文件打包成一个JAR文件，把这个JAR文件提供给别人使用。只要别人在系统的
     * CLASSPATH环境变量中添加这个JAR文件，则Java虚拟机就可以自动在内存中解压这个JAR包，把这个JAR文件当成一个路径，在这个路径中查找所需要的类或包层次对应的路径结构。
     * 使用JAR文件有以下好处。
     * ➢ 安全。能够对JAR文件进行数字签名，只让能够识别数字签名的用户使用里面的东西。
     * ➢ 加快下载速度。在网上使用Applet时，如果存在多个文件而不打包，为了能够把每个文件都下载到客户端，需要为每个文件单独建立一个HTTP连接，这是非常耗时的工作。
     *    将这些文件压缩成一个JAR包，只要建立一次HTTP连接就能够一次下载所有的文件。
     * ➢ 压缩。使文件变小，JAR的压缩机制和ZIP完全相同。
     * ➢ 包封装。能够让JAR包里面的文件依赖于统一版本的类文件。
     * ➢ 可移植性。JAR包作为内嵌在Java平台内部处理的标准，能够在各种平台上直接使用。
     */
}
