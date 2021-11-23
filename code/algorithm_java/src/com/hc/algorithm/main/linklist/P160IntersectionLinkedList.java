package com.hc.algorithm.main.linklist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
public class P160IntersectionLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return null;
    }

    /**
     * 方法1：哈希表缓存一个链表
     * 遍历链表A，把每个结点都保存在哈希表中
     * 遍历链表B，查看当前结点是否在哈希表中。
     * 如果在，则当前结点和之后的所有结点都在哈希表中，返回当前结点即可。
     * 如果不在，继续查看下一个结点。如果遍历完链表B仍没有，则返回null。
     * 8ms > 11.53%
     * 时间复杂度：O(m+n)，m、n分别是两个链表的长度
     * 空间复杂度：O(m)
     */
    private ListNode hashSolution(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> cache = new HashMap<>();
        ListNode p = headA;
        while (p != null) {
            cache.put(p, p.val);
            p = p.next;
        }

        p = headB;
        while (p != null) {
            if (cache.containsKey(p)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    /**
     * 方法1：哈希缓存优化版
     * 1. 缓存时，只需用到结点，所以用Set即可，不必用Map
     * 7ms > 24.07%
     */
    private ListNode hashSolutionPro(ListNode headA, ListNode headB) {
        Set<ListNode> cache = new HashSet<>();
        ListNode p = headA;
        while (p != null) {
            cache.add(p);
            p = p.next;
        }

        p = headB;
        while (p != null) {
            if (cache.contains(p)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    /**
     * 方法2：双指针
     * 使用双指针法可以把空间复杂度降到1
     * 步骤：pA和pB分别指向两个链表的头部，每次同时操作两个指针向右移到一步，当两个指针到达同一个结点或者到达Null时，返回。如果遍历到尾部仍
     * 没有达到结束条件，则pA到达尾部后指向链表B头部，pB到达尾部时指向链表A头部，继续执行。
     * 证明：设链表A长度为m，未重复部分有a个结点，重复部分有c个结点，链表B长度为n，未重复部分有b个结点，重复部分有c个结点。
     * 情况一：两个链表相交
     * 如果a==b，则两个指针会同时到达c部分的起始结点，直接返回
     * 如果a!=b，则pA指针到达尾部时走了a+c个结点，pB指针到达尾部时走了b+c个结点，继续走
     * 情况二：两个链表不相交
     * 如果m==n，则pA和pB同时到达尾部null，返回
     * 如果m!=n，则两个指针都会遍历完两个链表，分别走了m+n节点、n+m节点后，同时到达尾部null，返回
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(1)
     * 1ms > 99.98%
     */
    private ListNode twoPointSolution(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
