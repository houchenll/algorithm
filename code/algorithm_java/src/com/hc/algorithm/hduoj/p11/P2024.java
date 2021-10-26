package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2024
 * C语言合法标识符
 * */
public class P2024 {

    /**
     * 不能数字开头，只能包含字母、数字、下划线
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n > 0) {
            String line = in.nextLine();
            if (line == null || line.length() == 0) {
                continue;
            }

            // 判断第一个字符
            char firstLetter = line.charAt(0);
            if (firstLetter >= '0' && firstLetter <= '9') {
                // 是数字，不符合要求，no
                System.out.println("no");
                n--;
                continue;
            }

            // 遍历所有字符，只能包含字母、数字、下划线
            boolean isLegal = true;
            for (int i = 0; i < line.length(); i++) {
                char letter = line.charAt(i);
                isLegal = letter >= '0' && letter <= '9'
                        || letter >= 'a' && letter <= 'z'
                        || letter >= 'A' && letter <= 'Z'
                        || letter == '_';
                if (!isLegal) {
                    break;
                }
            }
            if (isLegal) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

            n--;
        }
        in.close();
    }

}
