package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;

/**
 * 110. 平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 */
public class P110BalancedTree {
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBalanced;
    }

    /**
     * 使用递归 + 深度优先遍历
     * 定义全局变量，标记是否是平衡树，默认true
     * 当全局变量是false时，直接返回
     * 先递归获取左子树和右子树的高度，然后比较高度差，最后返回当前高度
     *
     * @param node 以当前节点为根的子树的高度
     * 时间复杂度：O(N)
     * 空间复杂度：O(Height)
     */
    private int dfs(TreeNode node) {
        if (!isBalanced) {
            // 只要有节点已经是非平衡，整棵树都是非平衡，不用再比较，直接返回
            return 0;
        }
        if (null == node) {
            return 0;
        }

        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);
        // 可能别的递归函数把isBalanced默为了false，但是当前方法把它置为了true，所以需要&&一下，保证false优先
        isBalanced = Math.abs(leftHeight - rightHeight) <= 1 && isBalanced;
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
