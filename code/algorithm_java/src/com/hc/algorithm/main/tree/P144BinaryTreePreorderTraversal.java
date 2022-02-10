package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class P144BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }

    /**
     * 前序遍历结果：[当前节点，[左子树的前序遍历结果]，[右子树的前序遍历结果]]
     * 先把当前节点添加到结果中
     * 再把所有左子树节点添加到结果中
     * 再把所有右子树节点添加到结果中
     * 遇到空节点时终止递归
     * 0ms > 100%
     * 时间复杂度：O(N)，每个节点遍历一次
     * 空间复杂度：O(N)，每个节点添加一次，递归函数执行N次，每个节点作为根节点执行一次，另外每个叶子节点的左右子空节点也都各执行一次
     */
    private void preorder(TreeNode node, List<Integer> ans) {
        if (null == node) {
            return;
        }
        ans.add(node.val);
        preorder(node.left, ans);
        preorder(node.right, ans);
    }

}
