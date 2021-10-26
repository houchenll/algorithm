package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2040
 * 亲和数
 * 12min 8:47 - 8:59
 * */
public class P2040 {

    // 真约数真除了自身之外的约数
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        while (m-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();

            if (getSum(a) == b && a == getSum(b)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        in.close();
    }

    // 求一个数的真约数之和
    private static int getSum(int num) {
        int sum = 0;

        if (num > 1) {
            for (int i = 1; i < num; i++) {
                if (num % i == 0) {
                    sum += i;
                }
            }
        }

        return sum;
    }

}
