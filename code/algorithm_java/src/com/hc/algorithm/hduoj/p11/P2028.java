package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2028
 * Lowest Common Multiple Plus
 * 求n个数的最小公倍数。
 * 9min 11:09 - 11:18
 * */
public class P2028 {

    /**
     * 先遍历，找到最大的数，再用最大数的整数倍依次整除各数，当除数全为0时，表示是最小公倍数
     * 选最大数可以加快跳动速度
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) break;

            int[] nums = new int[n];
            int max = 0;

            // 取数，找到最大数，存储
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                nums[i] = num;
                max = Math.max(num, max);
            }

            // 遍历最大数整数倍
            int m = 1;
            while (true) {
                int num = max * m++;
                boolean isOk = true;
                for (int i = 0; i < n; i++) {
                    if (num % nums[i] != 0) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    System.out.println(num);
                    break;
                }
            }
        }
        in.close();
    }

}
