package com.bikego.env.management.controller.testCase.part16;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MultiThread extends Thread{

    /**
     * 进程
     * 进程是处于运行过程中的程序，并且具有一定的独立功能，进程是系统进行资源分配和调度的一个独立单位。
     *
     * 一般而言，进程包含如下三个特征。
     * ➢ 独立性：进程是系统中独立存在的实体，它可以拥有自己独立的资源，每一个进程都拥有自己私有的地址空间。在没有经过进程本身允许的情况下，
     * 一个用户进程不可以直接访问其他进程的地址空间。
     * ➢ 动态性：进程与程序的区别在于，程序只是一个静态的指令集合，而进程是一个正在系统中活动的指令集合。在进程中加入了时间的概念。
     * 进程具有自己的生命周期和各种不同的状态，这些概念在程序中都是不具备的。
     * ➢ 并发性：多个进程可以在单个处理器上并发执行，多个进程之间不会互相影响。
     */

    /**
     * 多线程听上去是非常专业的概念，其实非常简单——单线程的程序（前面介绍的绝大部分程序）只有一个顺序执行流，多线程的程序则可以包括多个顺序执行流，
     * 多个顺序流之间互不干扰。可以这样理解：单线程的程序如同只雇佣一个服务员的餐厅，他必须做完一件事情后才可以做下一件事情；
     * 多线程的程序则如同雇佣多个服务员的餐厅，他们可以同时做多件事情。
     *
     * 线程概述
     * 几乎所有的操作系统都支持同时运行多个任务，一个任务通常就是一个程序，每个运行中的程序就是一个进程。当一个程序运行时，
     * 内部可能包含了多个顺序执行流，每个顺序执行流就是一个线程。
     */

    /**
     * 对于一个CPU而言，它在某个时间点只能执行一个程序，也就是说，只能运行一个进程，CPU不断地在这些进程之间轮换执行。那为什么用户感觉不到任何中断现象呢？
     * 这是因为CPU的执行速度相对人的感觉来说实在是太快了（如果启动的程序足够多，用户依然可以感觉到程序的运行速度下降），所以虽然CPU在多个进程之间
     * 轮换执行，但用户感觉到好像有多个进程在同时执行。
     */

    /**
     * 多线程则扩展了多进程的概念，使得同一个进程可以同时并发处理多个任务。线程（Thread）也被称作轻量级进程（Lightweight Process），线程是进程的执行单元。
     * 就像进程在操作系统中的地位一样，线程在程序中是独立的、并发的执行流。当进程被初始化后，主线程就被创建了。对于绝大多数的应用程序来说，通常仅要求有一个主线程，
     * 但也可以在该进程内创建多条顺序执行流，这些顺序执行流就是线程，每个线程也是互相独立的。
     *
     * 线程是进程的组成部分，一个进程可以拥有多个线程，一个线程必须有一个父进程。线程可以拥有自己的堆栈、自己的程序计数器和自己的局部变量，但不拥有系统资源，
     * 它与父进程的其他线程共享该进程所拥有的全部资源。因为多个线程共享父进程里的全部资源，因此编程更加方便；但必须更加小心，因为需要确保线程不会妨碍同一
     * 进程里的其他线程。
     */

    /**
     * 线程是独立运行的，它并不知道进程中是否还有其他线程存在。线程的执行是抢占式的，也就是说，当前运行的线程在任何时候都可能被挂起，以便另外一个线程可以运行。
     * 一个线程可以创建和撤销另一个线程，同一个进程中的多个线程之间可以并发执行。从逻辑角度来看，多线程存在于一个应用程序中，让一个应用程序中可以有多个执行部分同时执行，
     * 但操作系统无须将多个线程看作多个独立的应用，对多线程实现调度和管理以及资源分配。线程的调度和管理由进程本身负责完成。简而言之，一个程序运行后至少有一个进程，
     * 一个进程里可以包含多个线程，但至少要包含一个线程。
     *
     * 提示：
     * 归纳起来可以这样说：操作系统可以同时执行多个任务，每个任务就是进程；进程可以同时执行多个任务，每个任务就是线程。
     */

    /**
     * 总结起来，使用多线程编程具有如下几个优点。
     * ➢ 进程之间不能共享内存，但线程之间共享内存非常容易。
     * ➢ 系统创建进程时需要为该进程重新分配系统资源，但创建线程 则代价小得多，因此使用多线程来实现多任务并发比多进程的效率高。
     * ➢ Java语言内置了多线程功能支持，而不是单纯地作为底层操作系统的调度方式，从而简化了Java的多线程编程。在实际应用中，多线程是非常有用的，
     * 一个浏览器必须能同时下载多个图片；一个Web服务器必须能同时响应多个用户请求；Java虚拟 机本身就在后台提供了一个超级线程来进行垃圾回收；
     * 图形用户界面（GUI）应用也需要启动单独的线程从主机环境收集用户界面事件…… 总之，多线程在实际编程中的应用是非常广泛的。
     */


    /**
     * 继承Thread类创建线程类
     * 通过继承Thread类来创建并启动多线程的步骤如下。
     * ① 定义Thread类的子类，并重写该类的run()方法，该run()方法的方法体就代表了线程需要完成的任务。因此把run()方法称为线程执行体。
     * ② 创建Thread子类的实例，即创建了线程对象。
     * ③ 调用线程对象的start()方法来启动该线程。
     */

    private int i;

    @Test
    public void t0()
    {
        for (var i = 0; i<100 ; i++)
        {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20)
            {
                /**
                 * 创建线程的方式一: 通过继承
                 */
                new MultiThread().start();

                new MultiThread().start();
            }
        }
    }


    public void run()
    {
        for( ; i<100;i++)
        {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }


    @Test
    public void t2()
    {
        /**
         * 创建线程的方式二:
         */
        Thread myThread = new Thread(new MyThread(), "myThreadName 001");
        Thread myThread2 = new Thread(new MyThread(), "myThreadName 002");
        myThread.start();
        myThread2.start();
    }


    @Test
    public void t3() throws InterruptedException {
        System.out.println("start");
        /**
         * 创建线程的方式三(lambda):
         */
        Thread myThread = new Thread(()->{
            for( var i=0; i<100;i++)
            {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }, "myThreadName001");

        Thread myThread2 = new Thread(()->{
            for(  var i=0; i<100;i++)
            {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }, "myThreadName 002");

        myThread.start();
        myThread2.start();
//        Thread.currentThread().sleep(Long.parseLong("13"));
        System.out.println("end");
    }


    /**
     * 主线程与子线程交替执行
     */
    @Test
    public void t4() throws InterruptedException {
        ThirdThread thirdThread = new ThirdThread();

        FutureTask<Integer> futureTask = new FutureTask<>((Callable<Integer>) ()->{
            var i = 0;
            for (;i<100;i++)
            {
                System.out.println(Thread.currentThread().getName() + " 的循环变量i的值:" + i);
            }
            return i;
        });

        for (var i= 0;i< 100; i++)
        {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值: " + i);
            if (i ==20)
            {
                new Thread(futureTask,"有返回值的线程").start();

                //主线程睡眠4秒
//                Thread.sleep(4000);
            }
        }

        try {
            System.out.println("子线程返回值 " +futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 采用实现Runnable、Callable接口的方式创建多线程的优缺点：
     * ➢ 线程类只是实现了Runnable接口或Callable接口，还可以继承其他类。
     * ➢ 在这种方式下，多个线程可以共享同一个target对象，所以非 常适合多个相同线程来处理同一份资源的情况，从而可以将CPU、代码和数据分开，形成清晰的模型，较好地体现了面向对象的思想。
     * ➢ 劣势是，编程稍稍复杂，如果需要访问当前线程，则必须使用Thread.currentThread()方法。采用继承Thread类的方式创建多线程的优缺点：
     * ➢ 劣势是，因为线程类已经继承了Thread类，所以不能再继承其他父类。
     * ➢ 优势是，编写简单，如果需要访问当前线程，则无须使用Thread.currentThread()方法，直接使用this即可获得当前线程。
     * 鉴于上面分析，因此一般推荐采用实现Runnable接口、Callable接口的方式来创建多线程。
     */
}


class MyThread implements Runnable{

    @Override
    public void run()
    {
        for( var i = 0; i<100; i++)
        {
            System.out.println( " MyThread - " + i);
        }
    }
}

class ThirdThread{

}