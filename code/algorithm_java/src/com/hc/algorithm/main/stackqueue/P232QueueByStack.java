package com.hc.algorithm.main.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 232. 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * 请你仅使用两个栈实现先入先出队列。
 * 队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 */
public class P232QueueByStack {

    static class MyQueue {
        // 定义两个栈，以s1为主，以s2为辅助
        private final Deque<Integer> s1 = new LinkedList<>();
        private final Deque<Integer> s2 = new LinkedList<>();
        // 队首元素，队列的第一个元素，栈s1的顶部元素
        private int front;

        public MyQueue() {

        }

        /**
         * 新添加的元素必须位于栈底
         * 为了实现这个目标，把元素添加到s1之前，先把s1中所有元素弹出并压入s2，再把新元素压入s1的底部，
         * 最后把s2中的所有元素弹出并压入s1
         */
        public void push(int x) {
            // 更新队首元素，即s1栈顶元素
            if (s1.isEmpty()) {
                front = x;
            }
            // 把s1中所有元素弹出，并压入s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            // 把新元素压入s1底部
            s1.push(x);
            // 把s2中所有元素弹出，并压入s1
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public int pop() {
            int num = s1.pop();
            if (!s1.isEmpty()) {
                front = s1.peek();
            }
            return num;
        }

        public int peek() {
            return front;
        }

        public boolean empty() {
            return s1.isEmpty();
        }
    }

}
