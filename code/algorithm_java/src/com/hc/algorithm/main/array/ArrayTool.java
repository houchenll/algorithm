package com.hc.algorithm.main.array;

public class ArrayTool {

    /**
     * 生成随机数组
     */
    public static int[] genArray(int len) {
        return genArray(len, 100);
    }

    /**
     * 生成随机数组
     */
    public static int[] genArray(int len, int range) {
        if (len <= 0) {
            return new int[]{};
        }

        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = (int) (Math.random() * range);
        }

        return array;
    }

    /**
     * 打印数组
     */
    public static void printArray(int[] nums) {
        if (null == nums) {
            System.out.println("null");
            return;
        }

        System.out.print("[");

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(nums[i]);
        }

        System.out.println("]");
    }

}
