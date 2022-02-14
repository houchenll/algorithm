package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * 返回和最大的路径的和
 */
public class P124BinaryTreeMaxPathSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    /**
     * 深度优先遍历，递归遍历所有节点，计算每个节点的最大贡献值
     * 最大贡献值指以该节点为顶点的子树可以为包含它的路径提供多大的增益
     * 空节点为0，叶子节点为它自身的值，非叶节点为节点本身的值和它较大子节点贡献值的和
     * 如果一个节点子节点的贡献值小于0，则对这个节点来说，没有贡献，不加子节点
     * 一个节点的最大路径和是它的节点值和左右子节点贡献值的和，如果左右子节点贡献值为负数，则不添加
     * 时间复杂度：O(N)
     * 空间复杂度：O(Height)
     */
    private int maxGain(TreeNode node) {
        if (null == node) {
            return 0;
        }

        // 递归计算左右子节点的贡献值，只有当贡献值大于0时，才计算它的贡献
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和是它本身的值和左右节点非负贡献值的和，如果为负，则不选取
        int sum = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, sum);

        // 当前节点的贡献值是子节点贡献值的较大者加上它自身的值
        return node.val + Math.max(leftGain, rightGain);
    }

}
