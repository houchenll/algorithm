package com.hc.algorithm.main.sort;

/**
 * 归并排序
 * O(N logN)
 * 63 365 ns
 */
public class MergeSort implements Sort {

    @Override
    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * 递归
     */
    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            // 只有1个或无元素
            return;
        }
        // 有2个或以上元素
        int mid = l + (r - l) / 2;
        // 对左、右子区间递归排序
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        // 把排序好的左、右子区间合并
        merge(nums, l, mid, r);
    }

    /**
     * 合并数组中的两个有序区间[l, mid], [mid + 1, r]
     */
    private void merge(int[] nums, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];

        // 复制nums到tmp
        for (int i = l; i <= r; i++) {
            tmp[i - l] = nums[i];
        }

        // i和j指向两个有序区间的起始位置
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                // 左半部分已取完，取右侧值
                nums[k] = tmp[j - l];
                j++;
            } else if (j > r) {
                // 右半部分已取完，取左侧值
                nums[k] = tmp[i - l];
                i++;
            } else if (tmp[i - l] < tmp[j - l]) {
                // 左侧小，取左侧值
                nums[k] = tmp[i - l];
                i++;
            } else {
                // 右侧小，取右侧值
                nums[k] = tmp[j - l];
                j++;
            }
        }
    }

}
