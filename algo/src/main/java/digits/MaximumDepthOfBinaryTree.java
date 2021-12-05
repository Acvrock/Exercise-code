package digits;


import digits.model.TreeNode;

import java.util.*;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 9, 20, null, null, 15, 7);
        Integer[] arrays = list.toArray(new Integer[list.size()]);
        TreeNode root = fromArray(arrays);
        int x = maxDepth(root);
        System.out.println(x);
    }


    public static TreeNode fromArray(Integer[] tree) {
        if (tree.length == 0) return null;
        TreeNode root = new TreeNode(tree[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean left = true;
        for (int i = 1; i < tree.length; i++) {
            TreeNode node = q.peek();
            if (left) {
                if (tree[i] != null) {
                    node.left = new TreeNode(tree[i]);
                    q.add(node.left);
                }
            } else {
                if (tree[i] != null) {
                    node.right = new TreeNode(tree[i]);
                    q.add(node.right);
                }
                q.remove();
            }
            left = !left;
        }
        return root;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
    }
}
