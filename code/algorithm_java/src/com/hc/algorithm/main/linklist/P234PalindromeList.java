package com.hc.algorithm.main.linklist;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
public class P234PalindromeList {

    public boolean isPalindrome(ListNode head) {
        return false;
    }

    /**
     * 方法1：分割 + 倒序 + 比较
     * 3ms > 99.92%
     * 时间复杂度：O(1.5N)
     * 空间复杂度：O(1)
     */
    private boolean solution1(ListNode head) {
        // 只有一个节点时是回文
        if (null == head || null == head.next) {
            return true;
        }

        // 找到中点，slow属于前半部分最后一个节点或中间节点，slow.next属于后半段第一个节点
        // slow=(fast+1)/2
        // fast按1/3/5/...这样跳，如果有奇数个节点，fast正好可以走到最后一个节点，此时slow走到中间节点
        // 如果有偶数个节点，fast走到最后节点的前一个节点停止，此时slow位于中间位置的左侧，即前半部分的最后一个节点
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 翻转后半段
        ListNode dummy = new ListNode();
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }

        // 比较前半段和后半段是否相等，全部都相等才是回文
        boolean isPalindrome = true;
        ListNode p1 = head, p2 = dummy.next;
        while (p2 != null) {
            if (p1.val != p2.val) {
                isPalindrome = false;
                break;
            }
            p2 = p2.next;
            p1 = p1.next;
        }

        return isPalindrome;
    }

}
