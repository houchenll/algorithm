package com.hc.algorithm.main.search;

/**
 * 二分查找法
 */
public class BinarySearch {

    /***
     * 在有序数组arr中，查找target，
     * 如果找到target，返回相应的索引index，
     * 如果找不到target，返回-1
     */
    int binarySearch(int[] arr, int n, int target) {
        // 在arr[l...r]之中查找target
        int l = 0, r = n - 1;
        while (l <= r) {
//            int mid = (l + r) / 2;
            // 如果l和r都是非常大的数字，它们的和可能会溢出，所以不要使用加法
            // l 加上范围/2
            int mid = l + (r - l) / 2;
            int num = arr[mid];

            if (target == num) {
                return mid;
            } else if (target < num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

}
