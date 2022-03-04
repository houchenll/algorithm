package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2032
 * 杨辉三角
 * 19min 8:23 - 8:42
 * */
public class HD2032 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) break;

            // 定义整数数组，存储上一行结果，初始长度为1，内容为1
            int[] arr = new int[]{1};
            // 遍历，执行n次
            for (int i = 1; i <= n; i++) {
                if (i == 1) {
                    printArray(arr);
                    continue;
                }

                // 生成新数组，长度为i
                int[] result = new int[i];

                // 遍历上一行，每个数取左边数字相加，存储在新数组对应位置；最左边数字直接存储；最右边数字存在新数组最后；
                int len = arr.length;
                for (int j = 0; j < len; j++) {
                    if (j == 0) {
                        result[0] = arr[0];
                    } else {
                        result[j] = arr[j] + arr[j - 1];
                    }
                }
                result[i - 1] = arr[len - 1];
                arr = result;
                printArray(arr);
            }

            System.out.println();
        }
        in.close();
    }

    private static void printArray(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (i < len - 1) {
                System.out.print(arr[i] + " ");
            } else {
                System.out.println(arr[i]);
            }
        }
    }

}
