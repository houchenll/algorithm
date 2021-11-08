package com.hc.algorithm.leetcode;

import com.hc.algorithm.bean.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class P103BinaryTreeTraversal {

    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return null;
    }

    /**
     * 按树的层序遍历法，即广度优先遍历
     * 创建一个存储节点的队列，树中遍历到的每个不为空节点都存储在这个节点队列中
     * 每层遍历结束后，节点队列都存储着下一层的所有结点
     * 遍历节点队列当前所有结点，就可以遍历完树的一层中所有结点
     * 遍历的过程中，把下一层的结点，当不为空时，添加到结点队列的尾部
     * 当结点队列为空时，表示树遍历结束
     * <p>
     * 使用双端队列存储每层节点的值，方便根据顺序不同从两侧分别插入
     * <p>
     * 时间复杂度：O(N)，树中所有节点遍历一次
     * 空间复杂度：O(N)，需要维护存储节点的队列和存储节点值的双端队列
     */
    private List<List<Integer>> solution1(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        // 从上到下，从左向右，遍历二叉树的。把遍历到的每个节点添加到这个队列尾部
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        // 初始化节点队列
        nodeQueue.offer(root);
        // 是否从左向右输出
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            // 双端队列，可以从双端插入
            Deque<Integer> levelList = new LinkedList<>();

            // 遍历队列当前所有元素，并添加到输出数组中
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                // 取出队列头部一个元素
                TreeNode curNode = nodeQueue.poll();
                // 如果从左向右输出，插入到尾部，如果从右向左输出，插入到头部
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                // 再查看当前结点的两个子结点，如果不为空，添加到节点队列的尾部，等待下一轮(层)遍历
                // 检查不为空，可以保证只有有值(存在)的节点，才会被添加到队列中
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            // 当前队列长度遍历结束，表示一层遍历结束
            // 把遍历到的数值列表添加到输出列表中
            ans.add(new LinkedList<>(levelList));
            // 改变输出顺序
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }

}
