package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;

/**
 * 112. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 */
public class P112PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    /**
     * 深度优先遍历
     * 在深度优先遍历的过程中，每深入一层，就添加当前结点值到祖先节点的和上
     * 如果当前是叶子节点，且和为target，返回true
     * 如果子树返回true，父树也返回true
     * <p>
     * 0ms > 100%
     * 时间复杂度：O(N)，所有节点遍历一遍
     * 空间复杂度：O(N)，函数调用栈最高N层
     *
     * @param sum 当前祖先节点的节点值之和
     */
    private boolean dfs(TreeNode root, int targetSum, int sum) {
        if (null == root) {
            // 根节点为空，或者是一个非空节点的空子树，这两种情况下会走到这里
            // 这种路径不是要找的叶子路径，直接返回false
            return false;
        }

        // 到当前节点为止，路径上所有节点的总和
        int currentSum = root.val + sum;

        // 找到叶子节点时，直接判断总和是否为targetSum
        if (root.left == null && root.right == null) {
            return currentSum == targetSum;
        }

        // 对非叶子节点，左子树或右子树中任一个路径返回true，即表示找到了总和为targetSum的路径，返回true
        return dfs(root.left, targetSum, currentSum) || dfs(root.right, targetSum, currentSum);
    }

    /**
     * 上一种方法的变形
     * 最后到叶子节点时，不是判断与祖先节点值的和是否等于targetSum，而是每过一个祖先节点都从targetSum中减去它们的节点值
     * 如果最后到叶子节点时，原来方法的总和等于targetSum，那么此时的剩余的差也正好等于叶子节点的值
     */
    private boolean dfs2(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return dfs2(root.left, targetSum - root.val) || dfs2(root.right, targetSum - root.val);
    }

}
