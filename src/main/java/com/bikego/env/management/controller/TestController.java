package com.bikego.env.management.controller;

import org.junit.Test;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class TestController {
    //public static void main(String[] args)


    @Test
    public void index()
    {
//        System.exit(400);
//        System.exit(400);
//        System.exit(400);
//        System.exit(400);
//        System.exit(400);
//        System.exit(400);
//        System.exit(400);
//        System.exit(400);
//        System.exit(400);
//        System.exit(400);
//        System.exit(400);
//        System.exit(400);
//        System.exit(400);
//        System.exit(400);

        short sValue = 5;
        Integer ii = 5;
        System.out.println(ii.getClass().toString());
//        sValue = sValue -2;
        System.exit(400);

        /*
        mistake statement
        Float s = 5.6;
        */

        Float a = (float)5.6;

        Float b = 5.6f;
        System.out.println(a);
        System.out.println(b);
        System.exit(400);

        String str2 = 3.5f + "";
        System.out.println(str2);
        System.out.println(3 + 4 + "Hello");
        System.out.println("Hello" + 3 + 4);
//      int a = 6;
//      float f = a;
//        System.out.println(f);

        System.exit(400);
        char aChar = 'a';
        char enterChar = '\r';
        char ch = '\u9999';
        System.out.println(ch);
        char zhong = 'f';
        int zhongValue = zhong;
        System.out.println(zhongValue);
        char c = 97;
        System.out.println(c);
        System.exit(400);



        String s = true + "";
        char i = 's';
        System.out.println(s);
        System.exit(400);
        System.exit(400);
        System.exit(400);
        System.exit(400);
        System.exit(400);
        System.exit(400);
        System.exit(400);
        System.exit(400);
        System.exit(400);
        System.exit(400);
        System.exit(400);
        System.exit(400);
        System.exit(400);
        System.exit(400);
        System.exit(400);
        System.exit(400);
        System.exit(400);
        System.exit(400);
        System.exit(400);
        System.exit(400);


        System.exit(400);
        //================================ Stream Api ===========================================
        List<String> sdf = new ArrayList<String>();
        sdf.add("sdf");
        sdf.add("rdgrdg");
        sdf.add("sdysdy");
//        System.out.println(sdf);
//        sdf.stream();

        Stream<Integer> integerStream = Stream.of(123, 43, 654, 657, 876, 4, 324, 1, 3, 6);
        Stream<Integer> integerStream1 = integerStream.filter(item -> item > 50);
        Set<Integer> collect = integerStream1.map(item -> item += 1).collect(Collectors.toSet());
//        List<Integer> collect = integerStream1.map(item -> item += 1).collect(Collectors.toList());

        System.out.println(collect);

//        Object[] objects = integerStream1.map(item->item += 1).toArray();
//
//        for (Object object : objects) {
//            System.out.println(object);
//        }

        System.exit(421);


        //================================ lambda ===========================================

        Runnable runnableObj = ()-> System.out.println("i love you ~");
        System.out.println("ssdfffd333d");

        runnableObj.run();
        System.exit(421);

        //================================ IO ===========================================

        InputStream is1 = System.in;
        try{
            InputStream is = System.in;
            InputStreamReader fsr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(fsr);

            while(true)
            {
                System.out.println("请输入文字:");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "e".equalsIgnoreCase(data))
                {
                    System.out.println("..程序结束..");
                    System.exit(0);
                }

                System.out.println(data.toUpperCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //        System.out.println("2323");
//            Map<String,Integer> map = new HashMap<String,Integer>();
//            map.put("123",2333);
//            map.put("124",1242333);
//            System.out.println(map);
//            DAO<Integer> dao = new DAO<Integer>();

//            DAO<User> dao = new DAO<>();
//            User u = new User(1001,33,"jay");
//            User u2 = new User(1002,19,"j33dday");
//            dao.map.put("1",u);
//            dao.map.put("2",u2);
////            System.out.println(dao.map);
//            System.out.println(dao.list());
//            System.out.println("======== finished ======");

        //================================ 泛型 ===========================================
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list.add(213);
//        list.add(23);
//        list.add(223);
//        list.add(2213);
//
//        ArrayList<String> list2 = new ArrayList<String>();
//
//        list2.add("fff");
//        list2.add("sss");
//        list2.add("sssdd");
//        list2.add("saa");
//        show2(list);
//        show2(list2);
//        Iterator<Integer> iterator = list.iterator();

        //================================ ArrayList ===========================================
//        List list = new ArrayList();
//        list.add(122);
//        list.add("dddss");
//        list.add(3);
//        list.add(52);
//        Object o = list.get(1);
//        Collections.sort(list);
//        System.out.println(o.getClass());
        //================================ HashMap ===========================================
//        Map map = new HashMap();
//        map.put(123,332);
//        System.out.println(map);
        //================================ calendar ===========================================
//        Calendar c = Calendar.getInstance();
//        System.out.println(c.getClass());
//
//        int days = c.get(Calendar.DAY_OF_MONTH);
//        System.out.println(days);

        //================================ stringBuffer ===========================================
//        String str = reverseString("123456789",0,9);
//        System.out.println(str);
        //================================ date ===========================================

//        Date date1 = new Date();
//        DateFormat df = new SimpleDateFormat();
//        String formatDate1 = df.format(date1);
//        System.out.println( formatDate1 );

//        Date date1 = new Date();
//
//        System.out.println(date1.toString());
//        System.out.println(date1.getTime());

//        Date date2 = new Date(1640073215015L);
//
//        System.out.println(date2.toString());
//        System.out.println(date2.getTime());

//        java.sql.Date date3 = new java.sql.Date(1640073215015L);
//        Date date8 = (Date)date3;
//
//        System.out.println(date8);
        //================================ StringBuffer ===========================================
        /*
        StringBuffer buff = new StringBuffer("构建一个可变的stringbuffer");
        System.out.println("welcome! rdg " + buff);
//        buff.append("  hahahaha");
//        buff.delete(7,26);
        buff.replace(7,26," change replaced");

        buff.reverse();
        System.out.println("welcome! rdg " + buff);
         */
        //===========================================================================
        //===========================================================================
        //===========================================================================
        //===========================================================================
        //===========================================================================
        //===========================================================================
        //===========================================================================
        //===========================================================================



//        UserDaoImpl userDaoImpl = new UserDaoImpl();
//        Class[] interfaces = {UserDao.class};
//        UserDaoProxy userDaoProxyHandler = new UserDaoProxy(userDaoImpl);
//        UserDao dao = (UserDao)Proxy.newProxyInstance(TestController.class.getClassLoader() , interfaces,userDaoProxyHandler );
//        dao.add("rdg");
//        System.out.println("success index");
    }

    /**
     * reverse string
     * @param str
     * @param start
     * @param end
     * @return
     */
    protected String reverseString(String str,int start,int end)
    {
        if (start > end)
        {
            return "";
        }
        int len = str.length();
        if (len < end)
        {
            end = len;
        }
        if(start == 0 & end >= len)
        {
            return (new StringBuffer(str)).reverse().toString();
        }
        String noChange1 = "";
        String noChange2 = "";
        String change = str.substring(start,end);
        if(start > 0)
        {
            noChange1 = str.substring(0,start);
        }else{
            noChange2 = str.substring(end,len);
        }

        if(end < len)
        {
            noChange2 = str.substring(end,len);
        }else{
            noChange1 = str.substring(0,start);
        }

        String changed = str.substring(start,end);
        StringBuffer buff = new StringBuffer(changed);
        buff.reverse();
        return noChange1 + buff + noChange2;
    }

    protected int sameStringCount(String mainStr,String subStr)
    {
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index;
        if (subLength > mainLength)
        {
            return 0;
        }
        while ( (index = mainStr.indexOf(subStr)) != -1 )
        {
            count++;
            mainStr = mainStr.substring(index + subStr.length());
        }
        return count;
    }

    public <T> void show( List<T> list)
    {
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext())
        {
            T next = iterator.next();
            System.out.println(next);
        }
    }


    public void show2( List<?> list)
    {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext())
        {
            Object next = iterator.next();
            System.out.println(next);
        }
    }


}

