package com.bikego.env.management.controller.testCase.part10;

import org.junit.Test;

import java.io.*;

public class Exceptions {

    /**
     * throws关键字主要在方法签名中使用，用于声明该方法可能抛出的异常
     */

    /**
     * Error错误，一般是指与虚拟机相关的问题，如系统崩溃、虚拟机错误、动态链接失败等，这种错误无法恢复或不可能捕获，将导致应用程序中断。
     * 通常应用程序无法处理这些错误，因此应用程序不应该试图使用catch块来捕获Error对象。在定义该方法时，也无须在其throws子句中声明该方法可能抛出Error及其任何子类。
     */

   @Test
    public void t0()
   {
       /**
        * 捕获多个异常
        */
       FileInputStream fileInputStream = null;
       try{
           fileInputStream = new FileInputStream("a.txt");
       }catch(IndexOutOfBoundsException | NumberFormatException | ArithmeticException e){
           // 捕获多异常时,异常变量默认有final修饰符 , 以下代码会报错
           //e = new ArithmeticException("test");
       }catch(Exception e){
           // 捕获一种异常时,异常变量没有final修饰符 , 以下代码不会报错
           e = new ArithmeticException("test");

           /**
            * 即使执行了return , 后面的finally还是得到了执行
            */
           return;

           /**
            * 如果在异常处理代码中 使用System.exit(1)语句来退出虚拟机，则finally块将失去执行的机会。
            */
           //System.exit(1);

       }finally{
           if (fileInputStream != null)
           {
               try{
                   fileInputStream.close();
               }catch(IOException ioe)
               {
                   ioe.printStackTrace();
               }
           }
       }
   }

    /**
     * 使用finally回收资源
     *
     * 提示：Java的垃圾回收机制不会回收任何物理资源，垃圾回收机制只能回收堆内存中对象所占用的内存。
     */

    /**
     * 在通常情况下，不要在finally块中使用如return或throw等导致方法终止的语句，（throw语句将在后面介绍），一旦在finally块中使用了return或throw语句，
     * 将会导致try块、catch块中的return、throw语句失效。
     *
     * 当Java程序执行try块、catch块时遇到了return或throw语句，这两个语句都会导致该方法立即结束，但是系统执行这两个语句并不会结束该方法，
     * 而是去寻找该异常处理流程中是否包含finally块，如果没有finally块，程序立即执行return或throw语句，方法终止；如果有finally块，
     * 系统立即开始执行finally块——只有当finally块执行完成后，系统才会再次跳回来执行try块、catch块里的return或throw语句；
     * 如果finally块里也使用了return或throw等导致方法终止的语句，finally块已经终止了方法，系统将不会跳回去执行try块、catch块里的任何代码。
     */


    /**
     * 提示：
     * Java 7几乎把所有的“资源类”（包括文件IO的各种类、JDBC
     * 编程的Connection、Statement等接口）进行了改写，改写后资源类
     * 都实现了AutoCloseable或Closeable接口。
     */

    @Test
    public void t2() throws IOException {
        /**
         * 代码分别声明、初始化了两个IO流，由于BufferedReader、PrintStream都实现了Closeable接口，而且它们放 在try语句中声明、初始化，
         * 所以try语句会自动关闭它们。因此程序是安全的。自动关闭资源的try语句相当于包含了隐式的finally块（这个finally块用于关闭资源），
         * 因此这个try语句可以既没有catch块，也没有finally块。
         */
        var br = new BufferedReader(new FileReader("AutoCloseTest.java"));
        var ps = new PrintStream(new FileOutputStream("a.txt"));
        try(br;ps){
            System.out.println(br.readLine());
            ps.println("是非得失");
        }
    }


    /**
     * Java的异常被分为两大类：Checked异常和Runtime异常（运行时异常）。所有的RuntimeException类及其子类的实例被称为Runtime异常；
     * 不是RuntimeException类及其子类的异常实例则被称为Checked异常。
     *
     * 在大部分时候推荐使用Runtime异常，而不使用Checked异常。尤其当程序需要自行抛出异常时（如何自行抛出异常请看下一节），使
     * 用Runtime异常将更加简洁。
     */

    /**
     * throws声明抛出只能在方法签名中使用，throws可以声明抛出多个异常类，多个异常类之间以逗号隔开。throws声明抛出的语法格式如下：
     * throws IOException, IndexOutOfBoundsException上面throws声明抛出的语法格式仅跟在方法签名之后，
     * 如下例子程序使用了throws来声明抛出IOException异常，一旦使用throws语句声明抛出该异常，程序就无须使用try...catch块来捕获该异常了。
     *
     * 声明抛出的异常类型的子类或相同，子类方法声明抛出的异常不允许比父类方法声明抛出的异常多
     */


    /**
     * 异常处理机制的初衷是将不可预期异常的处理代码和正常的业务逻辑处理代码分离，因此绝不要使用异常处理来代替正常的业务逻辑判断。
     * 异常机制的效率比正常的流程控制效率差，所以不要使用异常处理来代替正常的程序流程控制
     *
     * 注意： 异常只应该用于处理非正常的情况，不要使用异常处理来代替正常的流程控制。对于一些完全可预知，而且处理方式清楚的错误，
     * 程序应该提供相应的错误处理代码，而不是将其笼统地称为异常。
     *
     * 而且当try块过于庞大时，就难免在try块后紧跟大量的catch块才可以针对不同的异常提供不同的处理逻辑。同一个try块后紧跟大量的
     * catch块则需要分析它们之间的逻辑关系，反而增加了编程复杂度。
     */
}
