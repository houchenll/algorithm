package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder，其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class P105GenBinaryTreeFromPreIn {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }

    // 存储中序遍历时每个值对应的位置
    private final Map<Integer, Integer> inPosition = new HashMap<>();

    /**
     * 递归
     * 1. 对任一棵树来说，前序遍历的结果是[根节点，[左子树的前序遍历结果]，[右子树的前序遍历结果]]，根节点总是每一个出现
     * 中序遍历的结果是[[左子树的中序遍历结果]，根节点，[右子树的中序遍历结果]]
     * 2. 如果知道了中序遍历中根节点的位置，那么就知道它的左子树和右子树分别有多少个节点，由于任一棵树的前序遍历和中序遍历节点数量
     * 是相等的，所以也就知道了对应的左右子树的前序遍历的边界
     * 3. 知道了树的左右子树的前序遍历边界和中序遍历边界后，就可以递归地构造左右子树，并添加在当前根节点下
     * 4. 确定中序遍历中根节点位置时，可以先遍历中序遍历数组，用map记录下每个节点值的位置，key是节点值，value是位置。然后对每棵树，
     * 前序遍历的第一个节点就是中序遍历的根节点，可以直接从map中查到它在中序遍历中的位置，进而可以知道左、右子树各有多少个节点
     * 2ms > 64.87%
     */
    private TreeNode solution1(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inPosition.put(inorder[i], i);
        }

        return genSubTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * 构造左子树或右子树
     * 边界参数表示该子树在前序和中序遍历中的左右边界，左闭右闭
     */
    private TreeNode genSubTree(int[] preorder, int[] inorder, int preleft, int preright, int inleft, int inright) {
        if (preleft > preright) {
            // 生成左子树时，左子树个数为0，生成右子树时，右子树个数为0，这两种情况下，preleft > preright，直接返回null
            return null;
        }

        // 构造出根节点
        TreeNode root = new TreeNode(preorder[preleft]);
        // 查询中序遍历中根节点的位置
        int inRootIndex = inPosition.get(preorder[preleft]);
        // 计算左子树和右子树的长度
        int leftTreeCount = inRootIndex - inleft;
//        int rightTreeCount = inright - inRootIndex;    // 用不到

        // 构造左子树，并添加在当前root下
        // 当无左子树时，leftTreeCount为0，preleft > preright，对这种情况，直接返回null
        root.left = genSubTree(preorder, inorder, preleft + 1, preleft + leftTreeCount, inleft, inRootIndex - 1);

        // 构造右子树，并添加在当前root下
        // 当无右子树时，preleft > preright，对这种情况，直接返回null
        root.right = genSubTree(preorder, inorder, preleft + 1 + leftTreeCount, preright, inRootIndex + 1, inright);

        // 返回当前根节点
        return root;
    }

}
