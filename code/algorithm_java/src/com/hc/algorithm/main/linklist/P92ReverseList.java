package com.hc.algorithm.main.linklist;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 92. 反转链表
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class P92ReverseList {

    public static void main(String[] args) {
        ListNode head = LinkTool.genLink(new int[]{1, 2, 3});
        P92ReverseList p92 = new P92ReverseList();
        ListNode result = p92.solution2(head, 1, 2);
        LinkTool.printLinkList(result);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        return null;
    }

    /**
     * 方法1：分割 + 反转 + 拼接
     * 记录下反转部分的前一个结点，和后一个结点
     * 对反转部分反转，然后拼接起来
     * 0ms > 100%
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    private ListNode solution1(ListNode head, int left, int right) {
        ListNode pre = new ListNode(0, head);
        ListNode tail = pre;
        // 翻转部分的前一个节点和后一个结点
        ListNode reversePre = new ListNode();

        int i = 1;
        ListNode p = head;
        while (p != null) {
            if (i < left) {
                tail = p;
                p = p.next;
            } else if (i == left) {
                ListNode temp = p;
                p = p.next;
                temp.next = null;
                // 记录下翻转部分的前一个结点
                reversePre = tail;
                tail.next = temp;
                tail = tail.next;
            } else if (i <= right) {
                ListNode temp = p;
                p = p.next;
                // 插入到tempPre后
                temp.next = reversePre.next;
                reversePre.next = temp;
                i++;
                continue;
            } else {
                tail.next = p;
                break;
            }

            i++;
        }

        return pre.next;
    }

    /**
     * 方法2：穿针引线
     * 优化1：翻转操作时通过cur,next,pre三者之间指向的操作完成。不需要定义temp
     * 优化2：翻转前定义cur为pre.next，不用在循环中判断
     * 优化3：因为优化2，翻转操作需要翻转的结点比翻转区间少一个结点
     * 优化4：因为优化1的操作，翻转区间最后一个结点翻转后cur已经连接上后续结点
     * 0ms > 100%
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    private ListNode solution2(ListNode head, int left, int right) {
        // 虚拟结点，减少边界判断
        ListNode dummyNode = new ListNode(0, head);
        // pre表示翻转区间的前一个结点，初始在整个链表前
        ListNode pre = dummyNode;
        // 把pre移动到翻转区间的前一个节点，维持不动
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // 关键：把翻转区间第1个结点连接到pre.next，定义为cur，后面每次把cur.next翻转到pre.next。cur指向不动
        ListNode cur = pre.next;
        ListNode next;
        // pre指向cur已翻转了1个结点，剩余待翻转结点只剩下right-left个
        // 最后一个翻转结点翻转后，cur就连接上了后续的链表
        for (int i = 0; i < right - left; i++) {
            // next为待翻转的结点，每次都是cur.next
            next = cur.next;
            // 更新cur.next的新的指向
            cur.next = next.next;
            // 把next插入到pre后
            next.next = pre.next;
            pre.next = next;
        }
        // 因为翻转区间
        return dummyNode.next;
    }

}
