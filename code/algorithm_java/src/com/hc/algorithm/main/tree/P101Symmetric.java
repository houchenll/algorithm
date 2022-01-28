package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class P101Symmetric {

    public boolean isSymmetric(TreeNode root) {
        return false;
    }

    /**
     * 方法1：递归
     * 二叉树对称，转化为两棵树左右镜像，镜像的条件是：1. 根节点相等；2. 每棵树的左子树与另一棵树的右子树对称；
     * 使用递归函数，通过同步移动两个指针的方法来遍历树，p指针和q指针初始都指向根节点，随后p右移时，q左移，
     * p左移时，q右移。每次检查p和q节点的值是否相等，如果相等再判断左右子树是否对称
     * 本方法用于检查p树和q树是否对称，对称的条件是：
     * 1. 它们的根节点值相等
     * 2. 它们的左子树和另一棵树的右子树对称，即对子树递归调用
     * 0ms > 100%
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    /**
     * 方法2：迭代法
     * 把递归转化为迭代法，通常使用队列
     * 初始时把根节点入队两次
     * 每次从队列中取两个节点，如果对称，它们的值应该相等，而且它们的左右子树镜像
     * 然后将两个结点的左右子结点按相顺序插入队列中
     * 当队列为空，或者检查到不对称时，结束
     * 1ms > 24.89%
     * 时间复杂度：O(N)
     * 空间复杂度：每个节点最多入队、出队一次，渐进空间复杂度为O(N)
     */
    private boolean check2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();

        // 先把两棵树的根结点入队尾部
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            // 如果队列不为空，每次取出队尾的两个结点
            TreeNode m = queue.poll();
            TreeNode n = queue.poll();

            // 如果都是空，继续循环取后面的两个结点
            if (null == m && null == n) {
                continue;
            }
            // 如果两个节点一个为空，另一个不为空，或者它们的值不相等，表示不对称，直接返回
            if ((m == null || n == null) || m.val != n.val) {
                return false;
            }

            // 如果两个结点本身相等，继续检查它们的左右子树是否相等，方法是把左右子树分别镜像地插入队列中
            queue.offer(m.left);
            queue.offer(n.right);

            queue.offer(m.right);
            queue.offer(n.left);
        }

        return true;
    }

}
