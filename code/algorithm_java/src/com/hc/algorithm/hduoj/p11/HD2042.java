package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2042
 * 不容易系列之二
 * 9:33 -
 * */
public class HD2042 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- > 0) {
            int m = in.nextInt();
            System.out.println(sheep(m));
        }
        in.close();
    }

    // 递归
    // 每到一个收费站，有m头羊，过了收费站还有 m / 2 + 1 = n
    // 过了收费站，有n头羊，过收费站前有 2 * (n - 1)头羊
    // @param n 前一个收费站羊数量
    private static int sheep(int n) {
        if (n == 0) {
            return 3;
        } else {
            return 2 * sheep(n - 1) - 2;
        }
    }

}
