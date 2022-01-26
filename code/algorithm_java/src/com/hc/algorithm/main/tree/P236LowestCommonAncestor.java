package com.hc.algorithm.main.tree;

import com.hc.algorithm.bean.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class P236LowestCommonAncestor {

    private TreeNode ans;

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    /**
     * dfs表示以节点root为根的树中是否包含有p和q，包含的话返回true，否则返回false
     * 包含的话分为4种情况：左子树包含、右子树包含、根节点是p、根节点是q
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        // 当root为null时，root是叶子节点的左、右子树的根节点，直接返回false，这是递归结束条件，递归向上回归
        if (root == null) {
            return false;
        }

        // 当root不为空时，root可能是根节点，也可能是叶子节点
        // 此时，在判断以当前节点为根的子树中是否包含p或q之前，先向下递归，询问左、右子树是否包含p或q
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);

        // 此时，已经知道了左、右子树是否包含p或q，就可以判断当前root节点是否是p和q的公共祖先
        // 情况一：当左子树和右子树都包含p或q时，那一定是左、右子树分别包含一个，此时root是公共祖先
        // 情况二：如果没有满足上面的条件，说明左、右子树最多只有一个包含p或q，此时如果root是p或q，而左、右子树包含另外一个，
        // 那此时root也是公共祖先。换个方式说，如果此时左、右子树有一个包含p或q，那么如果正好root包含另外一个节点，那root就是公共祖先
        // 情况三：左、右子树其中有一个包含p或q，但root不是q或q，此时root不是公共祖先
        // 情况四：左、右子树都不包含p或q，root是p或q，此时root不是公共祖先
        // 情况五：左、右子树都不包含p或q，root也不是p或q，此时root不是公共祖先
        // 所以综合起来，当情况一或情况二发生时，root是公共祖先，赋值给结果
        // 以这种方式获取的公共祖先只会出现一次，因为如果root是公共祖先，那么它的父节点的另一子树肯定不包含p或q，且父节点也不是p或q，
        // 那么父节点就不是符合下面条件的公共祖先
        if ((lson && rson) || ((lson || rson) && (root.val == p.val || root.val == q.val))) {
            ans = root;
        }

        // dfs方法表示以root为根的子树是否包含p或q
        // 所以如果lson、rson、root是p、root是q，只要任何一种情况发生，都包含了p或q，应该返回true
        // 对应上面的情况一、情况二、情况三、情况四
        return lson || rson || root.val == p.val || root.val == q.val;
    }

    /**
     * 使用map，存储父子关系
     * 因为所有节点的值都不相等，所以可以使用节点值val作为key
     */
    private final Map<Integer, TreeNode> map = new HashMap<>();

    /**
     * 使用散列表set存储p节点的所有祖先节点
     * q节点遍历自己的所有祖先节点时，查看这个祖先节点是不是也是p节点的祖先节点，如果也是，那么这个祖先节点就是最近公共祖先
     * 因为所有节点的值都不相等，所以可以使用节点值代指祖先节点
     */
    private final Set<Integer> ancestorP = new HashSet<>();

    /**
     * 方法2：存储父节点
     * 思路：先用深度优先遍历，遍历整棵树，把每个节点的父节点存储在map中，因为所以节点的值都不相等，所以用节点值作为key。
     *      然后逐级向上查询p节点的所有祖先，并存储在散列表set中
     *      最后逐级向上查询q节点的所有祖先，不用存储到set中，而是每查到一个祖先，都看下散列表中是否已包含，即这个祖先是不是也是p的祖先
     *      如果已包含，说明这个祖先也是p的祖先。因为是从向上逐级查询的，所以这个祖先就是最近公共祖先
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    private TreeNode solution2(TreeNode root, TreeNode p, TreeNode q) {
        dfs2(root);

        // 遍历p节点的所有祖先节点
        // 因为之后p节点不再有用，所以在遍历过程中可以改变p的指向，不断指向祖先节点
        // 整棵树的根节点的值没有存储在map中，所以可以在整棵的根节点停止
        // 如果p本身就是根节点，那么while循环只会执行一次
        // 遍历时，需要从p节点自身开始，注意不能漏掉p节点自身
        // 当遍历到根节点时，在添加根节点的值到祖先集合中之后，由于根节点的值没有在祖先列表中，所以获取它的祖先为null，循环结束
        while (p != null) {
            ancestorP.add(p.val);
            p = map.get(p.val);
        }

        // 遍历q节点的所有祖先节点，如果某个祖先节点的值和p节点的某个祖先相等，那么这个祖先节点就是最近公共祖先
        while (q != null) {
            if (ancestorP.contains(q.val)) {
                return q;
            }
            q = map.get(q.val);
        }

        return null;
    }

    /**
     * 深度优先遍历整棵树
     * 如果左子树或右子树不为空，就继续向下遍历
     * 终止条件，当左子树和右子树都为空时，停止递归，回上回归。即在叶子节点处向上回归
     */
    private void dfs2(TreeNode root) {
        // 由于子节点不能访问父节点，只有父节点能够访问子节点，所以存储父子关系需要在父节点进行
        // 如果有棵子树不为空，就把子树根节点和当前节点的父子关系存储在map中
        if (root.left != null) {
            map.put(root.left.val, root);
            // 当子树不为空时，继续遍历子树，直到一个节点的左、右子树都为空时停止，向上回归
            dfs2(root.left);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
            dfs2(root.right);
        }
    }

}
