package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2004
 * 成绩转换
 * 输入一个百分制的成绩t，将其转换成对应的等级，具体转换规则如下：
 * 90~100为A;
 * 80~89为B;
 * 70~79为C;
 * 60~69为D;
 * 0~59为E;
 * 输入数据有多组，每组占一行，由一个整数组成。
 * 对于每组输入数据，输出一行。如果输入数据不在0~100范围内，请输出一行：“Score is error!”。
 * */
public class P2004 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int score = in.nextInt();
            if (score > 100) {
                System.out.println("Score is error!");
            } else if (score >= 90) {
                System.out.println("A");
            } else if (score >= 80) {
                System.out.println("B");
            } else if (score >= 70) {
                System.out.println("C");
            } else if (score >= 60) {
                System.out.println("D");
            } else if (score >= 0) {
                System.out.println("E");
            } else {
                System.out.println("Score is error!");
            }
        }
        in.close();
    }

}
