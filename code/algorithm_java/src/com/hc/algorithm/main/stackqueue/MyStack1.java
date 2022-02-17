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
 * 实现方案一
 * */
public class MyStack1 {

    private Stack<Integer> minStack;
    private Stack<Integer> dataStack;

    public MyStack1() {
        minStack = new Stack<>();
        dataStack = new Stack<>();
    }

    public void push(int newData) {
        if (minStack.isEmpty()) {
            minStack.push(newData);
        } else if (newData <= getMin()) {
            minStack.push(newData);
        }

        dataStack.push(newData);
    }

    public int pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }

        int value = dataStack.pop();
        if (value == getMin()) {
            minStack.pop();
        }

        return value;
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }

        return minStack.peek();
    }

}
