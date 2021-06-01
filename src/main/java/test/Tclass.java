package test;

import java.util.*;

/**
 * @author liyuke
 * @date 2021-03-18 22:28
 */
public class Tclass<T> {

    private T a;

    public void set(T a) {
        this.a = a;
    }

    public Tclass(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public static void main(String[] args) {
        Tclass<String> tclass = new Tclass<>("sdf");
        System.out.println(tclass.get());
        String s = new String("dfsdf");
        char temp = s.charAt(0);
        SortedMap<Integer, Integer> map = new TreeMap<>();
        map.merge(1, 1, Integer::sum);
        String key;
        map.firstKey();
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry entry : set) {
            if (entry.getValue().equals(1)) {
                key = (String) entry.getKey();
                break;
            }
        }


    }

    public int firstUniqChar(String s) {
        SortedMap<Integer, Integer> map = new TreeMap<>();
        Map<Character, Integer> valueMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (valueMap.containsKey(s.charAt(i))) {
                map.merge(valueMap.get(s.charAt(i)), 1, Integer::sum);
            } else {
                map.put(i, 1);
                valueMap.put(s.charAt(i), i);
            }

        }
        Integer key = -1;
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry entry : set) {
            if (entry.getValue().equals(1)) {
                key = (Integer) entry.getKey();
                break;
            }
        }
        return key;
    }

}
