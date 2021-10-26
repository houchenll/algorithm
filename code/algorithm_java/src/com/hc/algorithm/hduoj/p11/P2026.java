package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2026
 * 首字母变大写
 * 12min 10:38 - 10:50
 */
public class P2026 {

    /**
     * 遍历每个字符，空格结束后的第一个字母变大写
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String line = in.nextLine();
            int len = line.length();

            boolean isBlank = true;  // 是否遇到空格，默认为true，用于处理第1个字符
            for (int i = 0; i < len; i++) {
                char letter = line.charAt(i);

                // 空白字符
                if (letter == ' ') {
                    isBlank = true;
                    System.out.print(letter);
                    continue;
                }

                // 普通字符，如果前一个字符是空白字符，变大写
                if (isBlank) {
                    System.out.print((char) (letter - 32));
                } else {
                    System.out.print(letter);
                }
                isBlank = false;
            }
            System.out.println();
        }
        in.close();
    }

}
