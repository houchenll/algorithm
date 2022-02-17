package com.hc.algorithm.main.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 415. 字符串相加
 * https://leetcode-cn.com/problems/add-strings/
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 */
public class P415AddString {

    /**
     * 我的解法
     * 时间复杂度：O(N)，N为两个字段串中较长者的长度
     * 空间复杂度：O(1)
     */
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int len = Math.max(len1, len2);
        StringBuilder ans = new StringBuilder();

        final Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            dict.put("" + i, i);
        }

        // 和的余数
        int plus = 0;
        // num1从哪个下标开始取数
        int pos1 = len1 - 1;
        // num2从哪个下标开始取数
        int pos2 = len2 - 1;

        for (int i = len - 1; i >= 0; i--) {
            // 从num1和num2分别取数，如果当前下标已小于0，就不再取数，而视为0
            int a = 0;
            if (pos1 >= 0) {
                a = dict.get(num1.substring(pos1, pos1 + 1));
                pos1--;
            }
            int b = 0;
            if (pos2 >= 0) {
                b = dict.get(num2.substring(pos2, pos2 + 1));
                pos2--;
            }
            int sum = a + b + plus;
            if (sum >= 10) {
                plus = 1;
                sum = sum - 10;
            } else {
                plus = 0;
            }
            ans.insert(0, sum);
        }
        // 最后如果有余数，添加到头部
        if (plus > 0) {
            ans.insert(0, plus);
        }

        return ans.toString();
    }

    /**
     * 官方解法
     * 思路相同，区别：
     * 1. 用i,j是否大于0来判断是否结束循环
     * 2. 使用stringBuffer来实现加法
     * 3. 使用charAt来取字符
     * 4. 不用定义一个字母数字对照表，使用字符减'0'计算得到数值大小
     * 1ms > 100%
     * 时间复杂度：O(N)，N为两个字段串中较长者的长度
     * 空间复杂度：O(1)
     */
    private String addStrings1(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int plus = 0;
        StringBuilder builder = new StringBuilder();

        while (i >= 0 || j >= 0 || plus > 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = a + b + plus;
            builder.append(sum % 10);
            plus = sum / 10;
            i--;
            j--;
        }

        builder.reverse();
        return builder.toString();
    }

}
