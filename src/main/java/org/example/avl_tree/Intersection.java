package org.example.avl_tree;

import java.util.ArrayList;

/**
 * No.349 两个数组的交集
 * 
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        AVLTree<Integer, Object> set = new AVLTree<>();

        for (int num : nums1) {
            set.add(num, null);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (Integer num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] res = intersection.intersection(nums1, nums2);
        for (int i : res) {
            System.out.println(i);
        }
    }
}