package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class P102BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        return null;
    }

    /**
     * 定义一个队列，存储当前数据中待遍历的树的节点列表。每次遍历一层所有节点。
     * 遍历一层节点的同时，把下一层的节点添加到这个队列的尾部，待下次循环时遍历。
     * 定义一个单边插入的列表，遍历每层树时，把所有元素添加到这个列表中，并把它的非空的子节点添加到队列中。
     * 1ms > 89.80%
     */
    private List<List<Integer>> solution1(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();

        if (null == root) {
            return ans;
        }

        // 存储下层待遍历的所有节点
        Queue<TreeNode> queue = new LinkedList<>();

        // 添加根节点，作为初始化
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            // 存储这一层的所有节点
            Queue<Integer> levelNodes = new LinkedList<>();
            // 遍历一层所有节点
            for (int i = 0; i < size; i++) {
                // 取出一个节点
                TreeNode node = queue.poll();
                // 先把节点添加到这一层的列表中
                levelNodes.offer(node.val);
                // 把节点的非空子节点添加到下一层的待遍历队列中
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 把这一层的所有节点添加到结果列表中
            ans.add(new LinkedList<>(levelNodes));
        }

        return ans;
    }

}
