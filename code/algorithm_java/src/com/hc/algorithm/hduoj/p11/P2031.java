package com.hc.algorithm.hduoj.p11;

import com.hc.algorithm.category.basic.NumberAlgorithm;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2031
 * 进制转换
 * */
public class P2031 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            int r = in.nextInt();
            if (num == 0 && r == 0) break;

            System.out.println(NumberAlgorithm.positionNotationConvert(num, r));
        }
        in.close();
    }

}
