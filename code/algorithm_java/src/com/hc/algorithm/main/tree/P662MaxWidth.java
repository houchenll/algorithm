package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 662. 二叉树最大宽度
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 */
public class P662MaxWidth {

    /**
     * 宽度优先搜索
     * 遍历树时，记下每个节点的位置
     * 节点的位置由它的父节点的序号及它相对于父节点的方向决定，和父节点的兄弟节点及自身的兄弟节点是否为空无关
     * 2ms > 28.06%
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)，queue
     */
    public int widthOfBinaryTree(TreeNode root) {
        Deque<ANode> queue = new LinkedList<>();
        // 初始化
        queue.offerLast(new ANode(root, 0, 1));

        // 当前层的参数
        int curDepth = 0;
        int curLeft = 1;  // 当前层第一个节点的序号

        // 最大宽度
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            ANode a = queue.pollFirst();
            if (null != a.node) {
                // 如果当前节点的层和当前层不同，说明它是新的一层的第一个节点，更新left和height
                if (a.depth != curDepth) {
                    curDepth = a.depth;
                    curLeft = a.pos;
                }
                // 每遍历到一个节点，都刷新一下宽度
                maxWidth = Math.max(maxWidth, a.pos - curLeft + 1);
                // 添加子节点
                queue.offerLast(new ANode(a.node.left, a.depth + 1, a.pos * 2));
                queue.offerLast(new ANode(a.node.right, a.depth + 1, a.pos * 2 + 1));
            }
        }

        return maxWidth;
    }

    private static class ANode {
        TreeNode node;
        int depth;
        int pos;

        public ANode(TreeNode node, int depth, int pos) {
            this.node = node;
            this.depth = depth;
            this.pos = pos;
        }
    }

}
