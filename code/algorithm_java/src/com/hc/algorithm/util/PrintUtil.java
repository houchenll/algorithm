package com.hc.algorithm.util;

import com.hc.algorithm.bean.ListNode;

public class PrintUtil {

    /**
     * 返回待排序数组
     */
    public static int[] getUnSortIntArray() {
        return new int[]{3, 5, 1, 2, 7, 9, 4, 10, 22, 32, 17, 88, 31, 23};
    }

    public static void printIntArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");
    }

    /**
     * 打印数组
     */
    public static void printIntArray2(int[] array) {
        if (null == array || array.length < 1) return;

        System.out.print("{");
        System.out.print(array[0]);
        for (int i = 1; i < array.length; i++) {
            System.out.print(", " + array[i]);
        }
        System.out.println("}");
    }

    // 打印链表
    public static void printLinkList(ListNode head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(",");
            }
            head = head.next;
        }
        System.out.println("]");
    }

}
