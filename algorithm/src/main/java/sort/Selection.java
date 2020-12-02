package sort;

import java.util.Arrays;

/**
 * 选择排序
 * 概念：
 * 1.找到数组中最小的那个元素
 * 2.将它和数组中的第一个元素交换
 * 3.在剩下的元素中循环以上步骤，直至排序完成
 * 特性：
 * 1.运行时间和输入无关
 * 2.数据移动是最少的
 * 时间复杂度-平方级别
 *
 * @author liyuke
 * @date 2020-12-02 23:11
 */
public class Selection {

    private static int[] a = {1,2,3,5,10,6};

    public static void sort(int[] c){
        int n = c.length;
        for(int i = 0; i<n; i++){
            int min = i;
            for(int j = i+1; j<n;j++){
                if(c[j]<c[min]){
                    min = j;
                }
            }
            int temp = c[min];
            c[min] = c[i];
            c[i] = temp;
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
