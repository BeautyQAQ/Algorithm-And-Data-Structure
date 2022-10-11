package org.example.sort;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {5, 12, 23, 43, 66, 98, 100};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(arr, 23));
    }

    /**
     * 循环实现二分查找
     *
     * @param arr 数组
     * @param key 查找值
     * @return 下标
     */
    public int binarySearch(int[] arr, int key) {
        //第一个下标
        int low = 0;
        //最后一个下标
        int high = arr.length - 1;
        int mid;
        //防越界
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }
        while (low <= high) {
            // >>> 1 等效于 /2 性能更好
            mid = (low + high) >>> 1;
            if (key < arr[mid]) {
                high = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
