package sort;

import java.util.Arrays;

/**
 * 插入排序
 * 概念：
 * 1.当前索引左边的元素都是有序的，但是最终位置不确定
 * 2.将每一个元素插入到有序数组的合适位置
 * 特性：
 * 1.插入排序所需的时间取决于输入中元素的初始顺序
 * 时间复杂度：
 * 最好情况：0
 * 最差情况：n2/2
 * 平均情况：n2/4
 * 平方级
 * 总结：
 * 插入排序对于部分有序的数组十分高效，也很适合小规模数组。也是高级排序算法的中间过程
 * @author liyuke
 * @date 2020-12-02 23:39
 */
public class Insertion {

    private static int[] a = {1,2,3,5,10,6};

    public static void sort(int[] c){
        int n = c.length;
        for(int i = 1; i<n; i++){
            for(int j = i; j>0&&c[j]<c[j-1];j--){
                int temp = c[j];
                c[j] = c[j-1];
                c[j-1] = temp;
            }

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
