package com.hc.algorithm.main.sort;

import com.hc.algorithm.util.Tool;

/**
 * 插入排序
 */
public class InsertionSort implements Sort {

    /**
     * 插入排序，从小到大
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     */
    @Override
    public void sort(int[] nums) {
        if (null == nums || nums.length < 2) {
            return;
        }

        // 第1个数字有序，跳过
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--)
                Tool.swap2(nums, j, j - 1);
        }
    }

}
