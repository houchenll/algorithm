package com.hc.algorithm.main.sort;

import com.hc.algorithm.util.Tool;

/**
 * 选择排序
 * */
public class SelectionSort {

    /**
     * 选择排序，从小到大
     *
     * 算法复杂度：O(n^2)
     *
     * 在工程上不再使用
     * */
    public static void selectionSort(int[] array) {
        if (null == array || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                minIndex = array[j] < array[minIndex] ? j : minIndex;
            }
            Tool.swap(array, i, minIndex);
        }
    }

}
