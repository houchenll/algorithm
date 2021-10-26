package com.hc.algorithm.hduoj.p11;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2003
 * 求实数的绝对值。
 * 输入数据有多组，每组占一行，每行包含一个实数。
 * 对于每组输入数据，输出它的绝对值，要求每组数据输出一行，结果保留两位小数。
 * */
public class P2003 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double num = in.nextDouble();
            System.out.println(new DecimalFormat(".00").format(Math.abs(num)));
        }
        in.close();
    }

}
