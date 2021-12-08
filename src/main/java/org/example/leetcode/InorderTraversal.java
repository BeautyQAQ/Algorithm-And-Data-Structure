package org.example.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.example.common.TreeNode;

/**
 * No.94 二叉树的中序遍历
 * 
 * 标记,未弄清楚
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        while (root!=null || !stack.isEmpty()) {
            while (root!=null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode top = stack.pop();
            res.add(top.val);
            root = top.right;
        }
        return res;
    }
}
