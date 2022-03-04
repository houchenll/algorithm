package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2030
 * 统计给定文本文件中汉字的个数。
 * 7min 2:20 - 2:27
 * */
public class HD2030 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) break;

            while (n > 0) {
                String line = in.nextLine();
                int len = line.length();
                if (len == 0) continue;

                int count = 0;
                for (int i = 0; i < len; i++) {
                    char letter = line.charAt(i);
                    if (letter > 256) {
                        count++;
                    }
                }
                System.out.println(count);

                n--;
            }
        }
        in.close();
    }

}
