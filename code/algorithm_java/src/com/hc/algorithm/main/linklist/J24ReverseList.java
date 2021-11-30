package com.hc.algorithm.main.linklist;

/**
 * 剑指 Offer 24. 反转链表
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 同P206
 */
public class J24ReverseList {

    public ListNode reverseList(ListNode head) {
        return null;
    }

    /**
     * 方法1：虚头部
     * 添加虚头部，遍历链表，把每个节点添加在虚头部后
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    private ListNode solution1(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode dummy = new ListNode();
        ListNode cur = head;
        while (cur != null) {
            ListNode node = cur;
            cur = cur.next;
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }

    /**
     * 方法2：迭代法，新节点作为新头部
     * 1. 不用虚头部
     * 2. 先保存下cur.next
     * 3. 不用判断特殊情况
     */
    private ListNode solution2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
