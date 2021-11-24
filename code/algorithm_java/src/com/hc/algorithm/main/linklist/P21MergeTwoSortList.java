package com.hc.algorithm.main.linklist;


/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 递归、链表
 */
public class P21MergeTwoSortList {

    public static void main(String[] args) {
        // 生成测试数据
        ListNode l1 = LinkTool.generateListNode(new int[]{1, 2, 4});
        LinkTool.printLinkList(l1);

        ListNode l2 = LinkTool.generateListNode(new int[]{1, 3, 4});
        LinkTool.printLinkList(l2);

        P21MergeTwoSortList p21 = new P21MergeTwoSortList();
        ListNode result = p21.mergeTwoLists(l1, l2);
        LinkTool.printLinkList(result);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        return mySolution1(l1, l2);
//        return recursion(l1, l2);
        return iterator(l1, l2);
    }

    /**
     * 方法1
     * 定义两个指针pHead和pTail，分别指向新链表的头和尾节点；初始都为null；
     * 比较l1和l2的头节点，找到数值较小节点，如果pHead为空，pHead等于此节点；如果pTail不为空，把pTail下一个节点
     * 指向此节点，建立连接，然后pTail再顺连接指向该节点，lx的头节点顺连接下移。
     * 空间复杂度：O(1)
     * 时间复杂度：O(M+N) M和N分别为两个链表的长度
     */
    private ListNode mySolution1(ListNode l1, ListNode l2) {
        // pHead指向新链表头节点，pTail指向新链表尾节点，初始都为null
        ListNode pHead = null, pTail = null;

        while (true) {
            // 先比较l1和l2的头节点，找到小数值节点
            ListNode pSmaller = null;
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {  // 相等时取l1
                    pSmaller = l1;
                    l1 = l1.next;
                } else {
                    pSmaller = l2;
                    l2 = l2.next;
                }
            } else if (l1 != null) {
                pSmaller = l1;
                l1 = l1.next;
            } else if (l2 != null) {
                pSmaller = l2;
                l2 = l2.next;
            }

            if (pSmaller == null) {
                // pSmall为空时，表示两个链表都结束，结束循环
                break;
            } else {
                // 断开取出节点和原链表联系
                pSmaller.next = null;
            }

            // 如果pHead为null，pHead指向此结点
            if (pHead == null) {
                pHead = pSmaller;
            }

            if (pTail != null) {
                // 连接尾节点和新节点，在新链表尾节点和新拿到节点间建立连续
                pTail.next = pSmaller;
            }
            // 移动尾结点，把新链表尾节点移到新节点上
            pTail = pSmaller;
        }

        return pHead;
    }

    /**
     * 递归
     * 当两个链表都不为空时，return l1[0] + merge(l1[1:], l2) 或 return l2[0] + merge(l1, l2[1:])
     * 当某链表为空时，直接返回另一链表
     * 时间复杂度：O(n + m)O(n+m)，其中 nn 和 mm 分别为两个链表的长度
     * 空间复杂度：O(n + m)O(n+m)，其中 nn 和 mm 分别为两个链表的长度
     */
    private ListNode recursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = recursion(l1.next, l2);
            return l1;
        } else {
            l2.next = recursion(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代
     * 和我的方法差不多，优化处在于：
     * 1. 只处理l1和l2都不为空的情况，当l1或l2为空时，停止遍历，直接拼接
     * 2. tail.next时不用断开与原链表连接
     * 3. 创建preHead结点，作为头结点的前一结点。最后返回preHead.next
     * 时间复杂度：O(n + m)O(n+m)，其中 nn 和 mm 分别为两个链表的长度
     * 空间复杂度：O(1)O(1)。我们只需要常数的空间存放若干变量。
     */
    private ListNode iterator(ListNode l1, ListNode l2) {
        return LinkTool.mergeTwoSortList(l1, l2);
    }

}
