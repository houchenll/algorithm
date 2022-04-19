package com.hc.algorithm.main.num;

/**
 * https://leetcode.com/problems/reverse-integer/
 * 7. Reverse Integer
 * <p>
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the
 * value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 */
public class P7ReverseInteger {

    public static void main(String[] args) {
        P7ReverseInteger p7 = new P7ReverseInteger();
        p7.reverse(1534236469);
    }

    public int reverse(int x) {
//        return reverseByString(x);
        return officialSolution(x);
    }

    private int reverseByString(int x) {
        /// 可以定义一个rev，默认等于0，最后返回
        if (x == 0) return 0;

        /// 不用记录正负，正负数可用同一套规则处理
        boolean isPositive = x > 0;  // 记录正负
        if (!isPositive) {
            x = Math.abs(x);  // 转为正数
        }

        /// 可以不借用字符串，只使用int完成pop和append
        String str = String.valueOf(x);
        StringBuilder reversedBuffer = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {  // 字符串倒序遍历拼接
            reversedBuffer.append(str.charAt(i));
        }

        int reversed;
        try {
            /// 转为整数时可能会越界，需catch
            reversed = Integer.parseInt(reversedBuffer.toString());  // 转为整数
        } catch (Exception e) {
            return 0;
        }

        if (!isPositive) reversed = -1 * reversed;  // 回归正负号

        /// Integer的边界可用Integer.MAX_VALUE和Integer.MIN_VALUE替换
        if (reversed < Math.pow(-2, 31) || reversed > Math.pow(2, 31) - 1) {  // 越界判定
            return 0;
        }

        return reversed;
    }

    private int officialSolution(int x) {
        int rev = 0;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && pop > 7) return 0;
            if (rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && pop < -8) return 0;
            rev = rev * 10 + pop;
        }

        return rev;
    }

}
