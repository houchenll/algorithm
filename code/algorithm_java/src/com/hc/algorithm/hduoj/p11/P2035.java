package com.hc.algorithm.hduoj.p11;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2035
 * 人见人爱A^B
 * 10:48 -
 * */
public class P2035 {

    /**
     * 模1000
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            /// int, double, long存不下，使用BigInteger
            BigInteger a = in.nextBigInteger();
            int b = in.nextInt();
            /// BigInteger 不能和数字比较
            if ("0".equals(a.toString()) && b == 0) break;

            /// BigInteger 自带有pow方法
            /// 结果可能很大，需要转为string
            String result = a.pow(b).toString();   // 可能很长
            if (result.length() > 3) {
                /// sub后可能00开头，需要转为int类型输出
                System.out.println(Integer.parseInt(result.substring(result.length() - 3)));
            } else {
                System.out.println(result);
            }
        }
        in.close();
    }

}
