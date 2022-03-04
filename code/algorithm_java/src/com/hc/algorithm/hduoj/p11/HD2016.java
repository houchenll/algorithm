package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2016
 * 数据的交换输出
 * 输入n(n<100)个数，找出其中最小的数，将它与最前面的数交换后输出这些数。
 * */
public class HD2016 {

    /**
     * 将输入数据保存在长为n的数组中
     * 遍历一遍数组，找出最小数的下标，与数组起始位置数据交换
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n <= 0) continue;

            int[] array = new int[n];
            for (int i = 0; i < n; i++) array[i] = in.nextInt();

            // 找到最小数的下标
            int pos = 0;
            int min = Integer.MAX_VALUE;
            int len = array.length;
            for (int i = 0; i < len; i++) {
                if (array[i] < min) {
                    min = array[i];
                    pos = i;
                }
            }

            // 交换位置
            if (pos != 0) {
                int tmp = array[pos];
                array[pos] = array[0];
                array[0] = tmp;
            }

            // 打印数组
            for (int i = 0; i < len; i++) {
                System.out.print(array[i]);
                if (i != len - 1) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }
        }
        in.close();
    }

}
