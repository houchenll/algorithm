package com.hc.algorithm.hduoj.p11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2019
 * 数列有序!
 * 有n(n<=100)个整数，已经按照从小到大顺序排列好，现在另外给一个整数x，请将该数插入到序列中，并使新的序列仍然有序。
 * */
public class HD2019 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();
            int x = in.nextInt();

            if (n == 0 && x == 0) break;

            boolean isAdd = false;
            int pos = 0;
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                arr.add(num);
                if (!isAdd && num >= x) {
                    pos = i;
                    isAdd = true;
                }
            }

            /// 用列表插入
            arr.add(pos, x);

            // 打印数组
            for (int i = 0; i < arr.size() - 1; i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println(arr.get(arr.size() - 1));
        }

        in.close();
    }

}
