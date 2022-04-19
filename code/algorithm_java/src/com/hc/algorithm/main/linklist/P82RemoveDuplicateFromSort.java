package com.hc.algorithm.main.linklist;

import com.hc.algorithm.bean.ListNode;
import com.hc.algorithm.util.LinkTool;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * 82. 删除排序链表中的重复元素 II
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，
 * 只保留原始链表中 没有重复出现 的数字。返回同样按升序排列的结果链表。
 */
public class P82RemoveDuplicateFromSort {

    public static void main(String[] args) {
        ListNode head = LinkTool.genLink(new int[]{1, 2, 3, 3, 4, 4, 5});
        P82RemoveDuplicateFromSort p82 = new P82RemoveDuplicateFromSort();
        ListNode result = p82.solution1(head);
        LinkTool.printLinkList(result);
    }

    public ListNode deleteDuplicates(ListNode head) {
        return null;
    }

    /**
     * 方法1：一个指针即可
     * 1. 因为head可能为空，所以定义哑结点dummy
     * 2. 初始时cur位于哑结点位置
     * 3. 每次比较cur后面的两个结点是否相等，若相等，取出值，然后用while循环把等于该值的节点全部删除，若不相等，cur右移一位
     * 4. cur后两个结点都不为空时继续，只有一个为空时，因为第3步把所有相同结点都已删除，所以剩余的一个非空结点和cur结点不会相等
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * 0ms > 100%
     */
    private ListNode solution1(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

}
