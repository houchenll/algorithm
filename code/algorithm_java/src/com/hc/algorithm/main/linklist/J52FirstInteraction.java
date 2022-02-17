package com.hc.algorithm.main.linklist;

import com.hc.algorithm.bean.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * 输入两个链表，找出它们的第一个公共节点。
 * 同P160
 */
public class J52FirstInteraction {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return null;
    }

    /**
     * 方法1：哈希表缓存
     * 1. 遍历链表A，所有节点存储到set中
     * 2. 遍历链表B，检查每个节点是否在set中。第一个在set中的节点即为答案
     * 时间复杂度：O(2N)
     * 空间复杂度：O(N)
     */
    private ListNode solution1(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
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

}
