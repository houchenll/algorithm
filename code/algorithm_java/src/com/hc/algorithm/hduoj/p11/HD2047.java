package com.hc.algorithm.hduoj.p11;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2047
 * 阿牛的EOF牛肉串
 * 23min 9:26 - 9:49
 */
public class HD2047 {

    /**
     * 此类问题需要考虑两个问题
     * 1. 最后一步有几种情况
     * 2. 最后一步的每种情况下，与之前步骤有什么数量关系
     * 3. 最后，合并最后一步的所有情况，建立最后一步的数量和之前步骤数量的关系式
     * 这个问题，最后一步有两种情况，是E或F，或者是O
     * 如果最后一格是E或F，则num[n] = 2*num[n-1]
     * 如果最后一格是O，则num[n]=1*num[n-1]=1*2*num[n-2]
     * 有：num[n] = 2 * num[n-1] + 2 * num[n-2]
     */
    public static void main(String[] args) {
        /// long 这类递推问题，注意使用long类型
        long[] nums = new long[40];
        nums[1] = 3;
        nums[2] = 8;
        for (int i = 3; i <= 39; i++) {
            nums[i] = 2 * (nums[i - 1] + nums[i - 2]);
        }

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) break;
            System.out.println(nums[n]);
        }
        in.close();
    }

}
