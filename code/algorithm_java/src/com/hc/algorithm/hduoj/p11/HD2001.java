package com.hc.algorithm.hduoj.p11;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2001
 * 计算两点间的距离
 * 输入两点坐标（X1,Y1）,（X2,Y2）,计算并输出两点间的距离。
 * 输入数据有多组，每组占一行，由4个实数组成，分别表示x1,y1,x2,y2,数据之间用空格隔开。
 * 对于每组输入数据，输出一行，结果保留两位小数。
 * Sample Input
 * 0 0 0 1
 * 0 1 1 0
 * Sample Output
 * 1.00
 * 1.41
 * */
public class HD2001 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            // 连续使用4个nextDouble，可取空格中数据
            double x1 = in.nextDouble();
            double y1 = in.nextDouble();
            double x2 = in.nextDouble();
            double y2 = in.nextDouble();
            // DecimalFormat和.00保留两位小数
            DecimalFormat format = new DecimalFormat(".00");
            System.out.println(format.format(Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2))));
        }
        in.close();
    }

}
