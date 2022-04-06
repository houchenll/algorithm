package com.hc.algorithm.main.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 时间复杂度：O(n * n!)
 * 空间复杂度：O(n * n!)
 */
public class P46Permutations {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = new P46Permutations().solution1(nums);
        for (List<Integer> arr : result) {
            for (Integer num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        return solution1(nums);
    }

    /**
     * 回溯算法的入门问题
     */
    private List<List<Integer>> solution1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 边界检查
        if (null == nums || nums.length == 0) {
            return result;
        }

        final int len = nums.length;

        // 初始化状态变量
        int depth = 1;  // 当前正在添加的节点的层次，也等于path中节点个数
        Deque<Integer> path = new ArrayDeque<>();  // 记录已添加数字
        boolean[] status = new boolean[len];  // 标记哪些数字已被添加

        // 深度优化遍历各种可能，添加到结果集中
        dfs(nums, depth, path, status, len, result);

        return result;
    }

    private void dfs(int[] nums, int depth, Deque<Integer> path, boolean[] status, int len, List<List<Integer>> result) {
        // 终止条件：遍历层数等于数组长度，即path已加满
        if (depth > len) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 从nums中未添加的数字中，选择一个，添加到path中
        for (int i = 0; i < len; i++) {
            // 如果已添加到path中，跳过
            if (status[i]) {
                continue;
            }
            // 还未添加到path中，添加到path中
            path.addLast(nums[i]);
            status[i] = true;

            // 本层本节点已添加完数字，继续遍历下一层，把下一层的所有可能性都添加上
            dfs(nums, depth + 1, path, status, len, result);

            // 子节点都已添加完，该添加同层其它结点，需要退回添加本节点之前的状态
            // 回溯状态
            path.removeLast();
            status[i] = false;
        }
    }

}
