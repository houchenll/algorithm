package com.hc.algorithm.main.sort;

import com.hc.algorithm.util.Tool;

/**
 * 冒泡排序
 * */
public class BubbleSort {

    /**
     * 冒泡排序，从小到大
     *
     * 算法复杂度：0~n-1上n个数，0~n-2上n-1个数，是一个等差数列，求和得an^2 + bn + c，去掉低阶项、常数项、高阶项系数，
     * 又因为每次操作是常数时间，记为O(1)，故算法复杂度为O(n^2)
     *
     * 在工程上不再使用
     * */
    public static void bubbleSort(int[] array) {
        if (null == array || array.length < 2) {
            return;
        }

        for (int end = array.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (array[i] > array[i + 1])
                    Tool.swap(array, i, i + 1);
            }
        }
    }

}
