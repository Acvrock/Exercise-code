package digits;

import digits.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 9, 20, null, null, 15, 7);


    }


    public static TreeNode fromArray(Integer[] tree) {
        if (tree.length == 0) return null;
        TreeNode root = new TreeNode(tree[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for (int i = 1; i < tree.length; i++) {
            TreeNode node = q.peek();
            if (node.left == null) {
                node.left = new TreeNode(tree[i]);
                if (tree[i] != null) q.add(node.left);
            } else if (node.right == null) {
                node.right = new TreeNode(tree[i]);
                if (tree[i] != null) q.add(node.right);
                q.remove();
            }
        }
        return root;
    }

    public int maxDepth(TreeNode root) {
        return 0;
    }
}
