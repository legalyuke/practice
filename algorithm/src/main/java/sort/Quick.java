package sort;

import java.util.Arrays;

/**
 * 快速排序
 * 概念：
 * 1.一种分治排序算法
 * 排序过程：
 * 1.找出切分元素的位置，取决于数组的内容---小于等于切分元素的在左边，大于等于切分元素的在右边
 * 2.对切分点左右两边的数组递归调用
 * 3.当数组元素小于等于1的时候终止递归
 * 特点：
 * 1.应用最广泛的算法
 * 2.实现简单、适用于各种不同的输入数据且在一般应用中比其他排序算法要快得多
 * 3.属于原地排序
 * 4.快速排序的内循环比大多数排序算法都要短
 * 缺点：
 * 1.非常脆弱，在实现时要非常小心才能避免低劣的性能
 * 时间复杂度：
 * 平均情况：NlogN
 * 最坏情况：N的平方
 * 空间复杂度：
 *
 * @author liyuke
 * @date 2020-12-09 12:46
 */
public class Quick {

    private static int[] a = {12,11,3,5,10,6};

    public static void sort(int[] a){
        sort(a,0,a.length-1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if(hi<=lo){
            return;
        }
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi+1;
        int v = a[lo];
        while (true){
            while (a[++i]<v){
                if(i == hi){
                    break;
                }
            }
            while(v < a[--j]){
                if(j == lo){
                    break;
                }
            }
            if(i >= j){
                break;
            }
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        int temp = a[lo];
        a[lo] = a[j];
        a[j] = temp;
        return j;
    }

    public static void main(String[] args) {
        long initTime = System.currentTimeMillis();
        sort(a);
        Arrays.stream(a).forEach(System.out::println);
        System.out.println("------------------执行排序数组大小："+ a.length);
        System.out.println("------------------执行耗时："+ (System.currentTimeMillis()-initTime)+"ms");
    }
}
