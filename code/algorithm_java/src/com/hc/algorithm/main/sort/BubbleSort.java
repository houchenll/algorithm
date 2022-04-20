package com.hc.algorithm.main.sort;

import com.hc.algorithm.util.Tool;

/**
 * 冒泡排序
 */
public class BubbleSort implements Sort {

    /**
     * 冒泡排序，从小到大
     *
     * 算法复杂度：0~n-1上n个数，0~n-2上n-1个数，是一个等差数列，求和得an^2 + bn + c，去掉低阶项、常数项、高阶项系数，
     * 又因为每次操作是常数时间，记为O(1)，故算法复杂度为O(n^2)
     *
     * 在工程上不再使用
     */
    @Override
    public void sort(int[] nums) {
        if (null == nums || nums.length < 2) {
            return;
        }

        for (int end = nums.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (nums[i] > nums[i + 1])
                    Tool.swap(nums, i, i + 1);
            }
        }
    }

}
