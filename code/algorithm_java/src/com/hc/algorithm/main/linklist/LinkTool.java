package com.hc.algorithm.main.linklist;

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
        ListNode prev = tail.next;
        // p为当前链表的头结点
        ListNode p = head;

        while (prev != tail) {
            // 暂存当前头结点的下一个结点
            ListNode nex = p.next;

            // 把当前头结点插入到翻转后列表的头部
            p.next = prev;
            prev = p;

            // 把暂存的头结点的下一个结点作为新的头结点
            p = nex;
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
        ListNode hair = new ListNode(0);

        while (head != null) {
            // p指向当前头结点
            ListNode p = head;
            // head指向头结点下一个结点
            head = p.next;
            // p结点插入到新链表头部
            p.next = hair.next;
            hair.next = p;
        }

        return hair.next;
    }

    /**
     * 合并两个有序链表
     * 1. 只处理l1和l2都不为空的情况，当l1或l2为空时，停止遍历，直接拼接
     * 2. tail.next时不用断开与原链表连接
     * 3. 创建preHead结点，作为头结点的前一结点。最后返回preHead.next
     * 时间复杂度：O(n + m)，n 和 mm 分别为两个链表的长度
     * 空间复杂度：O(1)
     */
    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode preHead = new ListNode();
        ListNode tail = preHead, p1 = l1, p2 = l2;

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

        return preHead.next;
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