////面试题
//class StringTest {
//    String str = new String("good");
//    char[] ch = { 't', 'e', 's', 't' };
//    public void change(String str, char ch[]) {
//        str = "test ok";
//        ch[0] = 'b'; }
//    @Test
//    public static void main(String[] args) {
//        StringTest ex = new StringTest();
//        ex.change(ex.str, ex.ch);
//        System.out.print(ex.str + " and ");//
//        System.out.println(ex.ch);
//        //答: test ok      and     best
//        //正确答案: good   and     best
//    }
//}


class DAO<T>
{
    public HashMap<String,T> map = new HashMap<>();

    public void save(String id,T entity)
    {
        map.put(id,entity);
    }

    public T get(String id)
    {
        return map.get(id);
    }

    public void update(String id,T entity)
    {
        if(map.containsKey(id))
        {
            map.put(id,entity);
        }
    }

    public List<T> list()
    {
        Set<Map.Entry<String,T>> set = map.entrySet();
        List<T>list = new ArrayList<T>();
        Iterator<Map.Entry<String, T>> iterator = set.iterator();
        while(iterator.hasNext())
        {
            Map.Entry<String,T> en = iterator.next();
            list.add(en.getValue());
        }
        return list;
    }

    public void delete(String id)
    {
        map.remove(id);
    }
}
