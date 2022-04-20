package com.hc.algorithm.main.linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * 1. LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * 2. int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * 3. void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 使用哈希表和双向链表来实现
 * 哈希表用于在O(1)时间内找到元素，并更新值
 * 双向链表用于把最新变动结点存在头部，最久未变动结点存在尾部
 * 46ms > 64.81%
 * 107.3MB > 58.93%
 */
public class P146LRU {
    private final Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;    // 双向链表中当前结点数量
    private final int capacity;    // cache容量
    private final DLinkedNode head = new DLinkedNode();    // 假头部
    private final DLinkedNode tail = new DLinkedNode();    // 假尾部

    public P146LRU(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        // 初始化双向链表
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 从哈希表中查找key对应的结点
     * 如果节点为null，表示结点不存在，直接返回-1
     * 如果节点存在，先把节点移到头部，然后返回值
     */
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    /**
     * 从哈希表中查找key对应的结点
     * 如果存在，修改value值，并移到头部
     * 如果不存在，创建结点，添加到哈希表，并添加到头部。
     * 此时再判断节点数量是否大于容量，如果大于，移除尾部结点，并删除哈希表对应元素
     */
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode p = new DLinkedNode(key, value);
            cache.put(key, p);
            addHead(p);
            size++;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * 删除一个结点
     * 连接待删除结点的前后两个结点
     */
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 在头部添加一个节点
     * 逆时针修改四个指向
     */
    private void addHead(DLinkedNode node) {
        // 反向
        node.prev = head.next.prev;
        head.next.prev = node;
        // 正向
        node.next = head.next;
        head.next = node;
    }

    /**
     * 把一个结点移到头部
     */
    private void moveToHead(DLinkedNode node) {
        // 从原位置删除结点
        removeNode(node);
        // 把结点添加到头部
        addHead(node);
    }

    /**
     * 移除尾部结点
     */
    private DLinkedNode removeTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }

    private static class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev, next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
