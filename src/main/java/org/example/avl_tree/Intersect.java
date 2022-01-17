package org.example.avl_tree;

import java.util.ArrayList;

/**
 * No.350 两个数组的交集 II
 * 
 * 给你两个整数数组 nums1 和 nums2
 * ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * 
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * 
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        AVLTree<Integer, Integer> map = new AVLTree<>();
        for (int num : nums1) {
            if (!map.contains(num)) {
                map.add(num, 1);
            }else{
                map.add(num, map.get(num)+1);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (Integer num : nums2) {
            if (map.contains(num)) {
                res.add(num);
                map.add(num, map.get(num)-1);
                if (map.get(num)==0) {
                    map.remove(num);
                }
            }
        }

        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        Intersect intersect = new Intersect();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] res = intersect.intersect(nums1, nums2);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
