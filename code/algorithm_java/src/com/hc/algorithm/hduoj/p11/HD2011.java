package com.hc.algorithm.hduoj.p11;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2011
 * 多项式求和
 * 多项式的描述如下：
 * 1 - 1/2 + 1/3 - 1/4 + 1/5 - 1/6 + ...
 * 现在请你求出该多项式的前n项的和。
 * 输入数据由2行组成，首先是一个正整数m（m<100），表示测试实例的个数，第二行包含m个正整数，对于每一个整数(不妨设为n,n<1000），求该多项式的前n项的和。
 * 对于每个测试实例n，要求输出多项式前n项的和。每个测试实例的输出占一行，结果保留2位小数。
 * */
public class HD2011 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();

        while (m > 0) {
            int n = in.nextInt();
            double sum = 0;
            for (double i = 1; i <= n; i++) {
                if (i % 2 == 0) {
                    sum += 1 / i * (-1);
                } else {
                    sum += 1 / i;
                }
            }
            System.out.println(new DecimalFormat("0.00").format(sum));

            m--;
        }

        in.close();
    }

}
