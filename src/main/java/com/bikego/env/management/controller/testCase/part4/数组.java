package com.bikego.env.management.controller.testCase.part4;

import org.junit.Test;

import java.util.Arrays;

public class 数组 {


    /**
     * 理解数组：数组也是一种类型 (引用类型)
     * 1,数组元素具有相同的数据类型
     * 2,长度将不可改变
     *
     * Java的数组要求所有的数组元素具有相同的数据类型。因此，在一个数组中，数组元素的类型是唯一的，
     * 即一个数组里只能存储一种数据类型的数据，而不能存储多种数据类型的数据
     *
     * 注意： 因为Java语言是面向对象的语言，而类与类之间可以支持继承 关系，这样可能产生一个数组里可以存放多种数据类型的假象。
     * 例 如有一个水果数组，要求每个数组元素都是水果，实际上数组元素 既可以是苹果，
     * 也可以是香蕉（苹果、香蕉都继承了水果，都是一 种特殊的水果），
     * 但这个数组的数组元素的类型还是唯一的，只能是水果类型。
     */

    /**
     * 定义数组
     * 推荐声明方式  type[]
     * 例如:int[] i = new int[]{1,2,3},String[]
     *
     * 可能有些读者非常喜欢type arrayName[];这种定义数组的方式，这可能是因为早期某些计算机读物的误导，从现在开始就不要再使用这种糟糕的方式了。
     * Java的模仿者C#就不再支持type arrayName[]这种语法，它只 支持第一种定义数组的语法。越来越多的语言不再支持type
     * arrayName[]这种数组定义语法。
     */
    @Test
    public void t1()
    {
        int[] i = new int[]{1,2,3};
        System.out.println(i);
    }

    /**
     * 学生提问：能不能只分配内存空间，不赋初始值呢？
     * 答：不行！一旦为数组的每个数组元素分配了内存空间，每个内存空 间里存储的内容就是该数组元素的值，
     * 即使这个内存空间存储的内容是空，这个空也是一个值（null）。不管以哪种方式来初始化数组，
     * 只要为数组元素分配了内存空间，数组元素就具有了初始值。初始值
     * 的获得有两种形式：一种由系统自动分配；另一种由程序员指定。
     */


    /**
     * 数组的初始化有如下两种方式
     * 1,静态初始化 : 初始化时由程序员显式指定每个数组元素的初始值，由系统决定数组长度。
     * 2,动态初始化 : 初始化时程序员只指定数组长度，由系统为数组元素分配初始值。
     */
    @Test
    public void t2()
    {
        /**
         * 1,静态初始化 : 初始化时由程序员显式指定每个数组元素的初始值，由系统决定数组长度。
         */
        int[] i = new int[]{1,2,3};
        System.out.println(i);

        /**
         * 2,动态初始化 : 初始化时程序员只指定数组长度，由系统为数组元素分配初始值。
         */
        int[] a = new int[3];
        System.out.println(a);

        /**
         * 定义数组时所指定的type的子类
         */
        Object objArr;
        objArr = new String[]{"java","php"};

        Object objArr2;
        objArr2 = new Object[]{"java","php"};

        /**
         * 简写方式
         */
        Object[] arr = {"java","php"};
    }

    /**
     * 动态初始化的初始值
     * 执行动态初始化时，程序员只需指定数组的长度，即为每个数组 元素指定所需的内存空间，系统将负责为这些数组元素分配初始值。
     * 指定初始值时，系统按如下规则分配初始值。
     * - 数组元素的类型是基本类型中的整数类型（byte、short、int和long），则数组元素的值是0。
     * - 数组元素的类型是基本类型中的浮点类型（ float 、double），则数组元素的值是0.0。
     * - 数组元素的类型是基本类型中的字符类型（char），则数组元素的值是'\u0000'。
     * - 数组元素的类型是基本类型中的布尔类型（boolean），则数组元素的值是false。
     * - 数组元素的类型是引用类型（类、接口和数组），则数组元素的值是null。
     */


