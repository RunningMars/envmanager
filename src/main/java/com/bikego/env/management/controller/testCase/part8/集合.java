package com.bikego.env.management.controller.testCase.part8;

import com.alibaba.druid.support.json.JSONUtils;
import org.hibernate.mapping.Map;
import org.junit.Test;

import java.awt.*;
import java.util.*;

public class 集合 {
    /**
     *
     * Java集合就像一种容器，可以把多个对象（实际上是对象的引用，但习惯上都称对象）“丢进”该容器中。
     *
     * Java集合大致可分为Set、List、Queue和Map四种体系，
     * Set 代表无序、不可重复的集合；
     * List 代表有序、可重复的集合；
     * Map 代表具有映射关系的集合，
     * Queue 体系集合，代表一种队列集合实现(Java 5又增加)。
     */


    /**
     * 集合类和数组不一样，数组元素既可以是基本类型的值，也可以是对象（实际上保存的是对象的引用变量）；
     * 而集合里只能保存对象（实际上只是保存对象的引用变量，但通常习惯上认为集合里保存的是对象）。
     *
     */

    /**
     * Java的集合类主要由两个接口派生而出：Collection和Map，
     * Collection和Map是Java集合框架的根接口，这两个接口又包含了一些子接口或实现类。
     *
     * Collection
     *      --- List  ( --ArrayList --LinkedList --Vector )
     *      --- Set ( --HashSet(-LinkedHashSet) --SortedSet --EnumSet )
     *      --- Queue ( --Deque --PriorityQueue )
     *
     * Map (Map保存的每项数据都是key-value对，也就是由key和value两个值组成。Map里的key是不可重复的，key用于标识集合里的每项数据)
     *      --- HashMap ( --LinkedHashMap)
     *      --- Hashtable ( --Properties)
     *      --- SortedMap ( --TreeMap)
     *      --- EnumMap
     *      --- WeakHashMap
     */


    @Test
    public void t1()
    {
        HashSet hashSet = new HashSet();
        hashSet.add("sdf");
        hashSet.add("sdfsdf1");
        hashSet.add("sdfsdf2");
        hashSet.add("sdfsdf3");

        hashSet.forEach(obj -> System.out.println("obj = " + obj));


        /**
         * Iterator迭代器采用的是快速失败（fail-fast）机制，一旦在迭代过程中检测到该集合已经被修改（通常是程序中的其他线程修
         * 改），程序立即引发ConcurrentModificationException异常，而不是显示修改后的结果，这样可以避免共享资源而引发的潜在问题。
         */
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            var book = (String)next;
            System.out.println(book);
        }

        /**
         * foreach
         * 与使用Iterator接口迭代访问集合元素类似的是，foreach循环中的迭代变量也不是集合元素本身，
         * 系统只是依次把集合元素的值赋给迭代变量，因此在foreach循环中修改迭代变量的值也没有任何实际意义。
         *
         * 当使用foreach循环迭代访问集合元素时，该集合也不能被改变，否则将引发Concurrent ModificationException异常。
         */
        for (Object o : hashSet) {
            System.out.println(o);
            String str = (String)o;
            System.out.println(str);
            //error java.util.ConcurrentModificationException
            //hashSet.remove(str);
        }

        /**
         * Java 8 为Collection集合新增了一个removeIf(Predicate filter)方法，该方法将会批量删除符合filter条件的所有元素。
         * 该方法需要一个Predicate（谓词）对象作为参数，Predicate也是函数式接口，因此可使用Lambda表达式作为参数。
         */
        System.out.println("*************");
//        hashSet.removeIf( o -> ((String)o).length() > 3);
        System.out.println(hashSet);

        /**
         * Stream 流式API
         * Java 8还新增了Stream、IntStream、LongStream、DoubleStream等流式API，这些API代表多个支持串行和并行聚集操作的元素。
         * 上面4个接口中，Stream是一个通用的流接口，而IntStream、LongStream、DoubleStream则代表元素类型为int、long、double的流。
         */

        /**
         * Stream提供了大量的方法进行聚集操作，这些方法既可以是“中间的”（intermediate），也可以是“末端的”（terminal）。
         * ➢ 中间方法：中间操作允许流保持打开状态，并允许直接调用后续方法。上面程序中的map()方法就是中间方法。中间方法的返回值是另外一个流。
         * ➢ 末端方法：末端方法是对流的最终操作。当对某个Stream执行末端方法后，该流将会被“消耗”且不再可用。上面程序中的
         * sum()、count()、average()等方法都是末端方法。
         */

        /**
         * Collection接口提供了一个stream()默认方法，该方法可返回该集合对应的流，接下来即可通过流式API来操作集合元素。
         * 由于Stream可以对集合元素进行整体的聚集操作，因此Stream极大地丰富了集合的功能。
         */
        System.out.println("*************");
        long count = hashSet.stream().filter(o -> ((String) o).length() > 4).count();
        System.out.println("count=" + count);

