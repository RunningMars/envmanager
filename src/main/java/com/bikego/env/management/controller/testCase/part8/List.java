package com.bikego.env.management.controller.testCase.part8;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class List {

    /**
     * List集合代表一个元素有序、可重复的集合，集合中每个元素都有其对应的顺序索引。
     * List集合允许使用重复元素，可以通过索引来 访问指定位置的集合元素。List集合默认按元素的添加顺序设置元素的索引，
     * 例如第一次添加的元素索引为0，第二次添加的元素索引为1……
     */


    /**
     * Arrays，该工具类里提供了asList（Object...a）方法，该方法可以把一个数组或指定个数的对象转换成一个List集合，
     * 这个List集合既不是ArrayList实现类的实例，也不是Vector实现类的实例，而是Arrays的内部类ArrayList的实例。
     * Arrays.ArrayList是一个固定长度的List集合，程序只能遍历访问该集合里的元素，不可增加、删除该集合里的元素。如下程序所示。
     */

    /**
     * Queue用于模拟队列这种数据结构，队列通常是指“先进先出”（FIFO）的容器。队列的头部保存在队列中存放时间最长的元素，
     * 队列的尾部保存在队列中存放时间最短的元素。
     */

    /**
     * PriorityQueue是一个比较标准的队列实现类。之所以说它是比较标准的队列实现，而不是绝对标准的队列实现，是因为PriorityQueue
     * 保存队列元素的顺序并不是按加入队列的顺序，而是按队列元素的大小进行重新排序。因此当调用peek()方法或者poll()方法取出队列中的元素时，
     * 并不是取出最先进入队列的元素，而是取出队列中最小的元素。
     */

    /**
     * Deque接口是Queue接口的子接口，它代表一个双端队列，Deque接口里定义了一些双端队列的方法，这些方法允许从两端来操作队列的元素。
     * rdg:php的数组同样可以用做双端队列array_push array_pop 等方法可以从数组两端灵活操作.
     */

    /**
     * 当程序中需要使用“栈”这种数据结构时，推荐使用ArrayDeque，尽量避免使用Stack——因为Stack是古老的集合，性能较差。
     * 当然ArrayDeque也可以当成队列使用，此处ArrayDeque将按“先进先出”的方式操作集合元素。
     */

    /**
     * LinkedList 与 ArrayList、 ArrayDeque 的实现机制完全不同，ArrayList、ArrayDeque内部以数组的形式来保存集合中的元素，
     * 因此随机访问集合元素时有较好的性能；而LinkedList内部以链表的形式来保存集合中的元素，因此随机访问集合元素时性能较差，
     * 但在插入、删除元素时性能比较出色（只需改变指针所指的地址即可）。
     */

    /**
     * 一般来说，由于数组以一块连续内存区来保存所有的数组元素，所以数组在随机访问时性能最好，所有的内部以数组作为底层实现的集合在随机访问时性能都比较好；
     * 而内部以链表作为底层实现的集合在执行插入、删除操作时有较好的性能。但总体来说，ArrayList的性能比LinkedList的性能要好，因此大部分时候都应该考虑使用
     * ArrayList。如果需要经常执行插入、删除操作来改变包含大量数据的List集合的大小，可考虑使用LinkedList集合。使用ArrayList、
     * Vector集合可能需要经常重新分配内部数组的大小，效果可能较差。
     */

    /**
     * Map里key集和Set集合里元素的存储形式也很像，Map子类和Set子类在名字上也惊人地相似，比如Set接口下有HashSet、LinkedHashSet、SortedSet（接口）、
     * TreeSet、EnumSet等子接口和实现类，而Map接口下则有HashMap、LinkedHashMap、SortedMap（接口）、TreeMap、EnumMap等子接口和实现类。
     * 正如它们的名字所暗示的，Map的这些实现类和子接口中key集的存储形式和对应Set集合中元素的存储形式完全相同
     */

    /**
     * 事实上，Map提供了一个Entry内部类来封装key-value对，而计算Entry存储时则只考虑Entry封装的key。从Java源码来看，Java是先实现了Map，
     * 然后通过包装一个所有value都为空对象的Map就实现了Set集合。
     */

    @Test
    public void t1()
    {
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("name",776);
        stringIntegerHashMap.put("age",23);
        stringIntegerHashMap.put("score",99);

        System.out.println(stringIntegerHashMap);

        for (var s : stringIntegerHashMap.keySet())
        {
            System.out.println(s);
        }

        Set<Map.Entry<String,Integer>> entries = stringIntegerHashMap.entrySet();
        for (var entry : entries)
        {
            System.out.println(entry);
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }


        System.out.println("**************8");
        stringIntegerHashMap.forEach( (s,v)-> System.out.println(s + v));
    }

    /**
     * Properties类是Hashtable类的子类，正如它的名字所暗示的，该对象在处理属性文件时特别方便
     * Properties类可以把Map对象和属性文件关联起来，从而可以把Map对象中的key-value对写入属性文件中，也可以把属性文件中的“属性名=属性值”加载到Map对象中。
     * 由于属性文件里的属性名、属性值只能是字符串类型，所以Properties里的key、value都是字符串类型。该类提供了三个方法来修改Properties里的key、value值。
     */

    @Test
    public void t3() throws IOException {

        Properties properties = new Properties();
        properties.setProperty("host","127.0.0.1");
        properties.setProperty("database","test");

        /**
         * 生成一个配置文件
         */
        properties.store(new FileOutputStream("iapps.properties"),"command line");
    }

    /**
     *
     * HashMap和Hashtable都是Map接口的典型实现类，它们之间的关系 完全类似于ArrayList和Vector的关系：Hashtable是一个古老的Map实 现类，它从JDK 1.0起就已经出现了，当它出现时，Java还没有提供
     * Map接口，所以它包含了两个烦琐的方法，即elements()（类似于Map
     * 接口定义的values()方法）和keys()（类似于Map接口定义的keySet()
     * 方法），现在很少使用这两个方法（关于这两个方法的用法请参考8.9
     * 节）。
     *
     * Collections工具类把HashMap变成线程安全的。
     * 为了成功地在HashMap、Hashtable中存储、获取对象，用作key的对象必须实现hashCode()方法和equals()方法。
     */

    @Test
    public void t2()
    {
        /**
         * 与HashSet类似的是，尽量不要使用可变对象作为HashMap、Hashtable的key，如果确实需要使用可变对象作为HashMap、
         * Hashtable的key，则尽量不要在程序中修改作为key的可变对象。
         */
        HashMap hm = new HashMap();
        hm.put(new A(60000),"java");
        hm.put(new A(87563),"php");

        var it = hm.keySet().iterator();
        var first = (A) it.next();
        first.count = 87563;
        System.out.println(hm);
        hm.remove(new A(87563));
        System.out.println("*******");
        System.out.println(hm);
        System.out.println(hm.get(new A(87563)));
        System.out.println(hm.get(new A(60000)));

//        EnumMap enumMap = new EnumMap();
    }

    /**
     * TreeMap就是一个红黑树数据结构，每个key-value对即作为红黑树的一个节点。TreeMap存储key-value对（节点）时，需要根据key对节点进行排序。
     * TreeMap可以保证所有的key-value对处于有序状态。TreeMap也有两种排序方式。
     *
     * 注意：再次强调：Set和Map的关系十分密切，Java源码就是先实现了HashMap、TreeMap等集合，然后通过包装一个所有的value都为空对象的Map集合实现了Set集合类。
     */


    /**
     * WeakHashMap与HashMap的用法基本相似。与HashMap的区别在于，HashMap的key保留了对实际对象的强引用，这意味着只要该HashMap对象不被销毁，
     * 该HashMap的所有key所引用的对象就不会被垃圾回收，HashMap也不会自动删除这些key所对应的key-value对；但WeakHashMap的key只保留了对实际对象的弱引用，
     * 这意味着如果WeakHashMap对象的key所引用的对象没有被其他强引用变量所引用，则这些key所引用的对象可能被垃圾回收，WeakHashMap也可能自动删
     * 除这些key所对应的key-value对。
     */

    /**
     * 这个Map实现类的实现机制与HashMap基本相似，但它在处理两个key相等时比较独特：在IdentityHashMap中，当且仅当两个key严格相等（key1==key2）时，
     * IdentityHashMap才认为两个key相等；对于普通的HashMap而言，只要key1和key2通过equals()方法比较返回true，且它们的hashCode值相等即可。
     *
     * 注意：
     * IdentityHashMap是一个特殊的Map实现！此类实现Map接口时，它有意违反Map的通常规范：IdentityHashMap要求两个key严格相等时才认为两个key相等。
     */

    /**
     * 各Map实现类的性能分析对于Map的常用实现类而言，虽然HashMap和Hashtable的实现机制几乎一样，但由于Hashtable是一个古老的、线程安全的集合，
     * 因此HashMap通常比Hashtable要快。
     * TreeMap通常比HashMap、Hashtable要慢（尤其在插入、删除keyvalue对时更慢），因为TreeMap底层采用红黑树来管理key-value对
     * （红黑树的每个节点就是一个key-value对）。
     * 使用TreeMap有一个好处：TreeMap中的key-value对总是处于有序状态，无须专门进行排序操作。当TreeMap被填充之后，就可以调用keySet()，
     * 取得由key组成的Set，然后使用toArray()方法生成key的数组，接下来使用Arrays的binarySearch()方法在已排序的数组中快速地查询对象。
     */

    @Test
    public void t4()
    {
        /**
         * ImmutableCollections 不可变集合
         */
        Set<String> java = Set.of("Java", "Php", "Go");
        System.out.println(java.getClass());
        ArrayList arrayList = new ArrayList();
        arrayList.add("sdf");
        arrayList.add(5323);
        arrayList.add(8);

        System.out.println(arrayList.get(1));

        arrayList.add("______________");

        String[] strings = {"a", "b", "a", "b", "c", "a", "b", "c", "b"};

        HashMap hashMap = new HashMap();
        for(var i = 0;i<strings.length;i++)
        {
            var key = strings[i];

            if (hashMap.containsKey(key))
            {
                var num = (Integer)hashMap.get(key);
                hashMap.put(key,num + 1);
            }else{
                hashMap.put(key,1);
            }
        }
        System.out.println(hashMap);

    }
}

class A{
    int count;
    public A(int count)
    {
        this.count = count;
    }
    public boolean equals(Object obj)
    {
        if (obj == this)
            return true;
        if (obj != null && obj.getClass() == A.class)
        {
            var a = (A)obj;
            return this.count == a.count;
        }
        return false;
    }
    public int hashCode()
    {
        return this.count;
    }
}
class B
{
    public boolean equals(Object obj)
    {
        return true;
    }
}
