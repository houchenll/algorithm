package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2027
 * 统计元音
 * 17min 10:51 - 11:08
 */
public class HD2027 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int numa, nume, numi, numo, numu;

            while (n > 0) {
                String line = in.nextLine();
                int len = line.length();
                if (len == 0) continue;

                // 重置
                numa = 0;
                nume = 0;
                numi = 0;
                numo = 0;
                numu = 0;

                // 遍历计算数量
                for (int i = 0; i < len; i++) {
                    char letter = line.charAt(i);
                    if (letter == 'a' || letter == 'A') {
                        numa++;
                    } else if (letter == 'e' || letter == 'E') {
                        nume++;
                    } else if (letter == 'i' || letter == 'I') {
                        numi++;
                    } else if (letter == 'o' || letter == 'O') {
                        numo++;
                    } else if (letter == 'u' || letter == 'U') {
                        numu++;
                    }
                }

                // 输出
                System.out.println("a:" + numa);
                System.out.println("e:" + nume);
                System.out.println("i:" + numi);
                System.out.println("o:" + numo);
                System.out.println("u:" + numu);

                /// 最后一行的输出的最后不要加空行，只在各行之间的输出之间加空行
                if (n > 1) {
                    System.out.println();
                }

                n--;
            }
        }
        in.close();
    }

}
