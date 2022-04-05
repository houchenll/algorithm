package com.hc.algorithm.main.array;

/**
 * 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 */
public class P33SearchInRotate {

    /**
     * 数组是部分有序的，但也可以使用二分查找
     * 数组分成两部分后，找到有序部分，在有序部分判断target是否在区间中，如果在，确定left或right边界，
     * 如果不在，left或right边界在另一个区间
     * 时间复杂度：O(logN)，二分查找
     * 空间复杂度：O(1)，只使用了有限个变量
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (0 == len) {
            return -1;
        }
        if (1 == len) {
            return target == nums[0] ? 0 : -1;
        }
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            // 确定(left, mid)和(mid, right)中哪个区间是有序的
            // mid可能等于left，所以此处需要使用<=，以包含这种情况！！！
            if (nums[left] <= nums[mid]) {
                // [left, mid)是有序区间
                // 判断target是否在这个有序区间中
                if (nums[left] <= target && target < nums[mid]) {
                    // target在[left, mid)中，下次查找区间从[left, right]缩小到[left, mid -1]
                    right = mid - 1;
                } else {
                    // target不在有序区间，下次查找区间确定为[mid + 1, right]
                    left = mid + 1;
                }
            } else {
                // (mid, right]是有序区间
                // 判断target是否在这个有序区间中
                if (nums[mid] < target && target <= nums[right]) {
                    // target在有序区间(mid, right]中，下次查找区间缩小到[mid + 1, right]
                    left = mid + 1;
                } else {
                    // target不在有序区间，在无序区间[left, mid - 1)中
                    right = mid - 1;
                }
            }
        }
        // 默认返回-1，表示在[left, right]中没有找到target！！！
        return -1;
    }

}
