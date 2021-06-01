package test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author liyuke
 * @date 2021-03-04 9:13
 */


public class GotoTest {

    private void f() {
        System.out.println("private f");
    }

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InstantiationException, InvocationTargetException {
//        labelOuter:

//        for (int i = 0; i < 10; i++) {
//            labelInner:
//            for (int j = 0; j < 10; j++) {
//
//                System.out.println("i==" + i + ";j==" + j);
//                if (j == 3) {
//                    continue labelOuter;
//                }
//                if (i == 6) {
//                    break labelInner;
//                }
//
//            }
//        }
        String[] s = {"1", "2", "3", "4"};
        List<String> list = Arrays.asList(s);
        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }
        SortedSet<String> sortedSet = new TreeSet<>();
        sortedSet.add("13231");
        sortedSet.add("53231");
        sortedSet.add("43231");
        sortedSet.add("33231");
        sortedSet.add("23231");
        sortedSet.add("73231");
        sortedSet.forEach(System.out::println);
        Map<String, String> map = new HashMap<String, String>() {
            {
                put("1", "1");
                put("2", "2");

            }
        };
        map.getOrDefault("3","3");
        map.keySet().forEach(System.out::println);
        map.values().forEach(System.out::println);
        map.entrySet().forEach(System.out::println);
        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Map.Entry<String, String> temp : set) {
            System.out.println(temp.getKey());
            System.out.println(temp.getValue());
        }
        Map<String,Integer> integerMap = new HashMap<>();
        integerMap.merge("1",1,Integer::sum);
//        Collections.sort();
        Class<?> temp = Map.class;
        Method method = temp.getDeclaredMethod("name", String.class);
        Field field = temp.getDeclaredField("name");
        method.setAccessible(true);
        field.setAccessible(true);
        Object o = temp.newInstance();
        if (o instanceof Map) {
            System.out.println(true);
        }
        field.get(o);
        method.invoke(o);

        SoftReference<Map<String,String>> re = new SoftReference<>(map);




//       GotoTest gotoTest = new Test();
//       gotoTest.f();

    }
}

class Test extends GotoTest {
    public void f() {
        System.out.println("public f");
    }
}
