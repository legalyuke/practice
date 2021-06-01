package test;

import java.util.*;

/**
 * 整型补零测试
 *
 * @author liyuke
 * @date 2020-11-13 9:02
 */

public class FormatTest {

    public boolean checkStraightLine(int[][] coordinates) {
        int length = coordinates.length;
        if (length < 1) {
            return true;
        }
        //对二维数组先进行插入排序
        for (int k = 1; k < length; k++) {
            for (int j = k; j > 0; j--) {
                if (coordinates[j][0] < coordinates[j - 1][0]) {
                    int[] temp = coordinates[j];
                    coordinates[j] = coordinates[j - 1];
                    coordinates[j - 1] = temp;
                }
            }
        }
        double slope = 0.0;
        boolean flag = false;
        for (int i = 1; i < length; i++) {
            double temp = Math.abs((double) (coordinates[i][1] - coordinates[i - 1][1]) / (coordinates[i][0] - coordinates[i - 1][0]));
            if (!flag) {
                slope = temp;
                flag = true;
            } else {
                if (Double.compare(slope, temp) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

//    public boolean checkStraightLine(int[][] coordinates) {
//        int x1 = coordinates[1][0] - coordinates[0][0];
//        int y1 = coordinates[1][1] - coordinates[0][1];
//        for (int i = 2; i < coordinates.length; i++) {
//            int x2 = coordinates[i][0] - coordinates[0][0];
//            int y2 = coordinates[i][1] - coordinates[0][1];
//            if (x1 * y2 != x2 * y1) {
//                return false;
//            }
//        }
//        return true;
//    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] == target[i]) {
                continue;
            }

        }
        return 0;
    }


    public static void main(String[] args) {
//        整型补零
//        String seqStr = String.format("%04d", 10);
//        System.out.println(seqStr);
//String s = "123123";
//s = s.substring(s.length()-1);
//        System.out.println(s);
//        String s = 123;
//        String [] array = {"1","1231","123","1231"};
//          int a = 0x1032423;
//          int b =
//        List list = new ArrayList<>();
//        System.out.println(array.getClass());
//        List<String> list = new ArrayList<>();
//        Class z = list.getClass();
//        Method[] method = z.getDeclaredMethods();
//        Arrays.stream(method).forEach(System.out::println);
//        Date date = new Date();
//        String s1 = null;
//        String s2 = null;
//        System.out.println(s1+s2);
//        float x = 1.0f;
//        Float y = 2.0f;
//
//        System.out.println(Objects.hash(y));
//        if(Double.compare(x,y)>0){
//            System.out.println("x");
//        }else {
//            System.out.println("y");
//        }
//        Map<String,String> map = new HashMap<>();
//        for(Map.Entry entry: map.entrySet()){
//            entry.getKey();
//            entry.getValue();
//        }
//        List<Object> list = new ArrayList<>();

//        Object[] array = new Long[2];
//        int x = 123_434_3432;
//        System.out.println(x);
//         final Test t = new Test(1);
////         t = t.setX(2);
//        System.out.println(t);
//        AbstractFactoryTest abstractFactoryTest = new AbstractFactoryTestA();
//        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
//        Arrays.stream(array).filter(x -> x > 3).forEach(System.out::println);
//        Calendar calendar = Calendar.getInstance();
//        String year = String.valueOf(calendar.get(Calendar.YEAR));
//        int month = calendar.get(Calendar.MONTH) + 1;
//        System.out.println(year);
//        System.out.println(month);
//        List<String> list = new ArrayList<>();
//        list.add(null);
//        list.add(null);
//        HashMap<String,String> map = new HashMap<>();
//
//        for (String s : list){
//        System.out.println(s);
//        int[][] array = {{0, 0}, {0, 1}, {0, -1}};
//        FormatTest formatTest = new FormatTest();
//        System.out.println(formatTest.checkStraightLine(array));
        double z = 2d;
        if (z == (int) z) {
            System.out.println("相等");
        } else {
            System.out.println("不等");
        }
    }
}


//     final static class Test{
//          final int x;
//          public Test(int x){
//              this.x = x;
//          }
//          public Test setX(int x){
//              return new Test(x);
//          }
//          @Override
//          public String toString(){
//              return String.valueOf(x);
//          }
//    }


