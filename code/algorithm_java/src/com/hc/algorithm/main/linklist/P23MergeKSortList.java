package com.hc.algorithm.main.linklist;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class P23MergeKSortList {

    public ListNode mergeKLists(ListNode[] lists) {
        return null;
    }

    /**
     * 方法1：顺序合并各个链表
     * 每次使用合并两个链表的方法
     * 空间复杂度：O(1)
     * 时间复杂度：O(k^2 N)
     * 104ms > 17.16%
     */
    private ListNode solution1(ListNode[] lists) {
        ListNode ans = null;
        for (ListNode node : lists) {
            ans = LinkTool.mergeTwoSortList(ans, node);
        }
        return ans;
    }

    /**
     * 方法2：分治合并
     * 将 k 个链表配对并将同一对中的链表合并
     * 第一轮合并以后， k 个链表被合并成了 k/2 个链表，平均长度为 2n/k，然后是 k/4 个链表， k/8 个链表等等；
     * 重复这一过程，直到我们得到了最终的有序链表
     * 1ms > 100%
     * 时间复杂度：O(logk kN)
     * 空间复杂度：O(logk)
     */
    private ListNode solution2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    /**
     * 找到l和r的中点mid，分解到[l,mid], [mid+1,r]两个区间，再把两个区间的结果合并
     * 递归终止条件有两个：l==r或l>r
     */
    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return LinkTool.mergeTwoSortList(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    /**
     * 方法3：优先队列
     * 维护当前每个链表没有被合并的元素的最前面一个，k 个链表就最多有 k 个满足这样条件的元素
     * 每次在这些元素里面选取 val 属性最小的元素合并到答案中
     * 在选取最小元素的时候，我们可以用优先队列来优化这个过程
     * 时间复杂度：优先队列长度为k，每个元素添加/插入优先队列的时间为logk，共有kn个节点，总为O(logk kN)
     * 空间复杂度：优先队列的长度k，O(k)
     * 4ms > 67.98%
     */
    private ListNode solution3(ListNode[] lists) {
        for (ListNode node : lists) {
            if (null != node) {
                queue.offer(new Status(node.val, node));
            }
        }

        ListNode preHead = new ListNode();
        ListNode tail = preHead;

        while (!queue.isEmpty()) {
            Status min = queue.poll();
            tail.next = min.node;
            tail = tail.next;
            if (min.node.next != null) {
                queue.offer(new Status(min.node.next.val, min.node.next));
            }
        }

        return preHead.next;
    }

    private static class Status implements Comparable<Status> {
        private final int val;
        private final ListNode node;

        public Status(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }

        @Override
        public int compareTo(Status o) {
            return this.val - o.val;
        }
    }

    private final PriorityQueue<Status> queue = new PriorityQueue<>();

}
