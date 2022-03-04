package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2020
 * 绝对值排序
 * 输入n(n<=100)个整数，按照绝对值从大到小排序后输出。题目保证对于每一个测试实例，所有的数的绝对值都不相等。
 * */
public class HD2020 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) break;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = in.nextInt();

            /// 插入排序，从小到大排序
            for (int i = 1; i < n; i++) {
                for (int j = i - 1; j >= 0 && Math.abs(arr[j]) > Math.abs(arr[j + 1]); j--)
                    swap(arr, j, j + 1);
            }

            // 从大到小输出
            for (int i = n - 1; i >= 1; i--)
                System.out.print(arr[i] + " ");
            System.out.println(arr[0]);
        }
        in.close();
    }

    public static void swap(int[] array, int i, int j) {
        if (i == j) return;

        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

}
