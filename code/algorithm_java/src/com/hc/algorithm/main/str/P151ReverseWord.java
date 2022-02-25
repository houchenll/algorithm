package com.hc.algorithm.main.str;

import java.util.*;

/**
 * 151. 翻转字符串里的单词
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class P151ReverseWord {

    public String reverseWords(String s) {
        return "";
    }

    /**
     * 使用语言提供的api
     * 1. 调用split将字符串按空隔分隔成多个子字符串
     * 2. 调用reverse反转排序
     * 3. 调用join使用空格连接
     * 8ms > 35%
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)，保存切割的字符串
     */
    private String solution1(String s) {
        // 去除头尾空格
        s = s.trim();
        // 使用空格分隔字符串，\\s+表示多个空格的正则
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        // 调用reverse反转列表
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    /**
     * 1. 去除头尾空格
     * 2. 逐个遍历字符串中所有字符，找出所有单词，依次存储在双端队列头部
     * 3. 双端队列转化为字符串
     * 7ms > 53%
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)，存储单词
     */
    private String solution2(String s) {
        int l = 0, r = s.length() - 1;

        // 去除头空格
        while (l <= r && s.charAt(l) == ' ') {
            l++;
        }
        // 去除尾空格
        while (l <= r && s.charAt(r) == ' ') {
            r--;
        }

        // 存储单词
        StringBuilder word = new StringBuilder();
        // 存储所有单词
        Deque<String> words = new LinkedList<>();

        // 遍历整个字符串，找出所有单词
        while (l <= r) {
            char c = s.charAt(l);
            if (word.length() > 0 && c == ' ') {
                // 单词结束，添加到双端队列中，并清空当前单词
                words.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            l++;
        }
        words.offerFirst(word.toString());

        return String.join(" ", words);
    }

}
