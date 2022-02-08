package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;

import java.util.*;

/**
 * 199. 二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class P199RightSideView {

    public static void main(String[] args) {
        TreeNode root = TreeTool.genBinaryTree(new Integer[]{1, 2, 3, null, 5, null, 4});
        wfs(root);
    }

    public List<Integer> rightSideView(TreeNode root) {

        return null;
    }

    /**
     * 深度优先搜索，且先遍历右子树，后遍历左子树
     * 2ms > 5.08%
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    private static List<Integer> dfs(TreeNode root) {
        // 保存每一层最右侧节点的值；每层只保存一次；根节点是第0层；
        Map<Integer, Integer> rightMostValue = new HashMap<>();
        // 保存树的总高度，初始为-1
        int maxDepth = -1;

        // 存储待遍历的节点；深度优先遍历，即先遍历子树再遍历根节点；先遍历右子树；
        // ArrayDeque的元素不允许为空，LinkedList的元素可以为空
        Deque<TreeNode> nodeStack = new LinkedList<>();
        // 存储待遍历节点对应的层数
        Deque<Integer> depthStack = new LinkedList<>();
        // 初始化
        nodeStack.push(root);
        depthStack.push(0);

        // 依次从栈顶取出待遍历节点队列中所有的节点
        while (!nodeStack.isEmpty()) {
            // 取出栈顶节点的元素及其在树中的层级
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            // 节点可能为空，为空则继续遍历下个节点
            if (null == node) {
                continue;
            }

            // depth会不断大小变化，取最大者为树的最大高度
            // 节点不为空时，再取这个节点的深度！！！
            maxDepth = Math.max(maxDepth, depth);

            // 如果栈顶元素的层级在map中没有，表示它是这一层第一个被访问的节点，也就是最右侧的节点，添加到map中
            if (!rightMostValue.containsKey(depth)) {
                rightMostValue.put(depth, node.val);
            }

            // 当前节点处理完毕，继续遍历它的右、左子树。先把左、右子树根节点及它们所在层级保存到待遍历队列中。右子树后添加
            nodeStack.push(node.left);
            nodeStack.push(node.right);
            depthStack.push(depth + 1);
            depthStack.push(depth + 1);
        }

        // 已遍历完树中所有节点，遍历rightMostValue，取出所有值存储在返回结果中
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= maxDepth; i++) {
            ans.add(rightMostValue.get(i));
        }
        return ans;
    }

    /**
     * 广度优先遍历
     * 逐层遍历树，每层的最后一个节点，也就是最后一次更新层号对应的val才是我们需要的
     */
    private static List<Integer> wfs(TreeNode root) {
        // 保存每一层最右侧节点的值；每层只保存一个；根节点是第0层；
        Map<Integer, Integer> rightMostValue = new HashMap<>();
        // 保存树的总高度，初始为-1
        int maxDepth = -1;

        // 存储待遍历的节点；广度优先遍历，先遍历根节点，再遍历左子树，再遍历右子树
        // ArrayDeque的元素不允许为空，LinkedList的元素可以为空
        Deque<TreeNode> nodeStack = new LinkedList<>();
        // 存储待遍历节点对应的层数
        Deque<Integer> depthStack = new LinkedList<>();
        // 初始化
        // add添加元素到队尾
        nodeStack.add(root);
        depthStack.add(0);

        // 依次从栈顶取出待遍历节点队列中所有的节点
        while (!nodeStack.isEmpty()) {
            // 取出第一个节点的元素及其在树中的层级
            // remove，取出队首元素
            TreeNode node = nodeStack.remove();
            int depth = depthStack.remove();

            // 节点可能为空，为空则继续遍历下个节点
            if (null == node) {
                continue;
            }

            // depth会不断大小变化，取最大者为树的最大高度
            // 节点不为空时，再取这个节点的深度！！！
            maxDepth = Math.max(maxDepth, depth);

            // 不断更新层号对应的节点值，最后一次更新对应的正好就是最右边的元素
            rightMostValue.put(depth, node.val);

            // 当前节点处理完毕，继续遍历它的右、左子树。先把左、右子树根节点及它们所在层级保存到待遍历队列中。右子树后添加
            // 注意，使用add，不能使用push
            // push是针对栈的操作，把元素添加在栈顶
            // add是针对队列的操作，把元素添加在队尾
            nodeStack.add(node.left);
            nodeStack.add(node.right);
            depthStack.add(depth + 1);
            depthStack.add(depth + 1);
        }

        // 已遍历完树中所有节点，遍历rightMostValue，取出所有值存储在返回结果中
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= maxDepth; i++) {
            ans.add(rightMostValue.get(i));
        }
        return ans;
    }

}
