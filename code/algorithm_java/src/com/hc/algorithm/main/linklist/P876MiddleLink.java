package com.hc.algorithm.main.linklist;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * 876. 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class P876MiddleLink {

    public ListNode middleNode(ListNode head) {
        return LinkTool.midNode(head);
    }

}
