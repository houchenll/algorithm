package com.hc.algorithm.main.linklist;

import com.hc.algorithm.bean.ListNode;
import com.hc.algorithm.util.LinkTool;

/**
 * 61. 旋转链表
 * https://leetcode-cn.com/problems/rotate-list/
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class P61RotateList {

    public static void main(String[] args) {
        ListNode head = LinkTool.genLink(new int[]{1, 2});
        P61RotateList p61 = new P61RotateList();
        ListNode result = p61.solution1(head, 3);
        LinkTool.printLinkList(result);
    }

    public ListNode rotateRight(ListNode head, int k) {
        return null;
    }

    /**
     * 方法1： 右移len-k个距离
     * k可能大于链表长度，所以先计算出链表长度，得到新k=k%len
     * 链表最后一个节点需要连接上第1个节点
     * 初始时pre指向头节点，pre是最后一个节点
     * pre移动 len - k 个节点，然后记pre.next为cur，断开pre.next与cur连接，返回cur
     * 1. 初始化：遍历节点，计算长度，找到最后一个节点，并把pre指向最后一个节点，Pre.next指向头节点
     * 2. 得到新k=k%len
     * 3. pre移动 len - k 个节点
     * 4. 记pre.next为cur，断开pre.next与cur连接，返回cur
     * 时间复杂度：O(N)，两遍循环
     * 空间复杂度：O(1)，4个变量
     * 0ms > 100%
     */
    private ListNode solution1(ListNode head, int k) {
        if (null == head || head.next == null) {
            return head;
        }

        int len = 0;
        ListNode p = head;
        ListNode pre = null;
        while (p != null) {
            len++;
            if (p.next == null) {
                pre = p;
            }
            p = p.next;
            if (null != pre) {
                pre.next = head;
            }
        }

        k = k % len;
        int step = len - k;
        while (step > 0) {
            pre = pre.next;
            step--;
        }
        head = pre.next;
        pre.next = null;
        return head;
    }

    /**
     * 方法2：官方题解
     * 和方法1大体相同，细节有优化
     * 1. k为0时，直接返回head
     * 2. 遍历得到链表长度时，终止条件为p.next != null，这样停止遍历时p指向最后一个节点，但是少遍历了最后一个节点，初始长度需要设为1
     * 3. k%len为0，即step为len时，也可以直接返回
     * 4. 不可以直接返回时，才需要闭合成环
     * 0ms > 100%
     */
    private ListNode solution2(ListNode head, int k) {
        if (null == head || null == head.next || k == 0) {
            return head;
        }
        int len = 1;
        ListNode pre = head;
        while (null != pre.next) {
            len++;
            pre = pre.next;
        }
        int step = len - k % len;
        if (step == len) {
            return head;
        }
        pre.next = head;
        while (step-- > 0) {
            pre = pre.next;
        }
        ListNode ret = pre.next;
        pre.next = null;
        return ret;
    }

}
