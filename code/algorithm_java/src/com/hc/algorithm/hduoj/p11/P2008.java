package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2008
 * 数值统计
 * 统计给定的n个数中，负数、零和正数的个数。
 * 输入数据有多组，每组占一行，每行的第一个数是整数n（n<100），表示需要统计的数值的个数，然后是n个实数；如果n=0，则表示输入结束，该行不做处理。
 * 对于每组输入数据，输出一行a,b和c，分别表示给定的数据中负数、零和正数的个数。
 * */
public class P2008 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) continue;
            int fu = 0;
            int zero = 0;
            int positive = 0;
            while (n > 0) {
                double value = in.nextDouble();
                if (value > 0) {
                    positive++;
                } else if (value == 0) {
                    zero++;
                } else {
                    fu++;
                }
                n--;
            }
            System.out.println(fu + " " + zero + " " + positive);
        }
        in.close();
    }

}
