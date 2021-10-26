package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2012
 * 素数判定
 * 对于表达式n^2+n+41，当n在（x,y）范围内取整数值时（包括x,y）(-39<=x<y<=50)，判定该表达式的值是否都为素数。
 * 输入数据有多组，每组占一行，由两个整数x，y组成，当x=0,y=0时，表示输入结束，该行不做处理。
 * 对于每个给定范围内的取值，如果表达式的值都为素数，则输出"OK",否则请输出“Sorry”,每组输出占一行。
 * */
public class P2012 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int x = in.nextInt();
            int y = in.nextInt();

            if (x == 0 && y == 0) continue;

            boolean isAllPrime = true;
            for (int i = x; i <= y; i++) {
                int value = i * i + i + 41;
                // 判断value是否是素数
                boolean isPrime = true;
                if (value < 3) {
                    isPrime = false;
                } else {
                    for (int j = 3; j <= Math.sqrt(value); j += 2) {
                        if (value % j == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                }
                if (!isPrime) {
                    isAllPrime = false;
                    break;
                }
            }

            if (isAllPrime) {
                System.out.println("OK");
            } else {
                System.out.println("Sorry");
            }
        }
        in.close();
    }

}
