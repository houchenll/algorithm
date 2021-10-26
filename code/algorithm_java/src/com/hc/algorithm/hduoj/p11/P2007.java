package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2007
 * 平方和与立方和
 * 给定一段连续的整数，求出他们中所有偶数的平方和以及所有奇数的立方和。
 * 输入数据包含多组测试实例，每组测试实例包含一行，由两个整数m和n组成。
 * 对于每组输入数据，输出一行，应包括两个整数x和y，分别表示该段连续的整数中所有偶数的平方和以及所有奇数的立方和。
 * 你可以认为32位整数足以保存结果。
 */
public class P2007 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int start = in.nextInt();
            int end = in.nextInt();

            // 两个数字的大小不确定，可能左侧是大数
            int tmp;
            if (start > end) {
                tmp = end;
                end = start;
                start = tmp;
            }

            int sumO = 0;
            int sumJ = 0;
            for (int i = start; i <= end; i++) {
                if (i % 2 == 0) {
                    sumO += i * i;
                } else {
                    sumJ += i * i * i;
                }
            }
            System.out.println(sumO + " " + sumJ);
        }
        in.close();
    }

}
