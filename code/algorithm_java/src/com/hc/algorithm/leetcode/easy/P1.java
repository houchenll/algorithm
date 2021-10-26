package com.hc.algorithm.leetcode.easy;

import com.hc.algorithm.util.PrintUtil;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/
 * 1. Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 * */
public class P1 {

    public static void main(String[] args) {
        P1 p = new P1();
        int [] result = p.twoSum(new int[] {2,7,11,15}, 9);
//        int [] result = p.twoSum(new int[] {3,2,4}, 6);
//        int [] result = p.twoSum(new int[] {3,3}, 6);
        PrintUtil.printIntArray(result);
    }

    public int[] twoSum(int[] nums, int target) {
//        return forceSolution(nums, target);
        return hashSolution(nums, target);
    }

    /**
     * 暴力解法
     * */
    private int [] forceSolution(int[] nums, int target) {
        int[] indices = {0, 0};
        // 从第1个数字到倒数第2个数字，逐个遍历
        for (int i = 0; i < nums.length - 1; i++) {
            // 从第i+1个数字，到最后一个数字，逐个遍历
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }
        return indices;
    }

    private int[] hashSolution(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> table = new HashMap<>(len - 1);
        table.put(nums[0], 0);
        for (int i = 1; i < len; i++) {
            int second = target - nums[i];
            if (table.containsKey(second)) {
                return new int[]{table.get(second), i};
            }
            table.put(nums[i], i);
        }
        return new int[]{};
    }

}