    /**
     * 使用数组
     *
     *
     * 如果访问数组元素时指定的索引值小于0，或者大于等于数组的长度 ，编译程序不会出现任何错误，但运行时出现异常：
     * java.lang.ArrayIndexOutOfBoundsException：N（数组索引越界异常），异常信息后的N就是程序员试图访问的数组索引。
     *
     */
    @Test
    public  void t5()
    {
//        Object[] arr = {1,3,4,5,7};
        Object[] arr = new Object[5];

        arr[1] = "Java";
        arr[2] = "php";
        for(var i = 0;i < arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }

    /**
     * 当使用foreach循环来迭代输出数组元素或集合元素时，通常不要对循环变量进行赋值,无法改变数组中的值,而且极容易引起错误
     *
     * 当使用foreach来迭代访问数组元素时，foreach中的循环变量相当于一个临时变量，
     * 系统会把数组元素依次赋给这个临时变量，而这个临时变量并不是数组元素，它只是保存了数组元素的值。
     * 因此，如果希望改变数组元素的值，则不能使用这种foreach循环。
     */
    @Test
    public void t6()
    {
        Object[] arr = new Object[5];
        arr[1] = "Java";
        arr[2] = "php";
        for(var item : arr)
        {
            item = "go";
            System.out.println(item);
        }
        System.out.println(arr[0]);
    }

    /**
     * 深入数组
     *
     * 数组是一种引用数据类型，数组引用变量只是一个引用，数组元 素和数组变量在内存里是分开存放的。
     *
     *
     */


    /**
     * 为什么有栈内存和堆内存之分？
     * 答：当一个方法执行时，每个方法都会建立自己的内存栈，在这个方 法内定义的变量将会逐个放入这块栈内存里，随着方法的执行结束，
     * 这个方法的内存栈也将自然销毁。因此，所有在方法中定义的局部变 量都是放在栈内存中的；在程序中创建一个对象时，
     * 这个对象将被保存到运行时数据区中，以便反复利用（因为对象的创建成本通常较大），这个运行时数据区就是堆内存。
     * 堆内存中的对象不会随方法的结束而销毁，即使方法结束后，这个对象还可能被另一个引用变量所引用（在方法的参数传递时很常见），
     * 则这个对象依然不会被销毁。只有当一个对象没有任何引用变量引用它时，系统的垃圾回收器才会在合适的时候回收它。
     *
     * 每个方法有自己的栈内存,存放当前方法的变量,并指向堆内存中的数据
     */

    @Test
    public void t7()
    {
        /**
         * 运行上面代码后，将可以看到先输出b数组的长度为4，然后依次 输出a数组和b数组的每个数组元素，接着会输出b数组的长度为3。
         * 看起来似乎数组的长度是可变的，但这只是一个假象。
         * 必须牢记：定义 并初始化一个数组后，在内存中分配了两个空间，一个用于存放数组 的引用变量，另一个用于存放数组本身。
         */
        int[] a = {5,6,7};
        var b = new int[4];
        System.out.println("b长度:" + b.length);

        for (int i = 0 , len = a.length;i < len ;i++)
        {
            System.out.println(a[i]);
        }
        for (int i = 0 , len = b.length;i < len ;i++)
        {
            System.out.println(b[i]);
        }
        b = a;
        System.out.println("b长度:" + b.length);

        a[0] = 11111;


        for (int i = 0 , len = a.length;i < len ;i++)
        {
            System.out.println(a[i]);
        }
        for (int i = 0 , len = b.length;i < len ;i++)
        {
            System.out.println(b[i]);
        }
    }

    @Test
    public void t8()
    {
        int[] a = {5,6,7};
        var b = new int[]{5,6,7};

        System.out.println("b长度:" + b.length);

        for (int i = 0 , len = a.length;i < len ;i++)
        {
            System.out.println(a[i]);
        }
        for (int i = 0 , len = b.length;i < len ;i++)
        {
            System.out.println(b[i]);
        }
        a[0] = 11111;

        for (int i = 0 , len = a.length;i < len ;i++)
        {
            System.out.println(a[i]);
        }
        for (int i = 0 , len = b.length;i < len ;i++)
        {
            System.out.println(b[i]);
        }
    }

    /**
     * 二维数组
     *
     * (无限维度数组) Object[]
     * 学生提问：我是否可以让图4.13中灰色覆盖的数组元素再次指向另一 个数组？这样不就可以扩展成三维数组，甚至扩展成更多维的数组吗？
     * 答：不能！至少在这个程序中不能。因为Java是强类型语言，当定义 a数组时，已经确定了a数组的数组元素是int[]类型，则a[0]数组的
     * 数组元素只能是int类型，所以灰色覆盖的数组元素只能存储int类型 的变量。对于其他弱类型语言，例如JavaScript和Ruby等，确实可以
     * 把一维数组无限扩展，扩展成二维数组、三维数组……如果想在Java语言中实现这种可无限扩展的数组，则可以定义一个Object[]类型的 数组，
     * 这个数组的元素是Object类型，因此可以再次指向一个Object[]类型的数组，这样就可以从一维数组扩展到二维数组、三维数组……
     */
    @Test
    public void t9(){
        int[][] a = new int[4][];
//
//        for (var item:a)
//        {
//            System.out.println(item);
//        }

        a[0] = new int[2];

        a[0][1] = 6;

        for (var i:a)
        {
            System.out.println(i);
            if(i != null)
            {
                for(var s:i)
                {
                    System.out.println(s);
                }
            }

        }

    }

    @Test
    public void t10()
    {
        String[][] arr = new String[][]{
                new String[]{"abc","def"},new String[]{"345","778"},new String[]{"345","778"},
        };

        String[][] arr2 = {new String[]{"AB"},new String[]{"CD","XY"}};

        for(var i :arr )
        {
            System.out.println(i.toString());
        }
        System.out.println(Arrays.toString(arr));
    }


    /**
     * Arrays.util
     * 数组常用工具方法
     */
    @Test
    public void t11()
    {
        var a = new int[]{3,4,5,6};
        var a2 = new int[]{3,4,5,6};
        System.out.println("是否相等:" + Arrays.equals(a,a2));

        var b = Arrays.copyOf(a,6);
        System.out.println("是否相等:" + Arrays.equals(a,b));

        System.out.println(Arrays.toString(b));

        Arrays.fill(b,2,4,1);
        System.out.println(Arrays.toString(b));

        Arrays.sort(b);
        System.out.println(Arrays.toString(b));
    }

    /**
     * 由于计算机硬件的飞速发展，目前几乎所有家用PC都是4核、8 核的CPU，而服务器的CPU则具有更好的性能，
     * 因此Java 8与时俱进 地增加了并发支持，并发支持可以充分利用硬件设备来提高程序的运行性能。
     * Java 8增强了Arrays类的功能，为Arrays类增加了一些工具方 法，这些工具方法可以充分利用多CPU并行的能力来提高设值、排序的
     * 性能。下面是Java 8为Arrays类增加的工具方法。
     *
     * void parallelPrefix(xxx[] array, XxxBinary Operatorop)：该方法使用op参数指定的计算公式计算得到的结果作为新 的数组元素。op计算公式包括left、right两个形参，其中left
     * 代表新数组中前一个索引处的元素，right代表array数组中当 前索引处的元素。新数组的第一个元素无须计算，直接等于array数组的第一个元素。
     * void parallelPrefix(xxx[] array, int fromIndex, int toIndex, XxxBinaryOperator op)：该方法与上一个方法相 似，区别是该方法仅重新计算fromIndex到toIndex索引的元素。
     * void setAll(xxx[] array, IntToXxxFunction generator)： 该方法使用指定的生成器（generator）为所有数组元素设置值，该生成器控制数组元素的值的生成算法。
     * void parallelSetAll(xxx[] array, IntToXxx Function generator)：该方法的功能与上一个方法相同，只是该方法增加了并行能力，可以利用多CPU并行来提高性能。
     * void parallelSort(xxx[] a)：该方法的功能与Arrays类以前 就有的sort()方法相似，只是该方法增加了并行能力，可以利用多CPU并行来提高性能。
     * void parallelSort(xxx[] a, int fromIndex, int toIndex)：该方法与上一个方法相似，区别是该方法仅对fromIndex到toIndex索引的元素进行排序。
     * Spliterator.OfXxx spliterator(xxx[] array)：将该数组的所有元素转换成对应的Spliterator对象。
     * Spliterator.OfXxx spliterator(xxx[] array, int startInclusive, int endExclusive)：该方法与上一个方法相 似，区别是该方法仅转换startInclusive到endExclusive索引的元素。
     * XxxStream stream(xxx[] array) ： 该 方 法 将 数 组 转 换 为Stream，Stream是Java 8新增的流式编程的API。
     * XxxStream stream(xxx[] array, int startInclusive, int endExclusive)：该方法与上一个方法相似，区别是该方法仅将fromIndex到toIndex索引的元素转换为Stream。
     * 上面方法列表中，所有以parallel开头的方法都表示该方法可利 用CPU并行的能力来提高性能。上面方法中的xxx代表不同的数据类 型，比如处理int[]型数组时应将xxx换成int，处理long[]型数组时应将xxx换成long。
     */
}
