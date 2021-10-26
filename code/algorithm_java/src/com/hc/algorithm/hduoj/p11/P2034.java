package com.hc.algorithm.hduoj.p11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2034
 * 人见人爱A-B
 * 20min
 * */
public class P2034 {

    /**
     * 避免n*n遍历
     * 先遍历集合A，把元素存到hash表中
     * 再遍历集合B，查找元素是否在hash表中，若在，删除hash表中匹配项
     * 3 * N
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            if (n == 0 && m == 0) break;

            Map<Integer, Integer> hash = new HashMap<>();
            for (int i = 0; i < n; i++) {
                hash.put(in.nextInt(), 1);
            }

            for (int i = 0; i < m; i++) {
                int num = in.nextInt();
                hash.remove(num);
            }

            Set<Integer> keys = hash.keySet();
            if (keys.size() == 0) {
                System.out.println("NULL");
                continue;
            }

            for (Integer key : keys) {
                System.out.print(key + " ");
            }
            System.out.println();
        }
        in.close();
    }

}
