package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
public class P94BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        return inorder(root);
    }

    /**
     * 递归
     * 中序遍历结果为：[[左子树的中序遍历结果], 根节点, [右子树的中序遍历结果]]
     * 每个节点都可以视为以它为顶点的子树的根，所以对每个节点都应用同样的规则
     * 递归函数返回以该节点为根的子树的中序遍历结果
     * 0ms > 100%
     * 时间复杂度：O(N)，所有节点遍历一次
     * 空间复杂度：O()
     */
    private List<Integer> inorder(TreeNode node) {
        if (null == node) {
            return new ArrayList<>();
        }

        List<Integer> left = inorder(node.left);     // 左子树的中序遍历结果
        List<Integer> right = inorder(node.right);   // 右子树的中序遍历结果
        List<Integer> cur = new ArrayList<>();       // 当前树的中序遍历结果
        cur.addAll(left);
        cur.add(node.val);
        cur.addAll(right);
        return cur;
    }

    /**
     * 递归2
     * 把返回结果放在递归函数中，每次都先把左子树的节点添加进去，再添加当前节点，最后添加右子树的所有节点
     * 时间复杂度：O(N)，每个节点遍历一遍
     * 空间复杂度：O(N)，每个节点添加一次
     */
    public List<Integer> solution2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder2(root, ans);
        return ans;
    }

    private void inorder2(TreeNode node, List<Integer> ans) {
        if (null == node) {
            return;
        }

        // 把左子树的所有节点都添加到ans中
        inorder2(node.left, ans);
        // 把当前节点添加到ans中
        ans.add(node.val);
        // 把右子树的所有节点都添加到ans中
        inorder2(node.right, ans);
    }

}
