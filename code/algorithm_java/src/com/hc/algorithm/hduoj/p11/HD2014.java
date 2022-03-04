package com.hc.algorithm.hduoj.p11;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2014
 * 青年歌手大奖赛_评委会打分
 * 青年歌手大奖赛中，评委会给参赛选手打分。选手得分规则为去掉一个最高分和一个最低分，然后计算平均得分，请编程输出某选手的得分。
 * 输入数据有多组，每组占一行，每行的第一个数是n(2<n<=100)，表示评委的人数，然后是n个评委的打分。
 * */
public class HD2014 {

    /**
     * 不要排序，排序的话就太慢了
     * 遍历一遍就可以，在遍历过程中把所有数字求和，并标记出最大数和最小数，最后和减去最大和最小数
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = n - 2;
            double max = 0;
            double min = 100;
            double sum = 0;
            while (n > 0) {
                double num = in.nextDouble();
                sum += num;
                if (num < min) min = num;
                if (num > max) max = num;
                n--;
            }
            sum -= max;
            sum -= min;
            System.out.println(new DecimalFormat(".00").format(sum / m));
        }
        in.close();
    }

}
