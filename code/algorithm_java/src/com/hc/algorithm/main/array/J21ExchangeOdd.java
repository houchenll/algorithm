package com.hc.algorithm.main.array;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class J21ExchangeOdd {

    // 定义一个新数组，定义两个指针，分别指向新数组的起始
    // 遍历原数组，把奇数添加到新数组头部，奇数添加到新数组尾部
    // 时间复杂度：O(N)
    // 2ms > 47%
    // 空间复杂度：O(N)
    // 40MB > 63%
    public int[] exchange(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return nums;
        }

        int len = nums.length;
        int[] array = new int[len];
        int l = 0, r = len - 1;

        for (int num : nums) {
            if (num % 2 == 0) {
                // 偶数，添加到新数组尾部
                array[r--] = num;
            } else {
                // 奇数，添加到新数组头部
                array[l++] = num;
            }
        }

        return array;
    }

    /**
     * 快速排序改编
     * 定义指针i，从左向右遍历nums；定义指定r，r之后的元素都是偶数；
     * 当i位置的元素是偶数，交换到r位置，r左移一位，因为交换过来和元素未知，所以i位置不变；
     * 当i位置的元素是奇数时，i右移一位；
     * 当i移到等于r时，停止
     * 2ms > 47%
     * 49MB > 20%
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public int[] exchange2(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return nums;
        }

        int i = 0, r = nums.length - 1;

        while (i < r) {
            if (nums[i] % 2 == 0) {
                // 偶数
                swap(nums, i, r);
                r--;
            } else {
                // 奇数
                i++;
            }
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
