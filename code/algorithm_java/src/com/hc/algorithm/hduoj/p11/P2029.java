package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2029
 * Palindromes _easy version
 * 回文
 * 11:21 - 答案错误
 * */
public class P2029 {

    /**
     * 回文前后段一样，只需比较一半即可
     * 奇数中间字符不用比较
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) break;

            while (n > 0) {
                String text = in.nextLine();
                int len = text.length();
                if (len == 0) continue;
                int half = len / 2;

                boolean isPalindrome = true;
                for (int i = 0; i < half; i++) {
                    if (text.charAt(i) != text.charAt(len - 1 - i)) {
                        isPalindrome = false;
                        break;
                    }
                }

                if (isPalindrome) {
                    System.out.println("yes");
                } else {
                    System.out.println("on");
                }

                n--;
            }
        }
        in.close();
    }

}
