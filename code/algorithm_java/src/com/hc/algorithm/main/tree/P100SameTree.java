package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;

/**
 * 100. 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class P100SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    /**
     * 深度优先遍历两棵树
     * 如果两个节点的值不相等，直接返回false
     * 如果两个节点的值相等，再分别判断它们的左子树和右子树是否相等
     * 0ms > 100%
     * 时间复杂度：O（N），每个节点遍历一次
     * 空间复杂度：O（Height），递归调用栈深度，树的高度
     */
    private boolean dfs(TreeNode m, TreeNode n) {
        if (m == null && n == null) {
            return true;
        }
        if (m == null || n == null || m.val != n.val) {
            return false;
        }
        // 两个节点都不为空且值相等，比较它们的子节点是否相等
        return dfs(m.left, n.left) && dfs(m.right, n.right);
    }

}
