package com.hc.algorithm.hduoj.p11;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2002
 * 根据输入的半径值，计算球的体积。
 * 输入数据有多组，每组占一行，每行包括一个实数，表示球的半径。
 * 输出对应的球的体积，对于每组输入数据，输出一行，计算结果保留三位小数。
 * */
public class HD2002 {

    private static final double PI = 3.1415927;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double r = in.nextDouble();
            double v = 4 * PI * r * r * r / 3;
            System.out.println(new DecimalFormat(".000").format(v));
        }
        in.close();
    }

}
