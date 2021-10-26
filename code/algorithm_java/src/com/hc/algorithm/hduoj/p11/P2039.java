package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2039
 * 三角形
 * 11min 8:36 - 8:47
 */
public class P2039 {

    // 三角形任意两边之和大于第三边，且任意两边之差小于第三边
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();

        while (m-- > 0) {
            /// 题干没有说三个数是整数!!!
            double a = in.nextDouble();
            double b = in.nextDouble();
            double c = in.nextDouble();

            if (a + b > c && a + c > b && b + c > a
                    && Math.abs(a - b) < c && Math.abs(a - c) < b && Math.abs(b - c) < a) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        in.close();
    }

}
