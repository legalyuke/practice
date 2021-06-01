package letCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liyuke
 * @date 2021-05-25 23:27
 */
public class CurrentKElement {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int mid = arr.length / 2;
        int index = -1;
        int begin = 0;
        int end = arr.length - 1;
        int min = -1;
        while (true) {
            if (arr[mid] == x) {
                index = mid;
                break;
            }
            if (begin == end) {
                index = begin;
                min = arr[begin];
                if (begin - 1 >= 0 && Math.abs(arr[begin - 1] - x) < Math.abs(min - x)) {
                    min = arr[begin - 1];
                    index = begin - 1;
                }
                if (begin + 1 < arr.length && Math.abs(arr[begin + 1] - x) < Math.abs(min - x)) {
                    index = begin + 1;
                }
                break;
            }
            if (arr[mid] < x) {
                begin = mid + 1;
                mid = (end - mid) / 2 + mid;

            } else {
                end = mid - 1;
                mid = (mid - begin) / 2 + begin;

            }

        }
        int beginIndex = 0;
        int half = (k - 1) / 2;
        int reminder = (k - 1) % 2;
        int arrIndex = arr.length - 1;
        if ((arrIndex - half) < index) {
            beginIndex = arrIndex - k;
        }
        if ((arrIndex - half) > index && index - half - reminder > 0) {
            beginIndex = index - half - reminder;
        }
        for (int i = 0; i < k; i++) {
            res.add(arr[i + beginIndex]);

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9));
    }
}
