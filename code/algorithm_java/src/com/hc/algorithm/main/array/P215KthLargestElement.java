package com.hc.algorithm.main.array;

import com.hc.algorithm.util.Tool;

import java.util.Random;

/**
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class P215KthLargestElement {

    private final Random random = new Random();

    public static void main(String[] args) {
        P215KthLargestElement p215 = new P215KthLargestElement();
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(p215.findKthLargest(nums, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        return solution1(nums, k);
    }

    /**
     * 官方解法1：基于快速排序的选择方法（快速选择法）
     * 1. 快速排序后选择倒数第k个元素返回
     * 2. 优化：每次快排后，如果分界序号小于倒数第k个，在右侧继续倒排，如果大于，在左侧快排，如果相等，直接返回当前元素
     * 3. 优化：快排时，随机取元素作为标准
     * 4. 快排：把随机标的放到最后，然后遍历前面所有元素，小于等于标的时，移到左边。最后所有小于等于标的的元素都移到了左边
     * 5. 边界：最后把标的元素移到到小于等于它的元素的尾部，然后返回标的元素位置即可
     * 2ms > 83.36%
     * 38.7MB > 61.96%
     */
    private int solution1(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    /**
     * 对[l,r]区间内的数组快排一次，得到分界点元素的序号q，判断是否等于index
     * 等于时返回nums[q]，小于时快排[q+1,r]，大于时快排[l,q-1]
     */
    private int quickSelect(int[] nums, int l, int r, int index) {
        int q = randomPartition(nums, l, r);
        if (q == index) {
            return nums[q];
        } else if (q > index) {
            return quickSelect(nums, l, q - 1, index);
        } else {
            return quickSelect(nums, q + 1, r, index);
        }
    }

    /**
     * 在[l,r]内任取一个序号处元素，移到尾部
     * 然后对[l,r]区间内的数组快排一次，找到分界点元素的序号
     */
    private int randomPartition(int[] nums, int l, int r) {
        // 从[l,r]内任取一个元素i
        int i = random.nextInt(r - l + 1) + l;
        // 把任取元素移到数组尾部，方便后续遍历数组时比较大小
        Tool.swap(nums, i, r);
        return partition(nums, l, r);
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
        // 把锚点元素移到小于等于它的元素的尾部
        i++;
        Tool.swap(nums, i, r);
        // 最后返回锚点元素的位置
        return i;
    }

}
