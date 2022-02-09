package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 958. 二叉树的完全性检验
 * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
 * 给定一个二叉树的root，确定它是否是一个完全二叉树。
 * 在一个完全二叉树中，除了最后一个关卡外，所有关卡都是完全被填满的，并且最后一个关卡中的所有节点都是尽可能靠左的。
 */
public class P958CheckBinaryCompleteness {

    /**
     * 广度优先遍历
     * 完全二叉树指除最后一行外，上面所有行都被填满，且最后一行的所有节点都靠左对齐，没有空隙
     * 如果对根节点标记为1，从上到下，从左向右对完全二叉树中所有节点标号，那么v号节点的左子节点标号为2*v，右子节点标号为2*v+1
     * 如果是完全二叉树，那么广度优先遍历结束后，最后一行最后一个节点的标号应该等于节点的总个数
     * 不遍历空节点，如果是非完全二叉树，空节点没有遍历，那么遍历到的节点个数会小于最后一个节点的编号
     * 1 ms > 79.23%
     * 时间复杂度：O(N)，所有节点遍历了一遍
     * 空间复杂度：O(N)，每个节点存储了一次
     */
    public boolean isCompleteTree(TreeNode root) {
        // 存储已遍历过的节点的节点和标号
        // 使用列表而不是队列或栈是因为，最后需要获取最后一个节点和所有节点的个数，所以用列表更方便
        List<ANode> nodes = new ArrayList<>();

        // 初始化
        nodes.add(new ANode(root, 1));

        // 当前遍历到的列表中的节点的序号
        int i = 0;
        while (i < nodes.size()) {
            // 取下一个未遍历的节点
            ANode aNode = nodes.get(i++);

            // 如果节点为空，跳过，如果节点不为空，添加它的左、右子节点到列表中，等待被遍历
            // 节点会被从上到下，从左到达的遍历到，实现了广度优先遍历
            // 不遍历空节点
            if (aNode.node != null) {
                if (null != aNode.node.left) {
                    nodes.add(new ANode(aNode.node.left, aNode.code * 2));
                }
                if (null != aNode.node.right) {
                    nodes.add(new ANode(aNode.node.right, aNode.code * 2 + 1));
                }
            }
        }

        // 如果最后一个节点的序号等于总节点个数，就是满二叉树，否则不是
        return nodes.get(nodes.size() - 1).code == nodes.size();
    }

    // annotate node
    private static final class ANode {
        TreeNode node;
        int code;

        public ANode(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }

}
