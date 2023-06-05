package org.example.sort;

import java.util.Arrays;

/**
 * 计数排序（Counting Sort）：
 * 时间复杂度为 O(n + k)，稳定排序算法。
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        countingSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void countingSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int maxVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]> maxVal) {
                maxVal = arr[i];
            }
        }
        int[] count = new int[maxVal + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }
    
}
