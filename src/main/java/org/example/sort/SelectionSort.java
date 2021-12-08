package org.example.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        // 只需要修改成对应的方法名就可以了
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * Description: 选择排序
     *
     * @param array
     * @return void
     * @author JourWon
     * @date 2019/7/11 23:31
     */
    public void selectionSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            // 保存最小数的索引
            int minIndex = i;

            for (int j = i + 1; j < length; j++) {
                // 找到最小的数
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // 交换元素位置
            if (i != minIndex) {
                swap(array, minIndex, i);
            }
        }

    }

    /**
     * Description: 交换元素位置
     *
     * @param array
     * @param a
     * @param b
     * @return void
     * @author JourWon
     * @date 2019/7/11 17:57
     */
    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}