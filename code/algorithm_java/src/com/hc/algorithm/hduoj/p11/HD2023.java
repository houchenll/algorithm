package com.hc.algorithm.hduoj.p11;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2023
 * 求平均成绩
 * 11:03 - 11:48 45分钟 平台报答案错误
 * */
public class HD2023 {

    /**
     * 遍历两遍，每一遍计算平均分，第二遍计算过平均分学生数量
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();  // 学生数量
            int m = in.nextInt();  // 学科数量
            if (n == 0 && m == 0) break;

            int[][] scores = new int[n][m];
            double[] stuAvuScore = new double[n];  // n个学生的平均分
            double[] classAvuScore = new double[m];  // m门学科的平均分

            // 第一遍遍历，计算平均分，并保存分数到数组
            for (int i = 0; i < n; i++) {
                int stuTotalScore = 0;
                for (int j = 0; j < m; j++) {
                    int score = in.nextInt();
                    scores[i][j] = score;
                    stuTotalScore += score;
                    classAvuScore[j] = classAvuScore[j] + score;
                }
                stuAvuScore[i] = stuTotalScore * 1.0 / m;
            }
            // 遍历学科，计算学科平均分
            for (int i = 0; i < m; i++) {
                classAvuScore[i] = classAvuScore[i] / n;
            }
            // 遍历数组，计算超过平均分的学生人数
            int count = 0;
            for (int i = 0; i < n; i++) {
                boolean isPass = true;
                for (int j = 0; j < m; j++) {
                    int score = scores[i][j];
                    if (score < classAvuScore[j]) {
                        // 不及格
                        isPass = false;
                        break;
                    }
                }
                if (isPass) count++;
            }

            // 打印n个学生的平均分
            printArray(n, stuAvuScore);

            // 打印m门学科的平均分
            printArray(m, classAvuScore);

            System.out.println(count);
            System.out.println();
        }
        in.close();
    }

    private static void printArray(int m, double[] scores) {
        for (int i = 0; i < m; i++) {
            if (i < m - 1) {
                System.out.print(new DecimalFormat(".00").format(scores[i]) + " ");
            } else {
                System.out.println(new DecimalFormat(".00").format(scores[i]));
            }
        }
    }

}
