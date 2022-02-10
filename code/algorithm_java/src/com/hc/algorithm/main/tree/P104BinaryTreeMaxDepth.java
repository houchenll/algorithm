package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class P104BinaryTreeMaxDepth {

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    /**
     * 递归 + 深度优先遍历
     * 递归函数返回以当前节点为根的子树的深度，等于左子树深度和右子树深度中的大者加1
     * 当前节点为空时返回0，此为递归终止条件
     * 0ms > 100%
     * 时间复杂度：O(N)，每个节点遍历一次
     * 空间复杂度：O(N)，每个节点作为根执行一次递归函数
     */
    private int dfs(TreeNode node) {
        if (null == node) {
            return 0;
        }
        int l = dfs(node.left);    // 左子树的深度
        int r = dfs(node.right);   // 右子树的深度
        return Math.max(l, r) + 1;    // 当前树的深度
    }

}
