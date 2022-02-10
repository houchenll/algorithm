package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;

/**
 * 543. 二叉树的直径
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * */
public class P543BinaryTreeDiameter {
    private int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        // 以root初始化
        ans = 1;
        depth(root);
        return ans - 1;
    }

    /**
     * 递归 + 深度优先遍历
     * 1. 一条路径的长度为该路径经过的节点数减1，所以求最长路径长度，等价于求经过节点数最多的路径
     * 2. 任意一条路径，都可以看成是以某个节点为根节点，从其左儿子和右儿子向下遍历的路径拼接而成
     * 3. 假设我们知道该节点的左儿子节点向下遍历最多经过L个节点，右儿子节点向下遍历最多经过R个节点，那么以该节点为起点的路径
     *    经过节点的最大值为L+R+1
     * 4. 设以节点node为起点的路径经过节点数最大为d，那么二叉树的直径就是所有节点d的最大值减1
     * 5. 定义递归函数depth，计算d，函数返回以该节点为根子树的深度，先递归调用左儿子和右儿子求得以它们为根的子树的深度L和R，
     *    则以该节点为根的子树的深度为max(L,R)+1，该节点的d为L+R+1
     * 6. 递归调用每个节点，并设一个全局变量ans记录d的最大值，最后返回ans-1即可
     * 0ms > 100%
     * 时间复杂度：O(N)，每个节点都遍历一次
     * 空间复杂度：O(Height)，递归函数调用栈的深度，即二叉树的深度。每层树需要调用一次递归函数。每个递归函数中只有两个局部变量。
     */
    private int depth(TreeNode node) {
        if (null == node) {
            // 访问到了空节点
            return 0;
        }
        int l = depth(node.left);    // 以左儿子为根节点的子树的深度
        int r = depth(node.right);   // 以右儿子为根节点的子树的深度
        // 以node为起点的路径经过的最大节点数为 l + r + 1
        ans = Math.max(ans, l + r + 1);
        // 以node为根节点的子树的深度
        return Math.max(l, r) + 1;
    }

}
