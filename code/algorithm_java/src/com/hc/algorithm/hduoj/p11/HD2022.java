package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2022
 * 海选女主角
 * */
public class HD2022 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int max = 0;
            int row = 0;
            int col = 0;
            int maxScore = 0;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <=m; j++) {
                    int score = in.nextInt();
                    if (Math.abs(score) > max) {
                        max = Math.abs(score);
                        row = i;
                        col = j;
                        maxScore = score;
                    }
                }
            }
            System.out.println(row + " " + col + " " + maxScore);
        }
        in.close();
    }

}
