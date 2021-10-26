package com.hc.algorithm.main.sort;

import com.hc.algorithm.util.Tool;

/**
 * 插入排序
 * */
public class InsertionSort {

    /**
     * 插入排序，从小到大
     * */
    public static void insertionSort(int[] array) {
        if (null == array || array.length < 2) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; j--)
                Tool.swap2(array, j, j + 1);
        }
    }

}
