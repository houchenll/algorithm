package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;

/**
 * 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class P226InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        return null;
    }

    /**
     * 递归
     */
    private TreeNode mySolution(TreeNode root) {
        return invert(root);
    }

    /**
     * 递归函数
     * 用于翻转以当前节点为根节点的子树
     * 把左子树翻转后的树作为右儿子，把右子树翻转后的树作为左儿子
     * 如果当前节点为空，递归停止
     * 0ms > 100%
     * 时间复杂度：O(N)，每个节点遍历一次
     * 空间复杂度：O(N)，每个节点作为根节点调用一次递归函数
     */
    private TreeNode invert(TreeNode node) {
        if (node == null) {
            return null;
        }

        // 因为node.right之后要用，所以先把左右子树的翻转结果缓存起来
        TreeNode left = invert(node.left);
        TreeNode right = invert(node.right);

        node.right = left;
        node.left = right;
        return node;
    }

}
