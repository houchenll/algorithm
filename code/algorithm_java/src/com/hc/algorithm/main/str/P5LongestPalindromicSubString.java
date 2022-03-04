package com.hc.algorithm.main.str;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class P5LongestPalindromicSubString {

    public String longestPalindrome(String s) {
        return "";
    }

    /**
     * 方法1：动态规划
     * 子串p[i,j]是回文串等价于p[i]==p[j]&&p[i+1, j-1]是回文串
     * 314ms > 11.78%
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(N^2)，状态表
     */
    private String solution1(String s) {
        // 特殊情况
        if (null == s) {
            return null;
        }
        int len = s.length();
        if (len < 2) {
            return s;
        }

        // 记录最长回文串的长度和它的左边界
        int maxLen = 1;
        int begin = 0;

        // 定义动态规划状态表格，state[i][j]表示p[i,j]是否是回文串
        boolean[][] state = new boolean[len][len];
        // 初始化状态表格，对角线表示所有长度为1的子串，它们是回文串
        for (int i = 0; i < len; i++) {
            state[i][i] = true;
        }

        // 从短到长遍历所有子串，判断它们是否是回文串，长串依赖于前序短子串的判断结果
        // L表示当前考虑的子串的长度，从2开始，到len结束
        for (int L = 2; L <= len; L++) {
            // l表示当前考虑的子串的左边界
            for (int l = 0; l + L <= len; l++) {
                // 根据L计算右边界位置
                int r = l + L - 1;
                // 如果越界，停止这个长度子串的遍历
                if (r >= len) {
                    break;
                }

                // 判断子串[l, r]是否是回文串
                if (s.charAt(l) != s.charAt(r)) {
                    // 左右两端不同，非回文串，记录在状态表
                    state[l][r] = false;
                } else {
                    // 左右两端相同，是否是回文串，依赖于[l+1, r-1]是否是回文串
                    if (r - l <= 2) {
                        // 中间子串有0或1个字符，肯定是回文串
                        state[l][r] = true;
                    } else {
                        // 依赖于子串[l+1, r-1]是否是回文串，子串是否是回文串已在前序遍历中获取到状态
                        state[l][r] = state[l + 1][r - 1];
                    }
                }

                // 如果是回文串，且它的长度大于当前最大长度，重置最大长度
                if (state[l][r] && r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    begin = l;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

}
