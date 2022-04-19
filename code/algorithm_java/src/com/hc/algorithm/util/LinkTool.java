package com.hc.algorithm.util;

import com.hc.algorithm.bean.ListNode;

/**
 * 链表工具
 */
public class LinkTool {

    /**
     * 生成链表
     */
    public static ListNode genLink(int[] nums) {
        ListNode hair = new ListNode();
        ListNode tail = hair;
        for (int num : nums) {
            ListNode node = new ListNode(num);
            tail.next = node;
            tail = node;
        }
        return hair.next;
    }

    public static ListNode generateListNode(int[] array) {
        if (array == null || array.length == 0) return null;
        int len = array.length;

        ListNode head = null;
        // 倒序，从最后向最前
        for (int i = len - 1; i >= 0; i--) {
            // 取出一个新数据，生成新节点，新节点的下一个节点是之前的头节点，然后更新头节点指向当前新节点
            head = new ListNode(array[i], head);
        }
        return head;
    }

    /**
     * 翻转链表：有头结点和尾结点，翻转部分链表
     * 不断把当前头结点插入到原尾结点下一个结点位置
     */
    public static ListNode[] reverseLink(ListNode head, ListNode tail) {
        // prev为翻转后链表的第1个结点
        ListNode first = tail.next;
        // cur为当前链表的头结点
        ListNode cur = head;

        while (first != tail) {
            // 暂存当前头结点的下一个结点
            ListNode next = cur.next;

            // 把当前头结点插入到翻转后列表的头部
            cur.next = first;
            first = cur;

            // 把暂存的头结点的下一个结点作为新的头结点
            cur = next;
        }

        // 原链接的头、尾指针仍指针原来结点，但头变成了尾，尾变成了头
        return new ListNode[]{tail, head};
    }

    /**
     * 翻转链表：只有头结点，翻转整个链表
     * 遍历列表，每从头部取出一个头结点，插入到一个新链表的头部
     * 0ms > 100%
     * 38.1MB > 70.75%
     */
    public static ListNode reverseLink(ListNode head) {
        // 指向新链表的头结点
        ListNode dummy = new ListNode(0);

        // 因为翻转后原head不再有意义，所以直接使用head遍历链表
        while (head != null) {
            // 缓存当前结点
            ListNode p = head;
            // head指向下一个结点
            head = head.next;
            // 缓存结点插入到新链表头部
            p.next = dummy.next;
            dummy.next = p;
        }

        return dummy.next;
    }

    /**
     * 合并两个链表
     * 1. 只处理l1和l2都不为空的情况，当l1或l2为空时，停止遍历，直接拼接
     * 2. tail.next时不用断开与原链表连接
     * 3. 创建preHead结点，作为头结点的前一结点。最后返回preHead.next
     * 时间复杂度：O(n + m)，n 和 mm 分别为两个链表的长度
     * 空间复杂度：O(1)
     */
    public static ListNode mergeTwoLink(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode dummy = new ListNode();
        ListNode tail = dummy, p1 = l1, p2 = l2;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }

        tail.next = p1 != null ? p1 : p2;

        return dummy.next;
    }

    /**
     * 寻找链表中点
     * 用两个指针 slow 与 fast 一起遍历链表。slow 一次走一步，fast 一次走两步。那么当 fast 到达链表的末尾时，slow 必然位于中间
     * fast走1、3、5、7
     * slow走1、2、3、4
     * slow = (fast + 1) / 2
     * 当共有奇数个节点时，slow位于中间节点
     * 当共有偶数节点时，如果想slow位于中间偏左，需要fast停在倒数第2个节点，停止条件是fast.next.next != null
     * 如果想slow们于中间偏右，需要fast停在最后一个节点的下个节点，停止条件是fast.next != null
     * 时间复杂度：O(N)，其中 N 是给定链表的结点数目。
     * 空间复杂度：O(1)，只需要常数空间存放 slow 和 fast 两个指针。
     */
    public static ListNode midNode(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 打印链表
    public static void printLinkList(ListNode head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(",");
            }
            head = head.next;
        }
        System.out.println("]");
    }

}
