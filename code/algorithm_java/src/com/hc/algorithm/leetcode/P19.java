package com.hc.algorithm.leetcode;

import com.hc.algorithm.bean.ListNode;
import com.hc.algorithm.util.PrintUtil;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class P19 {

    public static void main(String[] args) {
        P19 p19 = new P19();
        ListNode test = PrintUtil.generateListNode(new int[]{1,2,3});
        ListNode result = p19.mySolution2(test, 3);
        PrintUtil.printLinkList(result);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        return null;
    }

    /**
     * 人和狗初始都在链表头部，之前有个绳子，长度为n-1。人拉狗顺着链表走，当绳子没拉直时，狗不动，当绳子拉直后，狗随人
     * 一起向前走。当人走到链表尾部时，狗的位置就是要删除的倒数第n个节点的位置。
     * 要点：
     * 1. 设置人和狗两个成员，中间用长为n-1的绳子拉着，用狗的位置来记录需要删除的节点位置
     * 2. 设置变量len，表明绳子是否拉直，狗是否需要跟着走
     * 3. 狗如果还在起始位置，把起始位置右移
     * 4. 狗如果不在起始位置，需要添加preDog成员，记录狗的前一节点位置
     */
    public ListNode mySolution1(ListNode head, int n) {
        // person 沿链表走到最后
        // dog 在person后n-1的位置，表示需要删除节点的位置
        // preDog记录dog的前一个结点，删除dog时使用，用于连接dog的前一节点和后一节点
        ListNode person = head, dog = head, preDog = new ListNode(1, head);

        // 人沿链表向下走，直到走到最后一个结点
        int len = 0;
        // 记录人走了几个节点
        while (person.next != null) {
            person = person.next;  // 人走到了下个结点
            len++;

            // 当人走的距离大于绳子长度时，狗需要跟着也向前走一步，狗的前一个节点也向前走一步
            if (len > n - 1) {
                dog = dog.next;
                preDog = preDog.next;
            }
        }

        // 狗的位置就是需要删除的节点的位置
        if (dog == head) {
            // 如果狗的位置就是头节点，头节点右移
            head = head.next;
        } else {
            preDog.next = dog.next;
        }

        return head;
    }

    /**
     * 看别人题解后优化版本
     * */
    public ListNode mySolution2(ListNode head, int n) {
        // 优化1：dog和person初始都指向哑节点
        ListNode pre = new ListNode(1, head), person = pre, dog = pre;

        // 优化2：绳子长为n，这样dog的下个节点是要删除的节点
        // 优化3：使用n--加while循环拉直绳子
        while (n-- > 0) {
            person = person.next;
        }

        while (person.next != null) {
            person = person.next;
            dog = dog.next;
        }

        // 优化4：dog指向要删除的节点，所以dog指向要删除节点的下一节点即可删除正确的节点；
        // 如果dog下个节点是头节点，也可在这里被删除
        dog.next = dog.next.next;

        // 优化5：pre.next指向头节点，这个头节点可能已经被通用和处理方法修改
        return pre.next;
    }

}
