package com.hc.algorithm.main.linklist;

import com.hc.algorithm.bean.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 83. 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 */
public class P83RemoveDuplicateFromSort {

    public ListNode deleteDuplicates(ListNode head) {
        return null;
    }

    /**
     * 方法1：遍历
     * 遍历每个节点，比较它和下一个节点的值，如果相等，当前节点指向下个节点的下个节点，此时当前节点指向不变
     * 如果不相等，当前节点后移1个节点
     * 如果当前节点的下个节点为空，表示当前节点是链表最后一个节点，停止
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * 0ms > 100%
     */
    private ListNode solution1(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

}
