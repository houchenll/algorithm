package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2037
 * 今年暑假不AC
 * 8:06 - 8:35 wrong answer
 * */
public class HD2037 {

    /**
     * 思路：
     * 1. 先取时间短的节目
     * 2. 看节目开始、结束时间有没有被占用，没有的话，加上去
     * 3. 怎么存储节目，节目起始，节目结束，节目时长，按节目时长从小到大排序
     * 4. 用长为24的数组表示时间有没有占用，0表示未占用，大于0表示占用，数字表示节目起始时长
     * 5. 新拿到一个节目，看起始之间是否未被占用，如果未被占用，占用；如果已占用，且起始点数字相同，表明已被占用，
     *    再检查起始、结束前后是否还是这个节目，如果是，把原节目取水占用，把新节目占用上去。如果已占用但起始数字不同，
     *    继续看下个节目
     * */
    public static void main(String[] args) {
        int[] hour = new int[24];  // 默认值为0

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) break;

            int count = 0;  // 节目数
            while (n-- > 0) {
                int start = in.nextInt();
                int end = in.nextInt();


                if (hour[start] == 0 && hour[end] == 0) {
                    // start和end都没有被占用，这个节目占用
                    set(hour, start, end);
                    count++;
                } else if (hour[start] == hour[end]) {
                    // 该节目所在时间，全部被另一节目占用，清除另一节目
                    clear(hour, start, end);
                    set(hour, start, end);
                    count++;
                }
            }
            System.out.println(count);
        }
        in.close();
    }

    private static void set(int[] arr, int l, int r) {
        for (int i = l; i<= r; i++) {
            arr[i] = l;
        }
    }

    private static void clear(int[] arr, int l, int r) {
        int num = arr[l];
        for (int i = 0; i <= r; i++) arr[i] = 0;
        for (int i = l - 1; i >= 0; i--) {
            if (arr[i] == num) arr[i] = 0;
        }
        for (int i = r + 1; i < arr.length; i++) {
            if (arr[i] == num) arr[i] = 0;
        }
    }

}
