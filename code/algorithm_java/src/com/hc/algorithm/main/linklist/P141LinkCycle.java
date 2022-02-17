package com.hc.algorithm.main.linklist;

import com.hc.algorithm.bean.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 141. 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 */
public class P141LinkCycle {

    public boolean hasCycle(ListNode head) {
        return false;
    }

    /**
     * 方法1：哈希查找
     * 遍历链表，把访问过的链表存放到Set中
     * 遍历到一个新结点时，先判断它是否在Set中
     * 如果在，表示有环
     * 如果新结点为空，表示无环，结束
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * 5ms > 11.13%
     */
    private boolean solution1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (set.contains(p)) {
                return true;
            }
            set.add(p);
            p = p.next;
        }
        return false;
    }

    /**
     * 方法2：对方法1的优化
     * 1. 只是判断，没要求不破坏原链表，可以直接到head操作
     * 2. 直接用set.add()的结果来判断是否已含有，少了一步判断
     * 4ms > 21.14%
     */
    private boolean solution2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 方法3：快慢指针（龟兔赛跑）
     * 1. 只读不写的算法，速度会大大快于有写操作的算法（因为写操作要等待存储器，比较慢，而只有读操作可以一直在cpu执行）
     * 时间复杂度：O(N)，其中 N 是链表中的节点数
     *           当链表中不存在环时，快指针将先于慢指针到达链表尾部，链表中每个节点至多被访问两次
     *           当链表中存在环时，每一轮移动后，快慢指针的距离将减小一。而初始距离为环的长度，因此至多移动 N 轮
     * 空间复杂度：O(1)。我们只使用了两个指针的额外空间
     * 0ms > 100%
     */
    private boolean solution3(ListNode head) {
        if (head == null || head.next == null) {
            // 链表为空或只有一个结点，没有环
            return false;
        }
        // 链表至少有两个结点，初始fast不会为空
        // while 先判断后执行，所以fast后于slow一个结点
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        // fast == slow, 快指针追上了慢指针，表明有环
        return true;
    }

}
