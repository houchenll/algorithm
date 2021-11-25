package com.hc.algorithm.main.linklist;

/**
 * https://leetcode-cn.com/problems/insertion-sort-list/
 * 147. 对链表进行插入排序
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 */
public class P147InsertSort {

    public static void main(String[] args) {
        ListNode head = LinkTool.genLink(new int[]{-1, 5, 3, 4, 0});
        P147InsertSort p147 = new P147InsertSort();
        ListNode result = p147.solution2(head);
        LinkTool.printLinkList(result);
    }

    public ListNode insertionSortList(ListNode head) {
        return null;
    }

    /**
     * 方法1：插入排序
     * 定义哑结点，指向的链表为排序好的结点，初始只有哑结点
     * 每个遍历到的原链表中的结点，遍历排序链表，找到第一个大于它的结点，插入到这个结点前
     * 遍历排序链表时，判断当前结点的下个结点是否大于待插入结点，如果大于，插入在当前结点和大于它的结点之间
     * 当排序链表查到结束仍没有大于它的结点时，插入到排序链表尾部
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * 25ms > 21.35%
     */
    private ListNode solution1(ListNode head) {
        ListNode dummy = new ListNode();

        while (head != null) {
            ListNode node = head;
            head = head.next;

            ListNode cur = dummy;
            while (cur.next != null) {
                if (cur.next.val >= node.val) {
                    node.next = cur.next;
                    cur.next = node;
                    break;
                } else {
                    cur = cur.next;
                }
            }
            if (cur.next == null) {
                node.next = null;
                cur.next = node;
            }
        }

        return dummy.next;
    }

    /**
     * 方法2：原链表插入排序
     * 1. 定义cur指向待插入的结点
     * 2. 定义lastSorted指向已排序部分的最后一个结点，lastSorted指向cur
     * 3. 插入前，先判断cur能否直接放在lastSorted之后
     * 2ms > 98.86%
     */
    private ListNode solution2(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode dummy = new ListNode(0, head), lastSorted = head, cur = head.next;
        while (cur != null) {
            if (cur.val >= lastSorted.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode pre = dummy;
                while (pre.next.val < cur.val) {
                    pre = pre.next;
                }
                lastSorted.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = lastSorted.next;
        }
        return dummy.next;
    }

}
