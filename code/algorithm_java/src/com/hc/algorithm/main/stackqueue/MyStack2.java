package com.hc.algorithm.main.stackqueue;

import java.util.Stack;

/**
 * 需求：
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 *
 * 要求：
 * 1. pop、push、getMin操作的时间复杂度都是O(1)
 * 2. 设计的栈类型可以使用现成的栈结构
 *
 * 实现方案二
 * 优点：弹出操作稍省时间
 * 缺点：压入时稍费空间
 * */
public class MyStack2 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int newNum) {
        if (stackMin.isEmpty()) {
            stackMin.push(newNum);
        } else if (newNum < getMin()) {
            stackMin.push(newNum);
        } else {
            // 为什么重复添加一次？方便弹出操作
            int newMin = stackMin.peek();
            stackMin.push(newMin);
        }
        stackData.push(newNum);
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("your stack is empty");
        }
        stackMin.pop();
        return stackData.pop();
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("your stack is empty");
        }

        return stackMin.peek();
    }

}
