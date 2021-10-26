package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2000
 * ASCII码排序
 * 输入三个字符后，按各字符的ASCII码从小到大的顺序输出这三个字符。
 * 输入数据有多组，每组占一行，有三个字符组成，之间无空格。
 * 对于每组输入数据，输出一行，字符中间用一个空格分开。
 * Sample Input
 * qwe
 * asd
 * zxc
 * Sample Output
 * e q w
 * a d s
 * c x z
 * */
// 提交时，需把类名改为Main
public class P2000 {

    public static void main(String[] args) {
        // 使用Scanner输入
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();

            // charAt可直接得到int类型
            int a = str.charAt(0);
            int b = str.charAt(1);
            int c = str.charAt(2);

            // 先确定最小值，再确定次小值
            int tmp;
            if (a > b) {
                tmp = b;
                b = a;
                a = tmp;
            }
            if (a > c) {
                tmp = c;
                c = a;
                a = tmp;
            }
            if (b > c) {
                tmp = c;
                c = b;
                b = tmp;
            }

            System.out.println((char)a + " " + (char)b + " " + (char)c);
        }
        in.close();
    }

}