        hashSet.stream().mapToInt(ele -> ((String)ele).length())
                .forEach(System.out::println);
    }


    /**
     * HashSet具有以下特点。
     * ➢ 不能保证元素的排列顺序，顺序可能与添加顺序不同，顺序也有可能发生变化。
     * ➢ HashSet不是同步的，如果多个线程同时访问一个HashSet，假设有两个或者两个以上线程同时修改了HashSet集合时，则必须通过代码来保证其同步。
     * ➢ 集合元素值可以是null。
     */


    /**
     * 学生提问：hashCode()方法对于HashSet是不是十分重要？
     * 答：hash（也被翻译为哈希、散列）算法的功能是，它能保证快速查找被检索的对象，hash算法的价值在于速度。
     * 当需要查询集合中某个元素时，hash算法可以直接根据该元素的hashCode值计算出该元素的存储位置，从而快速定位该元素。
     * 为了理解这个概念，可以先看数组（数组是所有能存储一组元素里最快的数据结构）。数组可以包含多个元素，每个元素都有索引，
     * 如果需要访问某个数组元素，只需提供 该元素的索引，接下来即可根据该索引计算该元素在内存里的存储位置。
     *
     * 表面上看起来，HashSet集合里的元素都没有索引，实际上当程序向HashSet集合中添加元素时，HashSet会根据该元素的hashCode值来计
     * 算它的存储位置，这样也可快速定位该元素。为什么不直接使用数组、还需要使用HashSet呢？因为数组元素的索引是连续的，而且数组的长度是固定的，
     * 无法自由增加数组的长度。而HashSet就不一样了，HashSet采用每个元素的hashCode值来计算其存储位置，从而可以自由增加HashSet的长度，
     * 并可以根据元素的hashCode值来访问元素。因此，当从HashSet中访问元素时，HashSet先计算该元素的hashCode值
     * （也就是调用该对象的hashCode()方法的 返回值），然后直接到该hashCode值对应的位置去取出该元素——这就是HashSet速度很快的原因。
     */

    /**
     * HashSet还有一个子类LinkedHashSet, LinkedHashSet使用了链表记录集合元素的添加顺序，
     * 但LinkedHashSet依然是HashSet，因此它依然不允许集合元素重复。
     */

    /**
     * TreeSet是SortedSet接口的实现类，正如SortedSet名字所暗示的，TreeSet可以确保集合元素处于排序状态。
     * 向TreeSet集合中添加Err对象，在自然排序时，集合元素必须实现Comparable接口，否则将会引发运行时异常：
     * ClassCastException——因此，TreeSet要求自然排序的集合元素必须都实现该接口。
     *
     * 大部分类在实现compareTo(Object obj)方法时，都需要将被比较对象obj强制类型转换成相同类型，因为只有相同类的两个实例才会比较大小。
     * 当试图把一个对象添加到TreeSet集合时，TreeSet会调用该对象的compareTo(Object obj)方法与集合中的其他元素进行比较——这就要求
     * 集合中的其他元素与该元素是同一个类的实例。也就是说，向TreeSet中添加的应该是同一个类的对象，否则也会引发ClassCastException异常。
     *
     */

    /**
     * EnumSet是一个专为枚举类设计的集合类，EnumSet中的所有元素都必须是指定枚举类型的枚举值，该枚举类型在创建EnumSet时显式或隐式地指定。
     * EnumSet的集合元素也是有序的，EnumSet以枚举值在Enum类内的定义顺序来决定集合元素的顺序。
     */

    /**
     * HashSet和TreeSet是Set的两个典型实现，到底如何选择HashSet和TreeSet呢？HashSet的性能总是比TreeSet好（特别是最常用的添加、查询元素等操作），
     * 因为TreeSet需要额外的红黑树算法来维护集合元素的次序。只有当需要一个保持排序的Set时，才应该使用TreeSet，否则都应该使用HashSet。
     * HashSet还有一个子类：LinkedHashSet，对于普通的插入、删除操作，LinkedHashSet比HashSet要略微慢一点，这是由维护链表所带
     * 来的额外开销造成的，但由于有了链表，遍历LinkedHashSet会更快。EnumSet是所有Set实现类中性能最好的，但它只能保存同一个枚
     * 举类的枚举值作为集合元素。必须指出的是，Set的三个实现类HashSet、TreeSet和EnumSet都 是线程不安全的。如果有多个线程同时访问一个Set集合，
     * 并且有超过一个线程修改了该Set集合，则必须手动保证该Set集合的同步性。通常可以通过Collections工具类的synchronizedSortedSet方法来“包装”该Set集合。
     * 此操作最好在创建时进行，以防止对Set集合的意外非同步访问。例如：
     */
    @Test
    public void t2()
    {
        SortedSet<String> strings = Collections.synchronizedSortedSet(new TreeSet<String>());
    }
}

