package com.hc.algorithm.main.linklist;

/**
 * 86. 分隔链表
 * https://leetcode-cn.com/problems/partition-list/
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */
public class P86PartitionList {

    public static void main(String[] args) {
        ListNode head = LinkTool.genLink(new int[]{1, 4, 3, 2, 5, 2});
        P86PartitionList p86 = new P86PartitionList();
        LinkTool.printLinkList(p86.solution2(head, 3));
    }

    public ListNode partition(ListNode head, int x) {
        return null;
    }

    /**
     * 方法1：左右插入法
     * 定义指针pre，指向最后一个小于x的节点，pre.next指向第一个大于等于x的节点
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * 0ms > 100%
     */
    private ListNode solution1(ListNode head, int x) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode dummy = new ListNode(0, head), pre = dummy, cur = head, tail = null;
        while (cur != null) {
            ListNode node = cur;
            cur = cur.next;
            if (node.val < x) {
                if (node != pre.next) {
                    node.next = pre.next;
                    pre.next = node;
                }
                pre = pre.next;
            } else {
                node.next = null;
                if (tail != null) {
                    tail.next = node;
                }
                tail = node;
            }
        }
        return dummy.next;
    }

    /**
     * 方法2：拆分合并
     * 遍历原链表，拆分成小于x的链表和大于等于x的链表，最后小值链表的尾部指向大值链表的头部，并把大值链表的尾部指空
     * 时间复杂度: O(n)，其中 nn 是原链表的长度。我们对该链表进行了一次遍历。
     * 空间复杂度: O(1)。
     * 0ms > 100%
     */
    private ListNode solution2(ListNode head, int x) {
        ListNode dummySmall = new ListNode(), small = dummySmall;
        ListNode dummyLarge = new ListNode(), large = dummyLarge;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                small.next = cur;
                small = small.next;
            } else {
                large.next = cur;
                large = large.next;
            }
            cur = cur.next;
        }
        small.next = dummyLarge.next;
        large.next = null;
        return dummySmall.next;
    }

}
