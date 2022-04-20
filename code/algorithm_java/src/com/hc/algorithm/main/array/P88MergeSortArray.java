package com.hc.algorithm.main.array;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
public class P88MergeSortArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

    }

    // 没有思路

    /**
     * 官方解法1：先合并再排序
     * 时间复杂度：快速排序的时间复杂度(O((m+n)log(m+n)))
     * 空间复杂度：快速排序的空间复杂度(O(log(m+n)))
     * 0ms
     */
    private void solution1(int[] nums1, int m, int[] nums2, int n) {
        // 合并
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        // 快速排序
        Arrays.sort(nums1);
    }

    /**
     * 官方解法2：双指针
     * 定义另一个长为m+n的数组sorted，遍历两个数组，取小者放到sorted尾部
     * 最后再把sorted复制到nums1
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(m+n)
     * 0ms
     */
    private void solution2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int cur;
        int[] sorted = new int[m + n];
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = sorted[i];
        }
    }

    /**
     * 官方解法3：逆向双指针
     * 方法2中，之所以要使用临时变量，是因为直接合并到数组nums1中，数组nums1中的元素可能会在取出之前被覆盖
     * 观察可知，nums1的后半段是空的，可以直接覆盖而不会影响结果，因此可以指针设置为从右向左遍历，每次取两者
     * 之中的大者放在数组尾部
     * 证明可知， p_1后面的位置永远足够容纳被插入的元素，不会产生 p_1的元素被覆盖的情况
     */
    private void solution3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

    /**
     * 同花顺面试时实现
     */
    public int[] mergeSortedArray(int[] nums1, int[] nums2) {
        if (null == nums1 || nums1.length == 0) {
            return nums2;
        }
        if (null == nums2 || nums2.length == 0) {
            return nums1;
        }

        int len = nums1.length + nums2.length;
        int[] result = new int[len];

        int indexA = 0, indexB = 0;
        int indexResult = 0;

        while (indexA < nums1.length && indexB < nums2.length) {
            int num;
            if (nums1[indexA] <= nums2[indexB]) {
                num = nums1[indexA];
                indexA++;
            } else {
                num = nums2[indexB];
                indexB++;
            }
            result[indexResult] = num;
            indexResult++;
        }

        if (indexA < nums1.length) {
            for (int i = indexA; i < nums1.length; i++) {
                result[indexResult++] = nums1[i];
            }
        } else if (indexB < nums2.length) {
            for (int i = indexB; i < nums2.length; i++) {
                result[indexResult++] = nums2[i];
            }
        }

        return result;
    }

}
