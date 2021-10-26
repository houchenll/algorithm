package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2015
 * 偶数求和
 * 有一个长度为n(n<=100)的数列，该数列定义为从2开始的递增有序偶数，现在要求你按照顺序每m个数求出一个平均值，如果最后不足m个，则以实际数量求平均值。编程输出该平均值序列。
 * 输入数据有多组，每组占一行，包含两个正整数n和m，n和m的含义如上所述。
 * 对于每组输入数据，输出一个平均值序列，每组输出占一行。
 * */
public class P2015 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();

            int num = 0;
            int i = 1;
            int sum = 0;
            while (i <= n) {
                num += 2;
                sum += num;

                // 当i是m整数倍时，计算平均值，输出平均值，重置sum
                if (i % m == 0) {
                    if (i < n) {
                        System.out.print(sum / m + " ");
                    } else {
                        System.out.println(sum / m);
                    }
                    sum = 0;
                }

                i++;
            }
            if (sum > 0) {
                System.out.println(sum / (n % m));
            }
        }
        in.close();
    }

}
