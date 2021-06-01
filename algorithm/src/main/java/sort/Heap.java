package sort;

import java.util.Arrays;

/**
 * 堆排序
 * 概念：
 * 1.利用二叉堆进行排序的一种经典而优雅的排序算法
 * 2.基于堆的优先队列
 * 排序过程
 * 1.构造一个完全二叉堆
 * 2.删除堆顶元素后，下沉排序，重新构造一个完全二叉堆
 * 3.堆中元素为1时停止
 * 特点：
 * 时间复杂度：
 * 平均情况：NlogN
 * 空间复杂度：1  原地排序算法
 * 稳定性：不稳定排序
 * @author liyuke
 * @date 2020-12-11 12:35
 */
public class Heap {
    private static int[] a = {12,11,3,5,10,6};

    public static void sort(int[] a){
        int n = a.length;
        for(int k = n/2; k >= 1; k--){
            sink(a,k,n);
        }
        while (n > 1){
            exch(a,1,n--);
            sink(a,1,n);
        }
    }

    private static void sink(int[] a, int k, int n){
        while (2*k <= n){
            int j = 2*k;
            if(j < n && a[j] < a[j+1]){
                j++;
            }
            if(k>j){
                break;
            }
            exch(a,k,j);
        }
    }

    private static void exch(int[] a, int k, int j) {
        int temp = a[k];
        a[k] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        long initTime = System.currentTimeMillis();
        sort(a);
        Arrays.stream(a).forEach(System.out::println);
        System.out.println("------------------执行排序数组大小："+ a.length);
        System.out.println("------------------执行耗时："+ (System.currentTimeMillis()-initTime)+"ms");
    }
}
