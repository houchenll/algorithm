package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2021
 * 发工资咯：）
 * */
public class P2021 {

    /**
     * 100元、50元、10元、5元、2元和1元六种
     * 思路：
     * 每位老师工资s，从100元到1元逐个尝试，如果s<100，继续向右，直到找到 s>=的那个单位u，然后计算余数u-s，
     * 对余数再次从左到右尝试
     * 即，对每位老师的工资，先用大钱，再用小钱
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) break;

            int count = 0;
            while (n > 0) {
                int s = in.nextInt();  // 老师的工资

                while (s > 0) {
                    if (s >= 100) {
                        s -= 100;
                    } else if (s >= 50) {
                        s -= 50;
                    } else if (s >= 10) {
                        s -= 10;
                    } else if (s >= 5) {
                        s -= 5;
                    } else if (s >= 2) {
                        s -= 2;
                    } else {
                        s -= 1;
                    }
                    count++;
                }

                n--;  // 继续下一个老师
            }
            System.out.println(count);
        }
        in.close();
    }

}
