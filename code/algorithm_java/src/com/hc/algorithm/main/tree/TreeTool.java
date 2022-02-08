package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class TreeTool {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, null, 5, null, 4};
        TreeNode root = genBinaryTree(arr);
        wfp(root);
    }

    /**
     * 根据数组创建二叉树
     * root记为1号节点
     * 那么，每个节点，它的左子节点序号为2*i，右子节点为2*i + 1
     * 依次遍历所有节点，对每个节点，知道它的序号，就知道它的左右子节点的序号，
     * 如果左右子节点未超出数组范围，就创建节点，并添加在当前节点上
     */
    public static TreeNode genBinaryTree(Integer[] arr) {
        if (null == arr || arr.length == 0) {
            return null;
        }

        // 保存待遍历节点队列
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        // 保存待遍历节点的序号，从1开始记数
        Deque<Integer> indexQueue = new LinkedList<>();
        // 初始化
        TreeNode root = new TreeNode(arr[0]);
        nodeQueue.push(root);
        indexQueue.push(1);
        final int len = arr.length;

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.pollFirst();
            int index = indexQueue.pollFirst();

            if (null == node) {
                continue;
            }

            // 计算出左、右子节点的序号，并检查是否在数组范围内，如果在，就添加节点并添加在当前节点下，如果超出范围就跳过
            int leftChildIndex = index * 2;
            if (leftChildIndex <= len) {
                Integer value = arr[leftChildIndex - 1];
                if (null == value) {
                    node.left = null;
                } else {
                    TreeNode child = new TreeNode(value);
                    node.left = child;
                    // 把新节点添加到待遍历队列中
                    nodeQueue.offerLast(child);
                    indexQueue.offerLast(leftChildIndex);
                }
            }

            int rightChildIndex = index * 2 + 1;
            if (rightChildIndex <= len) {
                Integer value = arr[rightChildIndex - 1];
                if (null == value) {
                    node.right = null;
                } else {
                    TreeNode child = new TreeNode(value);
                    node.right = child;
                    // 把新节点添加到待遍历队列中
                    nodeQueue.offerLast(child);
                    indexQueue.offerLast(rightChildIndex);
                }
            }
        }

        return root;
    }

    /**
     * 广度优先遍历打印树
     */
    public static void wfp(TreeNode root) {
        if (null == root) {
            System.out.println("null tree");
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);

        System.out.print("[");

        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (null == node) {
                System.out.print("null, ");
            } else {
                System.out.print(node.val + ", ");
                // 如果是叶子节点，不添加它的子节点
                if (node.left == null && node.right == null) {
                    continue;
                }
                queue.offerLast(node.left);
                queue.offerLast(node.right);
            }
        }

        System.out.println("]");
    }

}
