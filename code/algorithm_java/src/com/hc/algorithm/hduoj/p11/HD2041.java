package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2041
 * 超级楼梯
 * */
public class HD2041 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- > 0) {
            System.out.println(step(in.nextInt()));
        }
        in.close();
    }

    // 递归
    // 0: m = 1, 1: m = 2, 2: m = 3
    private static int step(int m) {
        if (m == 1) {
            return 0;
        } else if (m == 2) {
            return 1;
        } else if (m == 3) {
            return 2;
        } else {
            /// 走到第m个台阶，有两种方法，跨1个台阶，或跨2个台阶，所以
            return step(m - 1) + step(m - 2);
        }
    }

}
