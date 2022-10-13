package com.bikego.env.management.controller.testCase.part4;

import org.junit.Test;

import java.util.Arrays;

public class RmbCn {

    /**
     * 例如，在实际开发中的一个常用工具函数：需要将一个浮点数转 换成人民币读法字符串，这个程序就需要使用数组。
     * 实现这个函数的 思路是，首先把这个浮点数分成整数部分和小数部分。提取整数部分 很容易，直接将这个浮点数强制类型转换成一个整数即可，这个整数 就是浮点数的整数部分；
     * 再使用浮点数减去整数将可以得到这个浮点数的小数部分。然后分开处理整数部分和小数部分，其中小数部分的处理比较简 单，直接截断到保留2位数字，转换成几角几分的字符串。
     * 整数部分的 处理则稍微复杂一点，但只要认真分析不难发现，中国的数字习惯是4 位一节的，一个4位的数字可被转成几千几百几十几，至于后面添加什么单位则不确定，
     * 如果这节4位数字出现在1～4位，则后面添加单位 元；如果这节4位数字出现在5～8位，则后面添加单位万；如果这节4位数字出现在9～12位，则后面添加单位亿；多于12位就暂不考虑了。
     * 因此实现这个程序的关键就是把一个4位数字字符串转换成一个中文读法。下面程序把这个需求实现了一部分。
     */

    @Test
    public void toRmbCn()
    {
        var amount = 4325432636L;
        Long left = (Long)amount;
        System.out.println(amount);

        //小数点后
        double right = (amount - left) * 1000;
        String rightStr = "";

        if (right > 0)
        {
            String jiaoFenStr = String.valueOf(right);
            var jiaoStr = jiaoFenStr.substring(0,1);
            System.out.println(jiaoFenStr);
            var fenStr = jiaoFenStr.substring(1,2);
            rightStr += intToCn(Integer.parseInt(jiaoStr)) + "角";
            rightStr += intToCn(Integer.parseInt(fenStr)) + "分";
        }

        //整数部分
        String leftStr = left + "";
        int len = leftStr.length();

        String resultStr = "";
        if(len > 8)
        {
            String substring = leftStr.substring(0,len - 8);
            leftStr = leftStr.substring(len - 8,len);
            resultStr += toPartial(substring);
            resultStr += "亿";
        }
        if(leftStr.length() > 4)
        {
            String substring = leftStr.substring(0,leftStr.length() - 4);
            leftStr = leftStr.substring(leftStr.length() - 4,leftStr.length());

            resultStr += toPartial(substring);
            resultStr += "万";
        }

        resultStr += toPartial(leftStr);

        resultStr += "圆";

        if (rightStr.isEmpty())
        {
            resultStr += "整";
        }else{
            resultStr += rightStr;
        }
        System.out.println(resultStr);
    }


    protected String toPartial(String str)
    {
        String resultStr = "";
        if (str.length() > 4)
        {
            return resultStr;
        }
        for(var i =0;i<str.length();i++)
        {
            var temp = str.substring(i,i+1);

            int no = str.length() - i; //4 3 2 1
            if (no == 1 && temp.equals("0"))
            {

            }else{
                resultStr += intToCn(Integer.parseInt(temp));
            }



            switch(no)
            {
                case 4:
                    resultStr += "千";
                    break;
                case 3:
                    resultStr += "百";
                    break;
                case 2:
                    resultStr += "十";
                    break;
                case 1:
                    resultStr += "";
                    break;
                default:
                    break;
            }
        }
        return resultStr;
    }

    protected String intToCn(int i)
    {
        String str = "";
        if (i < 0 || i >= 10)
        {
            return str;
        }
        switch(i)
        {
            case 0:
                str = "零";
                break;
            case 1:
                str = "壹";
                break;
            case 2:
                str = "贰";
                break;
            case 3:
                str = "叁";
                break;
            case 4:
                str = "肆";
                break;
            case 5:
                str = "伍";
                break;
            case 6:
                str = "陆";
                break;
            case 7:
                str = "柒";
                break;
            case 8:
                str = "捌";
                break;
            case 9:
                str = "玖";
                break;
            default:
                break;
        }
        return str;
    }
}
