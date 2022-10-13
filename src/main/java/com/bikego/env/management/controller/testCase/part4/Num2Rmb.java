package com.bikego.env.management.controller.testCase.part4;

import org.junit.Test;

import java.util.Arrays;

public class Num2Rmb {

    /**
     * 例如，在实际开发中的一个常用工具函数：需要将一个浮点数转 换成人民币读法字符串，这个程序就需要使用数组。
     * 实现这个函数的 思路是，首先把这个浮点数分成整数部分和小数部分。提取整数部分 很容易，直接将这个浮点数强制类型转换成一个整数即可，这个整数 就是浮点数的整数部分；
     * 再使用浮点数减去整数将可以得到这个浮点数的小数部分。然后分开处理整数部分和小数部分，其中小数部分的处理比较简 单，直接截断到保留2位数字，转换成几角几分的字符串。
     * 整数部分的 处理则稍微复杂一点，但只要认真分析不难发现，中国的数字习惯是4 位一节的，一个4位的数字可被转成几千几百几十几，至于后面添加什么单位则不确定，
     * 如果这节4位数字出现在1～4位，则后面添加单位 元；如果这节4位数字出现在5～8位，则后面添加单位万；如果这节4位数字出现在9～12位，则后面添加单位亿；多于12位就暂不考虑了。
     * 因此实现这个程序的关键就是把一个4位数字字符串转换成一个中文读法。下面程序把这个需求实现了一部分。
     */

    private String[] hanArr = {
            "零","壹","贰","叁","肆","伍","陆","柒","捌","玖"
    };

    private String[] unitArr = {
            "十","百","千"
    };

    @Test
    public void test()
    {
        var amount = 234250435.346;
        System.out.println(Arrays.toString(divide(amount)));
        System.out.println(toHanStr("2743"));
    }

    private String[] divide(double num)
    {
        var zheng = (long)num;

        var xiao = Math.round((num -zheng) * 100);

        return new String[]{zheng + "",String.valueOf(xiao)};
    }

    public String toHanStr(String numStr)
    {
        String resultStr = "";
        int len = numStr.length();
        for (var i = 0 ; i < len; i++)
        {
            int temp = Integer.parseInt(numStr.substring(i,i+1));
            if (i != len-1 && temp != 0)
            {
                resultStr += hanArr[temp] + unitArr[len - 2 - i];
            }else{
                resultStr += hanArr[temp];
            }
        }
        return resultStr;
    }


}
