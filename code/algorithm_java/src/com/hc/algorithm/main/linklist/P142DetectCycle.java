package com.hc.algorithm.main.linklist;

import com.hc.algorithm.bean.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class P142DetectCycle {

    public ListNode detectCycle(ListNode head) {
        return null;
    }

    /**
     * 方法1：哈希表
     * 遍历链表，每查看一个节点，都检查下是否已访问过，如果已访问过，说明有环，返回这个节点，否则无环，返回null
     * 时间复杂度：O(N)，每个节点都访问一遍
     * 空间复杂度：O(N)，每个节点都存储一次
     * 4ms > 12.59%
     */
    private ListNode solution1(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (visited.contains(cur)) {
                return cur;
            } else {
                visited.add(cur);
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 方法2：快慢指针
     * 初始时，定义slow和fast两个指针指针头部。slow每次移动一步，fast每次移动两步。
     * 如果有环，定义环外距离是a，环内相遇前距离为b，相遇后距离为c。
     * slow在环内移动第一圈时，fast会和它相遇。
     * 相遇时，slow移动距离a+b，fast移动距离a+n(b+c)+b，因为fast走的距离是slow的2倍，
     * 所以a+n(b+c)+b=2(a+b)，解得a=(n-1)(b+c)+c
     * 表示环外距离正好等于多环距离加c，这样的话，在快慢指针相遇时，定义指针ptr指向头部
     * 同时移动它和慢指针，它们会相遇在环的起始节点
     * 如果fast移到链表尾部仍未相遇slow，表示无环
     * 0ms > 100%
     * 时间复杂度：O(N)，其中 N 为链表中节点的数目。在最初判断快慢指针是否相遇时，slow 指针走过的距离不会超过链表的总长度；
     * 随后寻找入环点时，走过的距离也不会超过链表的总长度。因此，总的执行时间为 O(N)+O(N)=O(N)。
     * 空间复杂度：O(1)，我们只使用了 slow,fast,ptr 三个指针
     */
    private ListNode solution2(ListNode head) {
        if (null == head || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇了，有环
            if (fast == slow) {
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return null;
    }

}
