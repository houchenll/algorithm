package com.hc.algorithm.main.array;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，
 * 并按照红色、白色、蓝色顺序排列。我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库的sort函数的情况下解决这个问题。
 */
public class P75SortColors {

    public void sortColors(int[] nums) {
        // 只有两个元素时，也需要排序
        if (null == nums || nums.length < 2) {
            return;
        }
        int len = nums.length;

        // [0, p0) == 0
        // [p0, i) == 1
        // (p2, len -1) == 2
        // 初始各区间为空
        int p0 = 0;
        int i = 0;
        int p2 = len - 1;

        while (i <= p2) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, p2);
                p2--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
