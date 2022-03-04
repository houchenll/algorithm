package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2025
 * 查找最大元素
 * */
public class HD2025 {

    /**
     * 第一遍遍历，找到最大字母，第二遍遍历，在最大字母后插入(max)
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String text = in.next();
            int len = text.length();
            char maxLetter = 0;

            // 找到最大字符
            for (int i = 0; i < len; i++) {
                char letter = text.charAt(i);
                if (letter > maxLetter) {
                    maxLetter = letter;
                }
            }

            // 在最大字符后拼接(max)
            StringBuilder buffer = new StringBuilder();
            for (int i = 0; i < len; i++) {
                char letter = text.charAt(i);
                buffer.append(letter);
                if (letter == maxLetter) {
                    buffer.append("(max)");
                }
            }
            System.out.println(buffer.toString());
        }
        in.close();
    }

}
