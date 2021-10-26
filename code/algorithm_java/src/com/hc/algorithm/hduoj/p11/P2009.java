package com.hc.algorithm.hduoj.p11;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2009
 * 求数列的和
 * 数列的定义如下：数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
 * 输入数据有多组，每组占一行，由两个整数n（n<10000）和m(m<1000)组成，n和m的含义如前所述。
 * 对于每组输入数据，输出该数列的和，每个测试实例占一行，要求精度保留2位小数。
 * */
public class P2009 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();

            double sum = 0;
            double cur = n * n;
            while (m > 0) {
                cur = Math.sqrt(cur);
                sum += cur;
                m--;
            }
            System.out.println(new DecimalFormat(".00").format(sum));
        }
        in.close();
    }

}
