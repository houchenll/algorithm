package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;

import java.util.*;

/**
 * 113. 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 */
public class P113PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return null;
    }

    private final Map<TreeNode, TreeNode> parents = new HashMap<>();
    private final Set<TreeNode> leaf = new HashSet<>();

    /**
     * 思路：先遍历树，找到所有节点的父节点，存储在map中，并把所有叶子节点存储到散列表中；
     * 然后对每个叶子节点，找到它的所有祖先并求和，如果和相等，添加到结果中。
     * 4ms > 5.94%
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    private List<List<Integer>> solution1(TreeNode root, int targetSum) {
        dfs(root);
        List<List<Integer>> ans = new ArrayList<>();

        for (TreeNode node : leaf) {
            int sum = 0;
            Deque<Integer> route = new LinkedList<>();
            while (node != null) {
                route.addFirst(node.val);
                sum += node.val;
                node = parents.get(node);
            }
            if (sum == targetSum) {
                ans.add(new LinkedList<>(route));
            }
        }

        return ans;
    }

    /**
     * 父节点知道子节点，子节点不知道父节点，所以父子关系只有父节点知道，所以存储父子关系的操作在父节点中进行
     */
    private void dfs(TreeNode root) {
        if (null == root) {
            return;
        }

        if (root.left != null) {
            parents.put(root.left, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parents.put(root.right, root);
            dfs(root.right);
        }
        // 存储叶子节点
        if (root.left == null && root.right == null) {
            leaf.add(root);
        }
    }

    private final List<List<Integer>> ans = new ArrayList<>();
    private final Deque<Integer> path = new LinkedList<>();

    /**
     * 官方解决1：深度优先遍历
     * 在深度优先遍历的过程中，记录路径和路径和，当到达叶子节点且和为target时，添加路径
     * 1ms > 100%
     * 时间复杂度：
     * */
    private void officialDfs(TreeNode root, int targetNum) {
        if (root == null) {
            // 到达了叶子节点的子节点，为空，返回上一级
            return;
        }
        // 每遍历到一个节点，都先把它添加到路径中，并求和
        path.offerLast(root.val);
        targetNum -= root.val;
        // 如果当前节点是叶子节点，且和为target，添加path到ans
        if (root.left == null && root.right == null && targetNum == 0) {
            ans.add(new LinkedList<>(path));
        }
        // 然后遍历子节点
        officialDfs(root.left, targetNum);
        officialDfs(root.right, targetNum);
        // 子节点遍历结束，现在需要返回上一级节点，到上一级节点时路径不包含本节点，所以在这里把本节点从path中去除
        path.pollLast();
    }

}
