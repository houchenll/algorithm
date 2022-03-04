package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2043
 * 密码
 * 15min 10:36 - 10:51
 * */
public class HD2043 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        while (m-- > 0) {
            String password = in.next();
            boolean isSafe = isPasswordSafe(password);
            System.out.println(isSafe ? "YES" : "NO");
        }
        in.close();
    }

    // 判断字符串是否是安全密码
    // 先判断长度，8 <= l <= 16
    // 再遍历各字符，看是否属于某一类别
    // 时间复杂度：O(N),N是字符串长度
    // 空间复杂度：O(1)，只需定义常数个变量
    private static boolean isPasswordSafe(String password) {
        boolean isSafe = false;

        if (password != null && password.length() >= 8 && password.length() <= 16) {
            int len = password.length();
            boolean hit1 = false, hit2 = false, hit3 = false, hit4 = false;
            int type = 0;
            String fourType = "~!@#$%^";
            for (int i = 0; i < len; i++) {
                char letter = password.charAt(i);
                if (letter >= 'A' && letter <= 'Z') {
                    if (!hit1) {
                        hit1 = true;
                        type++;
                    }
                } else if (letter >= 'a' && letter <= 'z') {
                    if (!hit2) {
                        hit2 = true;
                        type++;
                    }
                } else if (letter >= '0' && letter <= '9') {
                    if (!hit3) {
                        hit3 = true;
                        type++;
                    }
                } else if (fourType.contains(String.valueOf(letter))) {
                    if (!hit4) {
                        hit4 = true;
                        type++;
                    }
                }
            }
            isSafe = type >= 3;
        }

        return isSafe;
    }

}
