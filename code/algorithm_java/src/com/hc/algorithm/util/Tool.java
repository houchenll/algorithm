package com.hc.algorithm.util;

public class Tool {

    /**
     * 交换整形数组中序号为i和j的两个数
     *
     * i==j时，不必交换
     */
    public static void swap2(int[] array, int i, int j) {
        if (i == j) return;

        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * 交换整形数组中序号为i和j的两个数
     *
     * 注意：如果i==j，使用这种方法交换，会导致i位置的数字变为0。所以当i==j时，必须停止交换
     */
    public static void swap(int[] array, int i, int j) {
        if (i == j) return;

        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

}
