package com.hc.algorithm.main.linklist;

import com.hc.algorithm.bean.ListNode;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * 876. 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class P876MiddleLink {

    // 如果有两个中间节点，返回第一个
    public ListNode middleNode1(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 如果有两个中间节点，返回第二个
    public ListNode middleNode2(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 2022.4.19 复习进度

}
