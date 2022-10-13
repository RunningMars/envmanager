package com.bikego.env.management.controller.testCase.part5;

import org.junit.Test;

import java.util.Arrays;

public class 多态 {

    @Test
    public void t1()
    {

        Object s = 23;
        System.out.println(s);
        String[] arr = new String[]{"234","wer"};
        System.out.println(Arrays.toString(arr));
        SubClass.main(arr);

    }

    /**
     * 对象的多态性：父类的引用指向子类的对象
     */

    /**
     * 引用变量的强制类型转换
     * 类型转换运算符是小括号，类型转换运算符的用法是：
     * (type)variable，这种用法可以将variable变量转换成一个type类型的变量。前面在介绍基本类型的强制类型转换时，
     * 已经看到了使用这种类型转换运算符的用法，类型转换运算符可以将一个基本类型变量转换成另一个类型。
     * 除此之外，这个类型转换运算符还可以将一个引用类型变量转换成其子类类型。这种强制类型转换不是万能的，当进行强制类型转换
     * 时需要注意：
     * ➢ 基本类型之间的转换只能在数值类型之间进行，这里所说的数值类型包括整数型、字符型和浮点型。但数值类型和布尔类型之间不能进行类型转换。
     * ➢ 引用类型之间的转换只能在具有继承关系的两个类型之间进行，如果是两个没有任何继承关系的类型，则无法进行类型转换，否则编译时就会出现错误。
     * 如果试图把一个父类实例转换成子类类型，则这个对象必须实际上是子类实例才行（即编译时类型为父类类型，而运行时类型是子类类型),否则将在运行时引发ClassCastException异常。
     */
}


class BaseClass{
    public int book = 6;

    public void base() {
        System.out.println("父类的普通方法");
    }
    public void test() {
        System.out.println("父类被覆盖的方法");
    }
}

class SubClass extends  BaseClass{
    public String book = "JAVA";

    public void test()
    {
        System.out.println("子类的覆盖父类的方法");
    }
    public void sub()
    {
        System.out.println("子类的普通方法");
    }
    public static void main(String[] args)
    {
        /**
         * 因为子类其实是一种特殊的父类，因此Java允许把一个子类对象直接赋给一个父类引用变量，无须任何类型转换，或者被称为向上转型（upcasting),向上转型由系统自动完成。
         * 当把一个子类对象直接赋给父类引用变量时，例如上面的BaseClass ploymophicBc=new SubClass();这个ploymophicBc引用变量的编译时类型是BaseClass，
         * 而运行时类型是SubClass，当运行时调用该引用变量的方法时，其方法行为总是表现出子类方法的行为特征，而不是父类方法的行为特征，这就可能出现：相同类型的变量、
         * 调用同一个方法时呈现出多种不同的行为特征，这就是多态。
         */

        /**
         * 与方法不同的是，对象的实例变量则不具备多态性。比如上面的ploymophicBc引用变量，程序中输出它的book实例变量时，
         * 并不是输出SubClass类里定义的实例变量，而是输出BaseClass类的实例变量。
         * 通过引用变量来访问其包含的实例变量时，系统总是试图访问它编译时类型所定义的成员变量，而不是它运行时类型所定义的成员变量。
         */
        BaseClass bc = new BaseClass();
        System.out.println(bc.book); // 6

        bc.base();
        bc.test();
        System.out.println("****************");

        SubClass sc = new SubClass();
        System.out.println(sc.book);
        sc.base();
        sc.test();
        sc.sub();
        System.out.println("****************");

        BaseClass ploymophicBc = new SubClass();
        System.out.println(ploymophicBc.book);

        ploymophicBc.base();
        ploymophicBc.test();
//        ploymophicBc.sub();


        /**
         * 考虑到进行强制类型转换时可能出现异常，因此进行类型转换之前应先通过instanceof运算符来判断是否可以成功转换。
         * 例如，上面的var str=(String)objPri；代码运行时会引发ClassCastException异常，这是因为objPri不可转换成String类型。
         * 为了让程序更加健壮，可以将代码改为如下：
         */
        Object objPri = Integer.valueOf(5);

        if (objPri instanceof String)
        {
            var str = (String)objPri;
        }


        /**
         * instanceof和(type)是Java提供的两个相关的运算符，通常先用
         * instanceof判断一个对象是否可以强制类型转换，然后再使用(type)运算符进行强制类型转换，从而保证程序不会出现错误。
         */

        /**
         * 在使用instanceof运算符时需要注意：instanceof运算符前面操作数的编译时类型要么与后面的类相同，
         * 要么与后面的类具有父子继承关系，否则会引起编译错误。
         */
        var a = "hello";
        //报错:天意无法通过
//        System.out.println( a instanceof Math);
    }
}