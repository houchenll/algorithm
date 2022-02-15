package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 863. 二叉树中所有距离为 K 的结点
 * https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class P865AllNodesInKDistance {

    private final Map<Integer, TreeNode> parents = new HashMap<>();
    private final List<Integer> ans = new ArrayList<>();

    /**
     * 重新调整树的结构，使target为根节点，父节点和左右子节点作为它的子节点
     * 这样使用深度优先遍历以target为根节点的新树，找到所有depth为k的节点即可
     * 为了可以向父节点方向遍历，每个节点都需要知道自己的父节点，所以先用深度优先遍历一遍，找到每个节点的父节点，
     * 存储在hashMap中，因为每个节点的值都不相等，所以可以使用节点值作为key
     * 为了避免重复查找，递归遍历时需要把当前节点作为from，如果目标节点和它相同就不再遍历
     * 时间复杂度：O(N)，两次深度优先遍历
     * 空间复杂度：O(N)，记录父节点需要N的空间，深度优先搜索需要N的栈空间
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParents(root);

        dfs(target, null, 0, k);

        return ans;
    }

    // 找到所有节点的父节点，存储在hashMap中
    private void findParents(TreeNode node) {
        if (node.left != null) {
            parents.put(node.left.val, node);
            findParents(node.left);
        }
        if (node.right != null) {
            parents.put(node.right.val, node);
            findParents(node.right);
        }
    }

    // 深度优先遍历以target为根的三叉树，找到所有深度为k的节点
    private void dfs(TreeNode node, TreeNode from, int depth, int k) {
        if (null == node) {
            return;
        }
        if (depth == k) {
            ans.add(node.val);
            // 不再遍历它的下一级节点
            return;
        }
        if (node.left != from) {
            dfs(node.left, node, depth + 1, k);
        }
        if (node.right != from) {
            dfs(node.right, node, depth + 1, k);
        }
        if (parents.get(node.val) != from) {
            dfs(parents.get(node.val), node, depth + 1, k);
        }
    }

}
