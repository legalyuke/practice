package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 概念：
 * 1.一种较为简单的排序算法
 * 2.如同碳酸饮料中二氧化碳的气泡最终会上浮到顶端一样，故名“冒泡排序”
 * 原理：
 * 1.比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2.对每一对相邻元素做同样的工作，从开始第一对到最后一对。
 * 3.针对所有元素重复以上步骤，除了最后一个
 * 4.持续每次对越来越少的元素重复上面的的步骤，知道没有任何一对数字需要比较
 * 时间复杂度：
 * 平均情况：n的平方
 * 空间复杂度：1
 * 稳定性：
 * 稳定排序算法
 *
 * @author liyuke
 * @date 2020-12-10 12:40
 */
public class Bubble {

    private static int[] a = {12, 11, 3, 5, 10, 6};

    //原始版本
    public static void sort(int[] a) {
        for (int end = a.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end; begin++) {
                //前一个比后一个大，交换顺序
                if (a[begin] < a[begin - 1]) {
                    int temp = a[begin];
                    a[begin] = a[begin - 1];
                    a[begin - 1] = temp;
                }
            }
        }
    }

    //优化后版本
    public static void optimizeSort(int[] a) {
        //声明一个标记位，标记数组是否有序
        boolean sorted = true;
        for (int end = a.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end; begin++) {
                //前一个比后一个大，交换顺序
                if (a[begin] < a[begin - 1]) {
                    int temp = a[begin];
                    a[begin] = a[begin - 1];
                    a[begin - 1] = temp;
                    sorted = false;
                }
                if (sorted) break;
            }
        }
    }

    public static void main(String[] args) {
        long initTime = System.currentTimeMillis();
        optimizeSort(a);
        Arrays.stream(a).forEach(System.out::println);
        System.out.println("------------------执行排序数组大小：" + a.length);
        System.out.println("------------------执行耗时：" + (System.currentTimeMillis() - initTime) + "ms");
    }
}
