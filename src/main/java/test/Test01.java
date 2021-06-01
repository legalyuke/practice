package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author liyuke
 * @date 2020-10-22 15:01
 */
//成员内部类&&局部内部类练习
public class Test01 {
    /*
     * 静态代码块测试
     * */

    //    Test01(){
//        x = 2;
//    }
//    {
//        x = 1;
//    }
    static {
        x = 3;
    }

    static int x, y;
    static Map map;

    static void operator(StringBuffer a, StringBuffer b) {
        a.append(b);
        b = a;
    }

    public static void main(String[] args) {
        StringBuffer m = new StringBuffer("A");
        StringBuffer n = new StringBuffer("B");
//        System.out.println(m.charAt(0));
        m.deleteCharAt(m.length()-1);
        operator(m, n);
//        System.out.println(m + "," + n);
        String z = "01234";
        Integer z1 = Integer.valueOf(z);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
//        System.out.println(z1);
//        System.out.println(list.toString());

//        new Test01();
//        System.out.println(x++ + 2);
        int y = x++ + 1;
//        System.out.println(y);
//        System.out.println(Test01.x);
//        System.out.println(y);
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
//        inner.print(1);
        outer.method();

        /*
        * 自动转型测试
        * */
        float f1 = 42.0f;
        long l1 =  42;
//        System.out.println(f1 == l1);

        /*
        * HashMap测试
        * */
        class BiFunctionImpl implements BiFunction<Integer,Integer,Integer>{

            @Override
            public Integer apply(Integer integer1, Integer integer2) {
                return integer1+integer2;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.merge(1,1, Integer::sum);
        map.merge(1,1, Integer::sum);
        map.merge(2,2, Integer::sum);
        map.merge(2,2, Integer::sum);
        map.merge(2,2, Integer::sum);
        map.merge(3,2, Integer::sum);
        map.merge(3,2, Integer::sum);
        System.out.println(map);
                

    }
}

class Outer {
    String s = "34324";
    int m = 2;
    int i = 0;

    class Inner {
        void print(int k) {
//            System.out.println(i);
//            System.out.println(Outer.this.m);
//            System.out.println(k);
        }
    }

    void method() {


        Inner inner = new Inner();
//        inner.print(m);
    }

}

