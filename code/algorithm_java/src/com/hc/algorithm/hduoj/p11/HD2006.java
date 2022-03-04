package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/listproblem.php?vol=11
 * 求奇数的乘积
 * 给你n个整数，求他们中所有奇数的乘积。
 * 输入数据包含多个测试实例，每个测试实例占一行，每行的第一个数为n，表示本组数据一共有n个，接着是n个整数，你可以假设每组数据必定至少存在一个奇数。
 * 输出每组数中的所有奇数的乘积，对于测试实例，输出一行。
 * */
public class HD2006 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int mul = 1;
            while (n > 0) {
                int value = in.nextInt();
                if (value % 2 != 0) {
                    mul *= value;
                }
                n--;
            }
            System.out.println(mul);
        }
        in.close();
    }

}
