package com.hc.algorithm.main.linklist;

import com.hc.algorithm.bean.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * 138. 复制带随机指针的链表
 */
public class P138CopyListWithRandomPoint {

    // map 需要定义在递归方法外部
    // 存什么？key是原链表中节点，value是复制链表中节点
    // 作用：避免重复创建
    Map<Node, Node> pair = new HashMap<>();

    public Node copyRandomList(Node head) {
        return null;
    }

    /**
     * 方法1：回溯 + 哈希表
     * 返回值是本节点对应的复制节点
     */
    private Node solution1(Node head) {
        if (null == head) {
            return null;
        }
        // 如果一个节点已被复制，避免重复复制
        if (!pair.containsKey(head)) {
            // 先生成本节点的复制节点，再在递归中复制得到next和random的复制节点
            Node node = new Node(head.val);
            // 先把node保存在map中，再生成它的后续节点，因为后续节点生成时需要查询map
            pair.put(head, node);
            node.next = solution1(head.next);
            node.random = solution1(head.random);
        }
        return pair.get(head);
    }

}
