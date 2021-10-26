package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2013
 * 蟠桃记
 * */
public class P2013 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt() - 1;
            int amount = 1;
            while (n > 0) {
                amount = 2 * (amount + 1);
                n--;
            }
            System.out.println(amount);
        }
        in.close();
    }

}
