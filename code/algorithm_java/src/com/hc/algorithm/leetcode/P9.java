package com.hc.algorithm.leetcode;

import com.hc.algorithm.main.basic.NumberAlgorithm;

/**
 * https://leetcode.com/problems/palindrome-number/
 * 9. Palindrome Number 回文
 * Given an integer x, return true if x is palindrome integer.
 * An integer is a palindrome when it reads the same backward as forward. For example,
 * 121 is palindrome while 123 is not.
 * */
public class P9 {

    public static void main(String[] args) {
        P9 p9 = new P9();
        System.out.println(p9.isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
//        return reverseSolution(x);
        return officialSolution(x);
    }

    // 6ms 38.4 MB
    private boolean reverseSolution(int x) {
        if (x < 0) return false;
        else {
            int num = x;
            int rev = 0;
            while (x != 0) {
                int pop = x % 10;
                x /= 10;
                if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && pop > 7) return false;
                rev = rev * 10 + pop;
            }
            return rev == num;
        }
    }

    /**
     * Revert half of the number
     * 方法1：先转成字符串，再判断字符串是否回文。此方法不被题设允许
     * 方法2：对数字本身翻转，再与原数字比较
     * 方法3：基于方法2，只对数字后半段翻转，与原数字前半段比较。既节省时间，也避免溢出int范围
     * 处理边界和特殊值：负数全不是回文
     * 何时翻转了一半：当翻转得到的数字大于等于原数字时，已翻转了一半
     * */
    private boolean officialSolution(int x) {
        return NumberAlgorithm.isPalindrome(x);
    }

}
