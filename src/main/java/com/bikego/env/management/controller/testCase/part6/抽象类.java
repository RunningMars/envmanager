package com.bikego.env.management.controller.testCase.part6;

import org.junit.Test;

public class 抽象类 {


    /**
     * 抽象方法和抽象类的规则如下。
     * ➢ 抽象类必须使用abstract修饰符来修饰，抽象方法也必须使用abstract修饰符来修饰，抽象方法不能有方法体。
     * ➢ 抽象类不能被实例化，无法使用new关键字来调用抽象类的构 造器创建抽象类的实例。即使抽象类里不包含抽象方法，这个抽象类也不能创建实例。
     * ➢ 抽象类可以包含成员变量、方法（普通方法和抽象方法都可 以）、构造器、初始化块、内部类（接口、枚举）5种成分。抽象类的构造器不能用于创建实例，主要是用于被其子类调用。
     * ➢ 含有抽象方法的类（包括直接定义了一个抽象方法；或继承了一个抽象父类，但没有完全实现父类包含的抽象方法；或实现了一个接口，但没有完全实现接口包含的抽象方法三种情况）只能被定义成抽象类。
     *
     * 注意： 归纳起来，抽象类可用“有得有失”4个字来描述。“得”指的 是抽象类多了一个能力：抽象类可以包含抽象方法；
     * “失”指的是抽象类失去了一个能力：抽象类不能用于创建实例。
     */


    /**
     * 抽象类是从多个具体类中抽象出来的父类，它具有更高层次的抽象。从多个具有相同特征的类中抽象出
     * 一个抽象类，以这个抽象类作为其子类的模板，从而避免了子类设计的随意性。
     * 抽象类体现的就是一种模板模式的设计，抽象类作为多个子类的通用模板，子类在抽象类的基础上进行扩展、改造，但子类总体上会
     * 大致保留抽象类的行为方式。
     */
    @Test
    public void t1()
    {
        Shape s1 = new Triangle("黑色",3,5,4);
        Shape s2 = new Circle("白色", 2.5);

        System.out.println(s1.getType());
        System.out.println(s1.calPerimeter());
        System.out.println(s2.getType());
        System.out.println(s2.calPerimeter());
    }

    /**
     *
     * 注意：
     * static和abstract并不是绝对互斥的，static和abstract虽然不能同时修饰某个方法，但它们可以同时修饰内部类。
     *
     * 注意：
     * abstract关键字修饰的方法必须被其子类重写才有意义，否则这个方法将永远不会有方法体，因此abstract方法不能定义为
     * private访问权限，即private和abstract不能同时修饰方法。
     */
}

abstract class Shape{

    private String color;

    public abstract String getType();

    public abstract double calPerimeter();

    public Shape()
    {
    }

    public Shape(String color) {
        this.color = color;
    }
}

class Triangle extends Shape{

    private double a;

    private double b;

    private double c;

    public Triangle(String color, double a, double b, double c) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String getType() {
        return "三角";
    }

    @Override
    public double calPerimeter() {
        return a + b + c;
    }
}

class Circle extends Shape{

    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public String getType() {
        return "圆形";
    }

    @Override
    public double calPerimeter() {
        return radius * Math.PI * 2;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}