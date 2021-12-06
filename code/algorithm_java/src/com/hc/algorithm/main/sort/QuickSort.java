package com.hc.algorithm.main.sort;

import com.hc.algorithm.util.Tool;

/**
 * 快速排序
 */
public class QuickSort implements Sort {

    @Override
    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    /**
     * 分治算法
     * 分解：把数组a[l,r]划分为a[l,q-1]和a[q+2,r]两部分，前一部分都小于等于a[q]，后一部分都大于等于a[q]
     * 解决：通过递归调用，分别对a[l,q-1]和a[q+1,r]进行快速排序
     * 合并：因为子数组都是原址排序的，所以不需要进行合并
     * 划分：从子数组a[l,r]中任选一个元素x，作为主元，调用子数组，使小于等于x的元素都们于它左边，大于等于它的元素
     * 都位于它的右边，最终x的位置就是q
     */
    private void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int q = partition(nums, l, r);
            quickSort(nums, l, q - 1);
            quickSort(nums, q + 1, r);
        }
    }

    /**
     * 对[l,r]区间内数组快排一次，找到分界点元素的序号
     */
    private int partition(int[] nums, int l, int r) {
        // i 表示小于等于锚点元素的最后一个元素的位置，初始在当前数组左边，l-1
        int i = l - 1;
        // 遍历数组内除最后一个元素外所有元素，与最后一个元素比较
        for (int j = l; j < r; j++) {
            // 如果小于等于最后一个元素，就与第一次大于最后一个元素的元素交换位置，保证遍历结束后，小于等于锚点元素的数都在左边，大于的都在右边
            if (nums[j] <= nums[r]) {
                i++;
                Tool.swap(nums, i, j);
            }
        }
        // 把锚点元素移到小于等于它的元素的尾部的下一位，即第一次大于最后一个元素的元素的位置
        i++;
        Tool.swap(nums, i, r);
        // 最后返回锚点元素的位置
        return i;
    }
}