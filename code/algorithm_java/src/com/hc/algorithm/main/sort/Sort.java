package com.hc.algorithm.main.sort;

/**
 * 排序算法
 *
 * O(N^2)
 * 冒泡排序
 * 选择排序，不稳定
 * 插入排序
 *
 * O(N logN)
 * 归并排序
 * 快速排序，不稳定
 * 堆排序，不稳定
 * 希尔排序，不稳定
 *
 * O(n + k)
 * 计数排序
 * 桶排序
 *
 * O(n * k)
 * 基数排序
 */
public interface Sort {

    void sort(int[] nums);

}
