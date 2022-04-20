package com.hc.algorithm.main.sort;

import com.hc.algorithm.util.Tool;

/**
 * 选择排序
 */
public class SelectionSort implements Sort {

    /**
     * 选择排序，从小到大
     * 算法复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 在工程上不再使用
     */
    @Override
    public void sort(int[] array) {
        if (null == array || array.length < 2) {
            return;
        }

        // 遍历[i, len -1]的所有元素，找到最小元素的下标
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                minIndex = array[j] < array[minIndex] ? j : minIndex;
            }
            Tool.swap(array, i, minIndex);
        }
    }
}
