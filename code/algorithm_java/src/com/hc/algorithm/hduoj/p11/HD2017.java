package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2017
 * 字符串统计
 * 对于给定的一个字符串，统计其中数字字符出现的次数。
 * 输入数据有多行，第一行是一个整数n，表示测试实例的个数，后面跟着n行，每行包括一个由字母和数字组成的字符串。
 * */
public class HD2017 {

    /**
     * 对每个字符串，遍历，每个字符转为int值，与0到9的int比对大小
     * */
    public static void main(String[] args) {
        final int zero = '0';
        final int nine = '9';

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n > 0) {
            String text = in.next();
            int len = text.length();

            int count = 0;
            for (int i = 0; i < len; i++) {
                int letter = text.charAt(i);
                if (letter >= zero && letter <= nine) count++;
            }
            System.out.println(count);

            n--;
        }
        in.close();
    }

}
