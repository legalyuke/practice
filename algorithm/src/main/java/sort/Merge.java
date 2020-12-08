package sort;

import java.util.Arrays;

/**
 * 归并排序
 * 概念：
 * 1.要将一个数组排序，可以先（递归地）将它分成两半分别排序
 * 2.将结果归并起来
 * 特性：
 * 时间复杂度为：NlogN
 * 空间复杂度：N
 * @author liyuke
 * @date 2020-12-08 12:30
 */
public class Merge {

    private static int[] a = {12,11,3,5,10,6};
    private static int[] aux;
    //初始化
    public static void sort(int[] a){
        aux = new int[a.length];
        sort(a,0,a.length-1);
    }
    //先递归划分子数组
    public static void sort(int[] a,int lo,int hi){
        if(hi<=lo){
            return;
        }
        //选取中点
        int mid = lo + (hi - lo)/2;
        //左闭右开
        sort(a,lo,mid);
        sort(a,mid +1, hi);
        merge(a,lo,mid,hi);
    }
    //对划分后的数组进行归并,双指针法
    public static void merge(int[] a, int lo, int mid ,int hi){
        int i = lo;
        int j = mid + 1;
        //先拷贝数组
        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }
        for(int k = lo; k <= hi ;k++){
            if(i > mid)
                a[k] = aux[j++];
            else if(j > hi)  a[k] = aux[i++];
            else if(aux[j]<aux[i]) a[k] = aux[j++];
            else a[k] = aux[i++];
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
