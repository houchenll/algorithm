package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;

/**
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class J26ChildTree {

    /**
     * 先判断以A节点为根的树是否包含B树的，如果包含，直接返回true，如果不包含，再看A的左子树或右子树是否包含B树
     * 0ms > 100%
     * 时间复杂度：O(MN)，M为A树节点数，N为B树节点树
     * 空间复杂度：O(M)
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 两个节点都不为空时，判断A是否包含B
        return (null != A && null != B) && recv(A, B)
                || A != null && isSubStructure(A.left, B)
                || A != null && isSubStructure(A.right, B);
    }

    /**
     * 判断A树是否包含B树
     * 如果B为空，表明B树在这一分支已遍历完，A树在B树的这一分支上完全包含B树
     * 如果A为空，因为此时B不为空，所以A不包含B
     */
    private boolean recv(TreeNode a, TreeNode b) {
        if (null == b) {
            return true;
        }
        if (null == a || a.val != b.val) {
            return false;
        }
        // 到这里a和b都不为空，且它们的值相等，再判断它们的左右子树是否相等，必须同时相等
        return recv(a.left, b.left) && recv(a.right, b.right);
    }

}
