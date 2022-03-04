package com.hc.algorithm.hduoj.p11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2018
 * 母牛的故事
 * 有一头母牛，它每年年初生一头小母牛。每头小母牛从第四个年头开始，每年年初也生一头小母牛。请编程实现在第n年的时候，共有多少头母牛？
 */
public class HD2018 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();

            if (n == 0) break;

            int cows = 1;  // 母牛数量
            int adultCows = 1;  // 成年母牛数量
            List<Integer> ages = new ArrayList<>();  // 记录所有牛的岁数，每年加1
            ages.add(5);

            /// 第n年不算
            for (int i = 1; i < n; i++) {  // 遍历年
                // 新1年开始，所有未成年牛增加1岁
                // 跳过成年牛
                for (int k = adultCows; k < ages.size(); k++) {
                    int newAge = ages.get(k) + 1;
                    ages.set(k, newAge);

                    // 如果刚刚成年，把成年牛数量加1
                    if (newAge == 4) {
                        adultCows++;
                    }
                }

                // 新1年开始，每个成年母年生1个小母牛，可得到新的总母牛数；
                cows += adultCows;   // 每年，生adultCows个小母牛

                // 并把新生母牛添加到岁数列表中
                for (int j = 0; j < adultCows; j++) {
                    ages.add(1);
                }
            }

            System.out.println(cows);
        }

        in.close();
    }

    // 方法2
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] amount = new long[54];
        amount[0] = 1;
        amount[1] = 2;
        amount[2] = 3;
        amount[3] = 4;
        for (int i = 4; i < amount.length; i++) {
            amount[i] = amount[i - 1] + amount[i - 3];
        }
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            System.out.println(amount[n - 1]);
        }
    }

}
