package org.example.leetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * No.46 全排列 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Permute {

    private List<List<Integer>> res = new LinkedList<>();

    /**
     * 回溯算法
     * 
     * @param nums 排列数组
     * @return 全排列组合
     */
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    /**
     * 回溯
     * 
     * @param nums  排列数组
     * @param track 路径标记
     */
    private void backtrack(int[] nums, List<Integer> track) {
        // 递归结束条件
        if (nums.length == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            // 添加已选择内容
            track.add(nums[i]);
            // 向下一层
            backtrack(nums, track);
            track.remove(track.size() - 1);
        }
    }
}