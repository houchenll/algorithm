package com.hc.algorithm.leetcode;

import com.hc.algorithm.util.PrintUtil;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/
 * 1. Two Sum
 * tag_array, tag_easy
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
public class P1TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 4};
        int target = 6;
        P1TwoSum p1 = new P1TwoSum();
        int[] result = p1.twoSum(nums, target);
        PrintUtil.printIntArray(result);
    }

    public int[] twoSum(int[] nums, int target) {
//        return solution1(nums, target);
        return solution2(nums, target);
    }

    /**
     * 暴力解法，双重遍历
     * 78 ms (faster than 18.14%), 41.7 MB (less than 43.92%)
     */
    private int[] solution1(int[] nums, int target) {
        // 从左向右遍历数组，对每次遍历取到的数，再遍历它右边的所有数，和它相加，检查是否等于target，等于时返回它们的序号
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    /**
     * 使用hash map加速查找
     * 1 ms, faster than 99.67%, 39.3 MB, less than 62.22%
     * */
    private int[] solution2(int[] nums, int target) {
        // 考虑到暴力解法速度慢的原因是查找target-nums[i]太慢导致的，我们使用hashMap来加速，使这个查找从O(N)降低到O(1)
        // 遍历数组，对每个数字，查看map中是否有target-nums[i]，如果有，直接返回他们的序号，如果没有，把这个数字和它的序号加到map
        // 理解：
        // 1. 使用map在O(1)时间内完成了查找target-nums[i]
        // 2. 遍历数组每个数字时，它们和之前遍历的数字比较，看能不能相加等于target
        // 3. 先比较，先添加到map，避免了自己和自己相加等于target，也避免了两个相同的数字序号不同相加等于target时无法处理的问题
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

}
