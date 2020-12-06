package sort;

import java.util.Arrays;

/**
 * 希尔排序---递减增量排序
 * 概念：
 * 是数组中任意间隔为h的元素都是有序的。划分为h个数组，分别进行插入排序
 * 特性：
 * 1.时间复杂度低于平方级别
 * 2.最坏情况下时间复杂度为N的3/2次方
 * 3.对于中等大小的数组它的运行时间是可以接受的
 * @author liyuke
 * @date 2020-12-06 16:36
 */
public class Shell {

    private static int[] a = {12,11,3,5,10,6};

    public static void sort(int[] a){
        int n = a.length;
        int h = 1;
        //选取步长
        while (h < n/3){   //1,4,13,40,121,364,1093,...
            h = 3*h+1;
        }
        //步长为step,在col列，row行的元素索引为col+row*step
        while (h >= 1){
            //排序使用插入排序，从h开始
            for(int i = h; i < n; i++){
                //step为h,每次递减step为同一列，进行排序
                for(int j = i; j >= h && a[j] < a[j-h]; j -= h){
                    //进行交换位置
                    int temp = a[j];
                    a[j] = a[j-h];
                    a[j-h] = temp;
                }
            }
            h = h/3;
        }
    }

    public static void main(String[] args) {
        long initTime = System.currentTimeMillis();
        sort(a);
        Arrays.stream(a).forEach(System.out::println);
        System.out.println("------------------执行排序数组大小："+ a.length);
        System.out.println("------------------执行耗时："+ (System.currentTimeMillis()-initTime)+"ms");
    }

}
