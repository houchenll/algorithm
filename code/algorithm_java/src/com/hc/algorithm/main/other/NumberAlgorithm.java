package com.hc.algorithm.main.other;

/**
 * 关于数字的算法
 */
public class NumberAlgorithm {

    public static void main(String[] args) {
//        System.out.println(mcd(1341323132, 1234123526));
//        System.out.println(positionNotationConvert(16, 8));
        System.out.println(isPrime(12));
    }

    /**
     * 求两个正整数的最大公约数
     * Greatest Common Divisor
     * 欧几里德算法，又称辗转相除法，应用定理：两个整数的最大公约数等于其中较小的那个数和两数相除余数的最大公约数。
     */
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;    // r <= q && r <= p  若p >= q, r <= q，或p < q，r == p < q
        return gcd(q, r);    // q 是大数，r是余数、小数
    }

    /**
     * 求两个整数的最小公倍数
     * 最小公倍数 = 两整数的乘积 ÷ 最大公约数
     */
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private static final String[] BASE = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F"};

    /**
     * 进制转换
     * 十进制数a用b进制表示
     * 2 <= b <= 16
     */
    public static String positionNotationConvert(int a, int b) {
        boolean isNeg = a < 0;
        if (isNeg) {
            a = a * -1;
        }

        // 使用a模b，结果为末尾数字，a整除b，结果为a
        // 当a小于b时，结束，a作为结果第1个字符
        // 根据结果从BASE中取数
        StringBuilder result = new StringBuilder();

        while (a >= b) {
            int yu = a % b;
            result.insert(0, BASE[yu]);
            a = a / b;
        }
        result.insert(0, BASE[a]);
        if (isNeg) {
            result.insert(0, "-");
        }

        return result.toString();
    }

    /**
     * 素数/质数判定
     * 定义：大于1的自然数，如果约数只有1和自身，称为素数或质数
     * 改进思路：
     * 1. 特殊情况1：<=3的数一定是素数
     * 2. 特殊情况2：大于2的偶数肯定不是素数
     * 3. 如果一个数可以分解为两个约数相乘，那两个约数一定一个大于数的平方根，另一个小于，因此只需遍历到平方根即可
     * 4. 质数还有一个特点，就是它总是等于 6x-1 或者 6x+1，其中 x 是大于等于1的自然数。首先 6x 肯定不是质数，因为
     * 它能被 6 整除；其次 6x+2 肯定也不是质数，因为它还能被2整除；依次类推，6x+3 肯定能被 3 整除；6x+4 肯定
     * 能被 2 整除。那么，就只有 6x+1 和 6x+5 (即等同于6x-1) 可能是质数了。所以循环的步长可以设为 6，然后每次
     * 只判断 6 两侧的数即可
     */
    public static boolean isPrime(int num) {
        if (num <= 3) {
            return num > 1;
        }

        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }

        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 是否是回文数字
     * Revert half of the number
     * 方法1：先转成字符串，再判断字符串是否回文。此方法不被题设允许
     * 方法2：对数字本身翻转，再与原数字比较
     * 方法3：基于方法2，只对数字后半段翻转，与原数字前半段比较。既节省时间，也避免溢出int范围
     * 处理边界和特殊值：负数全不是回文
     * 何时翻转了一半：当翻转得到的数字大于等于原数字时，已翻转了一半
     */
    public static boolean isPalindrome(int x) {
        // 特殊情况 1. 负数不是回文  2. 非零数字以0结尾不是回文
        if (x < 0 || x > 0 && x % 10 == 0) return false;

        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度是奇数时，可以用rev/10忽略中间数字。因为当是奇数时，如12321，x=12，rev=123，因为中间数字对
        // 回文没有影响，可以忽略
        return x == rev || x == rev / 10;
    }

}
