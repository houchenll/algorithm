package com.hc.algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * 20. Valid Parentheses 括弧
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 */
public class P20 {

    public static void main(String[] args) {
        P20 p20 = new P20();
        long start = System.nanoTime();
        System.out.println(p20.isValid("{[()()()()]}{[()()()()]}{[()()()()]}{[()()()()]}{[()()()()]}{[()()()()]}{[()()()()]}{[()()()()]}{[()()()()]}{[()()()()]}{[()()()()]}{[()()()()]}{[()()()()]}{[()()()()]}{[()()()()]}"));
        System.out.println(System.nanoTime() - start);
    }

    /**
     * 总结
     * 1. 使用栈处理类型关闭问题
     * 2. 栈用Stack类型处理
     * 3. 字符串是字符比较使用char
     * 4. 预定义hash表，使用查哈希表法，加速判断，避免每次if判断
     * */
    public boolean isValid(String s) {
//        return stackSolution(s);
        return officialSolution(s);
    }

    /**
     * 使用栈
     * 如果栈顶元素可以关闭括弧，弹出栈顶元素；否则，把括弧压入栈顶；
     * 最后如果栈为空，表示是有效括弧
     * 时间：O(N) 空间：O(N)
     */
    private boolean stackSolution(String s) {
        /// 字符串的栈和字符栈哪个快
        /// 字符串栈耗时 72 9738 ns
        /// 字符栈耗时 101 9960ns
//        List<Character> stack = new ArrayList<>();
        /// 使用Stack替换List后，字符栈耗时 111 5596 ns，没有更快
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);

//            if (stack.size() == 0 || "(".equals(letter) || "[".equals(letter) || "{".equals(letter)) {
            if (stack.isEmpty() || '(' == letter || '[' == letter || '{' == letter) {
                // 先判断特殊情况，栈为空，或字母是( [ {时，直接压入栈
                stack.push(letter);
            } else {
                // 字母为右括弧，判断栈顶元素是否可关闭括弧；若可以，弹出栈顶元素
//                char topLetter = stack.get(stack.size() - 1);
                char topLetter = stack.pop();

                if (')' == letter && '(' == topLetter
                        || ']' == letter && '[' == topLetter
                        || '}' == letter && '{' == topLetter) {
                } else {
                    /// 若不可以关闭括弧，返回false
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }

    // Hash table that takes care of the mappings.
    private final HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public P20() {
        this.mappings = new HashMap<>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    /**
     * 思路：
     * 先考虑只包含一种括号的简单情形
     * 62 6581 ns
     */
    private boolean officialSolution(String s) {
        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }

}
