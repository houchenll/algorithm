package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;

/**
 * 129. 求根节点到叶节点数字之和
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 */
public class P129RootToLeafNumSum {

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    /**
     * 递归 + 深度优先遍历
     * 定义一个和，记录所有根到叶子节点数字的总和
     * 遍历所有节点，每个节点的值是父值乘以10加上自己
     * 每个递归函数的参数是自己的节点和父节点的值，并把自己的值作为参数传给子节点
     * 如果当前节点是叶子节点，把自己的值添加到和上，并不再向下遍历
     * 0ms > 100%
     * 时间复杂度：O(N)，每个节点遍历一次
     * 空间复杂度：O(N)，递归函数调用了N次，每个递归函数中定义了一个变量
     */
    private void dfs(TreeNode node, int parentNum) {
        if (null == node) {
            // 父节点是非叶子节点，当前节点是它的某个空子节点
            return;
        }
        // 计算当前节点的值
        int currentNum = parentNum * 10 + node.val;
        if (node.left == null && node.right == null) {
            // 如果是叶子节点，添加当前节点的值到总和上
            sum += currentNum;
        } else {
            // 如果不是叶子节点，继续遍历它的左右子节点
            dfs(node.left, currentNum);
            dfs(node.right, currentNum);
        }
    }

    /**
     * 递归 + 深度优先遍历 2
     * 递归函数参数是当前节点和父节点的值
     * 当前节点的值是父节点的值乘以10加上自己的值
     * 返回值是当前节点的所有子叶子节点的值的和
     * 如果当前节点是叶子节点，返回值就是叶子节点自己的值
     * 如果当前节点不是叶子节点，返回值就是它的左右孩子的值的和，间接是它下方所有叶子节点的值的和
     * 0ms > 100%
     * 时间复杂度：O(N)，每个节点遍历一次
     * 空间复杂度：O(N)，递归函数调用了N次，每个递归函数中定义了一个变量
     */
    private int dfs2(TreeNode node, int parentSum) {
        if (null == node) {
            return 0;
        }
        int currentSum = parentSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return currentSum;
        } else {
            return dfs2(node.left, currentSum) + dfs2(node.right, currentSum);
        }
    }

}
