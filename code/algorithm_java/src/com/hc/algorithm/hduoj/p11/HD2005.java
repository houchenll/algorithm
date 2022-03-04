package com.hc.algorithm.hduoj.p11;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2005
 * 第几天？
 * 给定一个日期，输出这个日期是该年的第几天。
 * 输入数据有多组，每组占一行，数据格式为YYYY/MM/DD组成，具体参见sample input ,另外，可以向你确保所有的输入数据是合法的。
 * 对于每组输入数据，输出一行，表示该日期是该年的第几天。
 * */
public class HD2005 {

//    private static final int[] DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//    private static final int[] DAYS_RUN = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String time = in.next();
            String[] values = time.split("/");
            int y = Integer.parseInt(values[0]);
            int m = Integer.parseInt(values[1]);
            int d = Integer.parseInt(values[2]);

//            // 若某个年份能被4整除但不能被100整除，则是闰年
//            // 若某个年份能被400整除，则也是闰年
//            boolean isRun = y % 4 == 0 && y % 100 != 0 || y % 400 == 0;
//
//            int days = 0;
//            for (int i = 1; i < m; i++) {
//                days += isRun ? DAYS_RUN[i - 1] : DAYS[i - 1];
//            }
//            days += d;

            Calendar calendar = new GregorianCalendar(y, m - 1, d);
            System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        }
        in.close();
    }

}
