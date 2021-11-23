package com.hc.algorithm.leetcode;

import com.hc.algorithm.bean.TreeNode;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class P236LowestCommonAncestor {

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }

    /**
     * 方法1：深度优先遍历 + 寻找链表公共部分最后一个节点
     * 首先，深度优先遍历，找到从头节点到p和q的路径，把路径上节点分别添加到链表linkA和linkB上。
     * 找到p时向上返回，找到q时终止遍历。
     * */

}
