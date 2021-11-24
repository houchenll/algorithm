package com.hc.algorithm.main.linklist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 * 143. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯地改变节点内部的值，而是需要实际的进行节点交换。
 */
public class P143ReorderList {

    public static void main(String[] args) {
        ListNode testLink = LinkTool.genLink(new int[]{});
        P143ReorderList p143 = new P143ReorderList();
//        p143.reorderList(testLink);
//        LinkTool.printLinkList(testLink);

        ListNode mid = LinkTool.midNode(testLink);
        LinkTool.printLinkList(mid);
    }

    public void reorderList(ListNode head) {
        solution2(head);
    }

    /**
     * 方法1：Map缓存
     * 遍历一遍链表，将各节点按顺序存储到map中，key为序号，value为节点
     * 定义l和r指向虚拟数组两端，依次向内移动，取出对应元素，添加到链表中，当l>r时停止
     * 时间复杂度：O(2N)
     * 空间复杂度：O(N)
     * 6ms > 6.77%
     */
    private void solution1(ListNode head) {
        Map<Integer, ListNode> cache = new HashMap<>();
        ListNode p = head;
        int len = 0;
        while (p != null) {
            ListNode temp = p;
            p = p.next;
            temp.next = null;
            cache.put(len, temp);
            len++;
        }

        int l = 0, r = len - 1;
        ListNode preHead = new ListNode();
        ListNode tail = preHead;
        while (l <= r) {
            tail.next = cache.get(l);
            tail = tail.next;
            if (l < r) {
                tail.next = cache.get(r);
                tail = tail.next;
            }
            l++;
            r--;
        }
        head = preHead.next;
    }

    /**
     * 方法2：使用线性表缓存
     * 利用线性表可O(1)读取的性质
     * l直接指向r，r再指向l+1；l指向r后加1，如果等于r，跳出；
     * 循环结束后，l指向空，新链表结束
     * 直接操作各个节点的指向，不用再定义preHead和tail
     * 时间复杂度：O(N)，其中 N 是链表中的节点数。
     * 空间复杂度：O(N)，其中 N 是链表中的节点数。主要为线性表的开销。
     * 3ms > 35.61%
     */
    private void solution2(ListNode head) {
        if (null == head) {
            return;
        }

        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p);
            p = p.next;
        }

        int l = 0, r = list.size() - 1;
        while (l < r) {
            list.get(l).next = list.get(r);
            l++;
            if (l == r) {
                break;
            }
            list.get(r).next = list.get(l);
            r--;
        }
        list.get(l).next = null;
    }

    /**
     * 方法3：寻找链表中点 + 链表逆序 + 合并链表
     * 目标链表即为将原链表的左半端和反转后的右半端合并后的结果
     * 1. 使用快慢指针来 O(N) 地找到链表的中间节点 O(N)
     * 2. 用迭代法实现右半段链表的反转 O(N/2)
     * 3. 将原链表的两端合并 O(N/2)
     * 1ms > 99.98%
     * 时间复杂度：O(N)，其中 N 是链表中的节点数
     * 空间复杂度：O(1)
     */
    private void solution3(ListNode head) {
        if (null == head) {
            return;
        }
        ListNode mid = findMid(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = LinkTool.reverseLink(l2);
        mergeList(l1, l2);
    }

    /**
     * 使用快慢指针找到链表中点
     * 判断fast.next.next不能为空，可以比正常查找中点提前一个位置结束，找到的中点在正常中点的前一个位置
     * 好处是方便后面断开链表前半段和后半段
     */
    ListNode findMid(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // l2.len <= l1.len，差为0或1
    // l1指向l2，l2指向l1的下一个，然后l1和l2分别右移1位
    // l1和l2右移前，事先记录下它们下个结点的位置
    void mergeList(ListNode l1, ListNode l2) {
        // 缓存下头部的下一个位置
        ListNode temp1;
        ListNode temp2;
        while (l1 != null && l2 != null) {
            temp1 = l1.next;
            temp2 = l2.next;

            l1.next = l2;
            l1 = temp1;

            l2.next = l1;
            l2 = temp2;
        }
    }

}
