package com.hc.algorithm.main.linklist;

/**
 * https://leetcode-cn.com/problems/sort-list/
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 */
public class P148SortList {

    public static void main(String[] args) {
        ListNode head = LinkTool.genLink(new int[]{4, 2, 1, 3});
        P148SortList p148 = new P148SortList();
        LinkTool.printLinkList(p148.solution1(head));
    }

    public ListNode sortList(ListNode head) {
        return null;
    }

    /**
     * 方法1：自顶向下归并排序
     * 6ms > 77.64%
     * 时间复杂度：O(n logN)
     * 空间复杂度：O(logN)
     */
    private ListNode solution1(ListNode head) {
        return sortList(head, null);
    }

    /**
     * 1. 递归
     * 2. 归并排序
     * 3. 快慢指针法找到中点
     */
    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        // tail为另一个归并段的起始位置
        if (head.next == tail) {
            // 断开两个归并子段之间的连接
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            // fast到tail结束
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode left = sortList(head, slow);
        ListNode right = sortList(slow, tail);
        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(), tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

    /**
     * 方法2：自底向上归并排序
     * // todo 较难理解，明天重复一遍
     * */

}
