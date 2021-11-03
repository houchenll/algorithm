package com.hc.algorithm.leetcode;

import com.hc.algorithm.bean.ListNode;
import com.hc.algorithm.util.LinkTool;
import com.hc.algorithm.util.PrintUtil;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class P206ReverseLinkedList {

    public static void main(String[] args) {
        P206ReverseLinkedList p206 = new P206ReverseLinkedList();
        ListNode head = LinkTool.generateListNode(new int[]{});
        PrintUtil.printLinkList(p206.reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
        return solution1(head);
    }

    /**
     * 遍历列表，每从头部取出一个头结点，插入到一个新链表的头部
     * 0ms > 100%
     * 38.1MB > 70.75%
     */
    public ListNode solution1(ListNode head) {
        return LinkTool.reverseLink(head);
    }

}
