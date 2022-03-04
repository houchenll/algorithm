package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2044
 * 一只小蜜蜂...
 * 29min 10:53 - 11:22
 * medium
 * */
public class HD2044 {

    public static void main(String[] args) {
        // 先准备数据
        /// 需要用long存储，int存储不下
        long[] arr = new long[51];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < 51; i++) {
            // 避免递归
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
//            System.out.println(grab(a, b));
            System.out.println(arr[b - a]);
        }
        in.close();
    }

    // 递归
    // 计算从a到b有多少种爬法
    // 爬到m有两种方法，grab(a, m) = grab(a, m -1) + grab(a, m -2)
    /// 超时!!!
    private static int grab(int a, int b) {
        if (a == b) {
            return 1;
        } else if (a == b - 1) {
            return 1;
        } else {
            return grab(a, b - 1) + grab(a, b - 2);
        }
    }

}
