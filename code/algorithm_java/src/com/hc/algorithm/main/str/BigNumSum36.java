package com.hc.algorithm.main.str;

/**
 * 字节跳转补充题：36进制大数相加
 * https://mp.weixin.qq.com/s/XcKQwnwCh5nZsz-DLHJwzQ
 */
public class BigNumSum36 {

    public String add36Strings(String num1, String num2) {
        if (null == num1 || 0 == num1.length()) {
            if (null == num2) {
                return "";
            } else {
                return num2;
            }
        } else if (null == num2 || 0 == num2.length()) {
            // 此时num1不为空
            return num1;
        }
        // 此时num1和num2都不为空

        StringBuilder res = new StringBuilder();

        // 记录两个字符串的最后一位
        int i = num1.length() - 1, j = num2.length() - 1;
        // 进位
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            // i或j出界时，取0，未出界时，取对应10进制数字
            int x = i >= 0 ? getInt(num1.charAt(i)) : 0;
            int y = j >= 0 ? getInt(num2.charAt(j)) : 0;
            int temp = x + y + carry;
            char ch = getChar(temp % 36);
            carry = temp / 36;
            res.insert(0, ch);
            i--;
            j--;
        }

        return res.toString();
    }

    /**
     * 把数字转为16进制字符
     */
    private char getChar(int num) {
        if (num < 0) {
            return '0';
        } else if (num <= 9) {
            return (char) ('0' + num);
        } else if (num <= 36) {
            return (char) (num - 10 + 'a');
        } else {
            return 'z';
        }
    }

    /**
     * 把36进制字符转为数字
     */
    private int getInt(char ch) {
        if ('0' <= ch && ch <= '9') {
            return ch - '0';
        } else {
            return ch - 'a' + 10;
        }
    }

}
