package com.hc.algorithm.main.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
public class P225StackByQueue {
    Queue<Integer> q1 = new LinkedList<>();    // 保存栈的队列
    Queue<Integer> q2 = new LinkedList<>();    // 辅助队列

    public P225StackByQueue() {
    }

    public void push(int x) {
        // 先把数字压入辅助队列尾部
        // offer 添加失败时返回false，不会抛出异常
        q2.offer(x);
        // 把队列1中的所有元素出队并压入辅助队列，这样队列头部就是最后压入的元素
        while (!q1.isEmpty()) {
//            q2.offer(q1.remove());    // 移除队头元素并返回，如果队列为空，抛出异常
            q2.offer(q1.poll());      // 移除队头元素并返回，如果队列为空，返回空
//            q2.offer(q1.element());    // 返回队头元素，如果队列为空，抛出异常
//            q2.offer(q1.peek());      // 返回队头元素，如果队列为空，返回空
        }
        // 交换队列1和队列2
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
    }

    public int pop() {
        // 取出队头元素并移除
        return q1.poll();
    }

    public int top() {
        // 取出队头元素但不删除
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }

}
