package org.example.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

/**
 * 桶排序
 * 时间复杂度为 O(n + k)，稳定排序算法。
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        bucketSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void bucketSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int minVal = arr[0];
        int maxVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            } else if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        int bucketSize = 10;
        int bucketCount = (maxVal - minVal) / bucketSize + 1;
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int i = 0; i < arr.length; i++) {
            buckets.get((arr[i] - minVal) / bucketSize).add(arr[i]);
        }
        int index = 0;
        for (int i = 0; i < buckets.size(); i++) {
            if (buckets.get(i).size() == 0) {
                continue;
            }
            Collections.sort(buckets.get(i));
            for (int j = 0; j < buckets.get(i).size(); j++) {
                arr[index++] = buckets.get(i).get(j);
            }
        }
    }
    
}
