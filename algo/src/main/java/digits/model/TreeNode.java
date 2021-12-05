package digits.model;

public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(Integer val) {
        this.val = val;
    }

    TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}