package com.hc.algorithm.leetcode;

/**
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 * tag_easy, tag_array
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class P53MaximumSubArray {

    public static void main(String[] args) {
        P53MaximumSubArray p53 = new P53MaximumSubArray();
        int[] nums = new int[]{-11};
        int maxSum = p53.maxSubArray(nums);
        System.out.println(maxSum);
    }

    public int maxSubArray(int[] nums) {
        return officialSolution2(nums);
    }

    // 无思路

    /**
     * 官方解法1：贪心算法
     * 当之前和为负时丢弃
     * 记录之前和与最大和
     * 1ms > 92.97%
     * 48.6MB > 15.25%
     */
    private int officialSolution1(int[] nums) {
        int maxSum = nums[0];
        int preSum = 0;

        for (int num : nums) {
            int currentSum = num;
            if (preSum > 0) {
                currentSum += preSum;
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            preSum = currentSum;
        }

        return maxSum;
    }

    /**
     * 官方解决2：动态规划
     * i表示数组下标，f(i)表示以i结尾的最大子序和，求出f(i)的最大值即可
     * f(i)=max(f(i-1)+nums[i], nums[i])
     * 对nums[i]来说，如果f(i-1)大于0，加入f(i-1)所属的组，可使自身变大，所以加入f(i-1)
     * 否则nums[i]作为新组的开始
     * 1ms > 93.37%
     * 48.7MB > 7.09%
     */
    private int officialSolution2(int[] nums) {
        int pre = 0, maxSum = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxSum = Math.max(pre, maxSum);
        }
        return maxSum;
    }

}
