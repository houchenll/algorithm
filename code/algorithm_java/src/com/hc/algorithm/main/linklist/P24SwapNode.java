package com.hc.algorithm.main.linklist;

import com.hc.algorithm.bean.ListNode;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 */
public class P24SwapNode {

    public ListNode swapPairs(ListNode head) {
        return null;
    }

    /**
     * 方法1：穿针引线
     * 交换当前节点和它的下个节点；
     * 定义cur指向当前节点，pre为它的前节点
     * pre指向next，cur指向next.next，next指向cur，cur指向cur.next
     * 终止条件：cur != null && cur.next != null (至少有两个节点)
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * 0ms > 100%
     */
    private ListNode solution1(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy, cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            pre.next = next;
            cur.next = next.next;
            next.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

}
