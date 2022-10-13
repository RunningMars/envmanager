//package com.bikego.env.management.controller.testCase.part11;

//import org.junit.Test;

import java.awt.*;
import java.util.concurrent.Flow;

public class AWT {

    /**
     * Java使用AWT和Swing类完成图形用户界面编程，其中AWT的全称是抽象窗口工具集（Abstract Window Toolkit），它是Sun最早提供的
     * GUI库，这个GUI库提供了一些基本功能，但这个GUI库的功能比较有限，所以后来又提供了Swing库
     */

    public static void main(String[] args)
    {
        //窗口
        var f = new Frame("测试窗口");

        //f.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        //for (var i = 0;i < 10; i++)
        //{
        //    f.add(new Button("按钮" + i));
        //}


        f.setLayout(new BorderLayout(30,5));
        f.add(new Button("南"),BorderLayout.SOUTH);
        f.add(new Button("北"),BorderLayout.NORTH);
        f.add(new Button("中"));
        f.add(new Button("东"),BorderLayout.EAST);
        f.add(new Button("西"),BorderLayout.WEST);


        //var sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        //var p = new Panel();
        //sp.add(new TextField(20));
        //sp.add(new Button("单击我"));
        //f.add(sp);
        //f.setBounds(30,30,250,120);
        
        //设置窗口为最佳大小
        f.pack();
        
        
        f.setVisible(true);
    }
}
