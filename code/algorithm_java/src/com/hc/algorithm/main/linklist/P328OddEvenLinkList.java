package com.hc.algorithm.main.linklist;

import com.hc.algorithm.bean.ListNode;
import com.hc.algorithm.util.LinkTool;

/**
 * 328. 奇偶链表
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，
 * 而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 */
public class P328OddEvenLinkList {

    public static void main(String[] args) {
        ListNode head = LinkTool.genLink(new int[]{2, 1, 3, 5, 6, 4, 7});
        P328OddEvenLinkList p328 = new P328OddEvenLinkList();
        LinkTool.printLinkList(p328.solution1(head));
    }

    public ListNode oddEvenList(ListNode head) {
        return null;
    }

    /**
     * 方法1：拆成两个链表，再合并
     * 原链表拆成奇、偶两个链表，然后合并
     * 1. 初始化：odd(奇)和even(偶)分别指向奇/偶数节点的头部，p,q分别指向奇、偶链表的最后一个节点
     * 2. 遍历链表，分别把奇偶节点追加在两个链表后
     * 3. 把奇链表尾指向偶链表头部
     * 特殊处理：如果链表为空或只有一个节点或只有两个节点，直接返回
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * 0ms > 100%
     */
    private ListNode solution1(ListNode head) {
        if (null == head || null == head.next || null == head.next.next) {
            return head;
        }

        ListNode odd = new ListNode(), even = new ListNode(), p = null, q = null;

        int i = 1;
        ListNode cur = head;
        while (cur != null) {
            ListNode node = cur;
            cur = cur.next;
            if (i % 2 == 0) {
                if (q == null) {
                    q = node;
                    even.next = q;
                } else {
                    q.next = node;
                    q = node;
                }
                q.next = null;
            } else {
                if (p == null) {
                    p = node;
                    odd.next = p;
                } else {
                    p.next = node;
                    p = node;
                }
            }
            i++;
        }

        p.next = even.next;

        return odd.next;
    }

}
