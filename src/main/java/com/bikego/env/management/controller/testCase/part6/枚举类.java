package com.bikego.env.management.controller.testCase.part6;

import org.junit.Test;

public class 枚举类 {

    /**
     * 在早期代码中，可能会直接使用简单的静态常量来表示枚举，例如如下代码：
     * public static final int SEASON_SPRING = 1;
     * public static final int SEASON_SUMMER = 2;
     * 这种定义方法简单明了，但存在如下几个问题。
     * ➢ 类型不安全：因为上面的每个季节实际上是一个int整数，因此完全可以把一个季节当成一个int整数使用，
     * 例如进行加法运算SEASON_SPRING+SEASON_SUMMER，这样的代码完全正常。
     * ➢ 没有命名空间：当需要使用季节时，必须在SPRING前使用SEASON_前缀，否则程序可能与其他类中的静态常量混淆。
     * ➢ 打印输出的意义不明确：当输出某个季节时，例如输出SEASON_SPRING，实际上输出的是1，这个1很难猜测到它代表了春天。
     */

    /**
     * 枚举类也是一种类，只是它是一种比较特殊的类，因此它一样可以定义成员变量、方法和构造器
     *
     */
    @Test
    public void t1()
    {
        for (var s : SeasonEnum.values())
        {
            System.out.println(s);
        }
//        SeasonEnum seasonEnum = new SeasonEnum();
    }

    @Test
    public void t2()
    {
        SeasonEnum sum = Enum.valueOf(SeasonEnum.class, "SUMMER");
        System.out.println(sum);
    }

    @Test
    public void t3()
    {
        Gender gender = Enum.valueOf(Gender.class, "FEMALE");
        System.out.println(gender);
//        System.out.println(gender.name);
//
//        gender.name = "女";
//        System.out.println(gender.name);
    }

    @Test
    public void t4()
    {
        Gender gender = Enum.valueOf(Gender.class, "FEMALE");
        System.out.println(gender);

//        gender.setName("女");
//        System.out.println(gender.getName());
//        gender.setName("男");
//        System.out.println(gender.getName());
    }

    @Test
    public void t5()
    {
//        Gender gender = new Gender("男");
//        System.out.println(gender);
//
//        gender.setName("女");
//        System.out.println(gender.getName());
//        gender.setName("男");
//        System.out.println(gender.getName());
    }

    @Test
    public void t6()
    {
        System.out.println(Operation.PLUS.eval(3,4));
        System.out.println(Operation.MINUS.eval(5,4));
        System.out.println(Operation.MULTIPLE.eval(5,4));
        System.out.println(Operation.DIVIDE.eval(5,4));
    }
}

enum SeasonEnum{
    SPRING,SUMMER,FALL,WINTER;
}
enum Gender{
    MALE("男"),FEMALE("女");

    private Gender(String name)
    {
        this.name = name;
    }

    private final String name;

    public String getName() {
        return name;
    }



//    private String name;

    /*
    public void setName(String name)
    {
        switch(this)
        {
            case MALE:
                if (name.equals("男"))
                {
                    this.name = name;
                }else{
                    System.out.println("参数错误");
                    return;
                }
                break;
            case FEMALE:
                if (name.equals("女"))
                {
                    this.name = name;
                }else{
                    System.out.println("参数错误");
                    return;
                }
                break;
        }
    }
    */
}

enum Operation{
    PLUS{
        @Override
        public double eval(double x, double y) {
            return x + y;
        }
    },
    MINUS{
        @Override
        public double eval(double x, double y) {
            return x - y;
        }
    },
    MULTIPLE{
        @Override
        public double eval(double x, double y) {
            return x * y;
        }
    },
    DIVIDE{
        @Override
        public double eval(double x, double y) {
            return x / y;
        }
    };

    public abstract double eval(double x,double y);
}