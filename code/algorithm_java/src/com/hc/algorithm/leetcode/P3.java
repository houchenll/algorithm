package com.hc.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class P3 {

    public static void main(String[] args) {
        P3 p3 = new P3();
        String s = "pwwkew";
        System.out.println(p3.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        return solution1(s);
    }

    /**
     * 方法1：滑动窗口
     * 11ms > 19.23%
     * 39MB > 12.31%
     */
    private int solution1(String s) {
        // r表示当前无重复子字符串右界的下一个字段的位置
        int l = 0, r = 0;
        int maxLen = 0;
        int len = s.length();
        if (len == 0) {
            return maxLen;
        }
        HashSet<String> set = new HashSet<>();
        while (l <= len - 1) {
            while (r <= len - 1) {
                String rightLetter = s.substring(r, r + 1);
                if (set.contains(rightLetter)) {
                    break;
                }
                set.add(rightLetter);
                r++;
            }

            int currentLen = r - l;
            maxLen = Math.max(maxLen, currentLen);

            String leftLetter = s.substring(l, l + 1);
            set.remove(leftLetter);
            l++;
        }
        return maxLen;
    }

    /**
     * 官方解法：滑动窗口
     * */
    private int solution2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

}
