package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;
import com.hc.algorithm.util.TreeTool;

/**
 * 114. 二叉树展开为链表
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class P114FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        TreeNode root = TreeTool.genBinaryTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        P114FlattenBinaryTreeToLinkedList p114 = new P114FlattenBinaryTreeToLinkedList();
        p114.flatten(root);
        TreeTool.wfp(root);
    }

    // 先序遍历到的当前节点的前一节点
    private TreeNode prev;

    /**
     * 0ms > 100%
     * 时间复杂度：O(N)
     * 空间复杂度：O(Height)
     */
    public void flatten(TreeNode root) {
        if (null == root) {
            return;
        }

        prev = root;
        // prev会修改root.right，需在此暂停下来
        TreeNode right = root.right;
        pfs(root.left);
        pfs(right);
    }

    /**
     * 递归 + 先序遍历
     * 先序遍历：[根节点，[左子树的先序遍历]，[右子树的先序遍历]]
     * 以先序遍历的顺序遍历整棵树，所有节点会以先序遍历的顺序被依次访问
     * 在递归函数外定义变量，记录当前遍历到的节点的前一节点
     * 递归函数每访问到一个节点，都把这一节点追加到前一节点的右子树上，并更新这一节点
     * 因为是单线程，所以同一层，同一时间只有一个递归函数在执行，同时并存的递归函数数量只有树的高度那么多
     */
    private void pfs(TreeNode node) {
        if (null == node) {
            return;
        }

        prev.left = null;
        prev.right = node;
        prev = node;

        TreeNode rightChild = node.right;
        pfs(node.left);    // 会修改node.right的指向，需先暂存right
        pfs(rightChild);
    }

}
