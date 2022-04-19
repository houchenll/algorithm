package com.hc.algorithm.main.linklist;

import com.hc.algorithm.bean.ListNode;
import com.hc.algorithm.util.LinkTool;

/**
 * 25. K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class P25ReverseNodesInKGroup {

    public static void main(String[] args) {
        P25ReverseNodesInKGroup p25 = new P25ReverseNodesInKGroup();
        ListNode head = LinkTool.genLink(new int[]{1,2,3,4,5});
        LinkTool.printLinkList(p25.reverseKGroup(head, 3));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        return officialSolution(head, k);
    }

    /**
     * 方法1：模拟
     * 1. 分组：我们需要把链接以k个一组分组，所以定义一个head指针，每次移动k步，依次指向每个分组的头结点。
     *         同时定义一个tail指针，依次指向每个分组的最后一个结点
     * 2. 翻转：对head和tail内的子链接进行翻转
     * 3. 连接：因为需要把翻转后的子分组和链接前后部分相连，所以定义一个pre指针和一个next指针，分别指向
     *         当前子分组head结点的前一个结点和tail结点的下一个结点。在子分组翻转完成后，pre指向新head，
     *         新tail指向next
     * 4. 头处理：创建一个hair指针，指向链表第一个结点。最后返回hair的下一个指针即可
     * 5. 尾处理：头tail为空或不满k时，结束
     * 1ms > 17.55%
     * 38.5MB > 80.4%
     */
    private ListNode myImpl(ListNode head, int k) {
        // 初始化
        ListNode hair = new ListNode(0, head);
        ListNode pre = hair;
        ListNode tail = hair;
        ListNode next = null;
        int step = 0;  // 移动步数，用于标记沿链接前进了几个结点

        // 沿链表前进k个结点
        while (step < k) {
            // 前进2个结点
            tail = tail.next;
            step++;  // 2
            if (tail == null) {
                // 遍历到最后一个结点，返回
                return hair.next;
            }
            if (step >= k) {
                // tail到达分组最后一个结点，记下next
                next = tail.next;
                // 切割分组
                pre.next = null;
                tail.next = null;
                // 翻转分组
                ListNode current = head;
                while (current.next != null) {
                    ListNode tmp = current.next;
                    current.next = tmp.next;
                    tmp.next = head;
                    head = tmp;
                }
                tail = current;
                // 和前面后面连接
                pre.next = head;
                tail.next = next;
                // 重置到新的分组开始状态
                head = next;
                pre = tail;
                step = 0;
            }
        }

        return null;
    }

    private ListNode officialSolution(ListNode head, int k) {
        ListNode hair = new ListNode(0, head);
        ListNode pre = hair;

        // 一个新的分组开始
        while (head != null) {
            // tail初始化为分组头结点的前一个结点
            ListNode tail = pre;
            // tail沿链表向前进k个结点，如果未满k个结点到尾部，直接返回新链接
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            // 保存tail结点的下一个结点，方便后面连接翻转后的分组
            ListNode next = tail.next;
            // 翻转子链表
            ListNode[] reverse = LinkTool.reverseLink(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链接重新连接回原链表
            pre.next = head;
            tail.next = next;
            // 重置pre和head，准备下个分组开始
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }

}
