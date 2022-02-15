package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 */
public class P145PostOrderTraversal {

    /**
     * 后序遍历：[[左子树后序遍历结果]，[右子树后序遍历结果]，当前节点]
     * 递归函数：
     * 参数：当前节点
     * 返回值：以当前节点为根的子树的后序遍历结果
     * 0ms > 100%
     * 时间复杂度：O（N）
     * 空间复杂度：O（N）
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        return postTraversal(root);
    }

    private List<Integer> postTraversal(TreeNode node) {
        if (null == node) {
            return new ArrayList<>();
        }

        List<Integer> cur = new ArrayList<>();
        cur.addAll(postTraversal(node.left));
        cur.addAll(postTraversal(node.right));
        cur.add(node.val);
        return cur;
    }

}
