package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2033
 * 人见人爱A+B
 * 14min 8:43 - 8:57
 * */
public class P2033 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) break;

            while (n-- > 0) {
                int ah = in.nextInt();
                int am = in.nextInt();
                int as = in.nextInt();
                int bh = in.nextInt();
                int bm = in.nextInt();
                int bs = in.nextInt();

                // target x
                int th = 0, tm = 0, ts = 0;

                // result x
                int rs = as + bs;
                if (rs >= 60) {
                    ts = rs - 60;
                    tm += 1;
                } else {
                    ts = rs;
                }

                int rm = tm + am + bm;
                if (rm >= 60) {
                    tm = rm - 60;
                    th += 1;
                } else {
                    tm = rm;
                }

                th = th + ah + bh;

                System.out.println(th + " " + tm + " " + ts);
            }
        }

        in.close();
    }

}
