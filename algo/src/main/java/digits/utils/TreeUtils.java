package digits.utils;

import digits.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtils {
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
}
