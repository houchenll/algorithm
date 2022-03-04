package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2046
 * 骨牌铺方格
 * 25min 9:00 - 9:25
 * */
public class HD2046 {

    public static void main(String[] args) {
        // 递推，计算并缓存
        /// 需要使用long，当格子多时，摆法数量比int最大值还多182亿
        /// int能表达的最大正数为21.5亿
        long[] methods = new long[51];
        methods[1] = 1;
        methods[2] = 2;
        for (int i = 3; i <= 50; i++) {
            methods[i] = methods[i - 1] + methods[i - 2];
        }

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) break;
            System.out.println(methods[n]);
        }
        in.close();
    }

    // 使用递归
    // 边界：宽为1时只有1种摆法，宽为2时有2种摆法
    // 最后一格只有两种摆法：竖和横，竖摆时占1格，只有一种摆法；横摆时占两格，也只有一种摆法
    // 递归公式：place(n) = place(n-1) + place(n-2)
    // 超时
    private static long place(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return place(n - 1) + place(n - 2);
        }
    }

}
