package com.hc.algorithm.main.array;

/**
 * 35. 搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/
 * tag_easy, tag_array
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class P35SearchInsertPosition {

    public static void main(String[] args) {
        P35SearchInsertPosition p35 = new P35SearchInsertPosition();
        int[] nums = new int[]{1};
        int target = 0;
        int index = p35.searchInsert(nums, target);
        System.out.println(index);
    }

    public int searchInsert(int[] nums, int target) {
        return mySolution1(nums, target);
    }

    /**
     * 方法1：二分查找
     * 定义两个标志left, right表示查询数组的范围
     * 每次取查询数组中间位置，判断是否等于target
     * 如果小于，left置为中间位置加1；如果大于，right置为中间位置减1
     * 终止条件：
     * 数组5项，0-4，中间位置是(0+4)/2，(left+right)/2
     * 数组4项，0-3，中间位置是(0+3)/2=1，(left+right)/2
     * 数组2项，0-1，中间位置是0
     * 数组1项，0，如果等于target，返回0，如果小于，返回1，如果大于，返回0
     * 数组不会为空
     * 0ms > 100%
     * 38MB > 62.49%
     */
    private int mySolution1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int m = (left + right) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                right = m - 1;
            } else {
                left = m + 1;
            }
        }
        if (nums[left] >= target) {
            return left;
        } else {
            return left + 1;
        }
    }

    /**
     * 官方示例解法：二分查找
     * 区别：对只有一个left==right，只有一个元素时的处理不同
     * 官方解法把这种情况也纳入while循环，使用同样的逻辑处理，处理后如果不等于target会破坏循环处理跳出循环，返回left即可
     */
    private int officialSolution(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

}
