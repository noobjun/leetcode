/**
 * Created by jun on 2/27/16.
 * 298. Binary Tree Longest Consecutive Sequence
 */
public class P298 {
    private int max;

    public int longestConsecutive(TreeNode root) {
        max = 0;
        helper(root, 1);
        return max;
    }

    public void helper(TreeNode root, int current) {
        if (root == null)
            return;

        this.max = Math.max(max, current);

        if (root.left != null) {
            if (root.left.val == root.val + 1) {
                helper(root.left, current + 1);
            } else {
                helper(root.left, 1);
            }
        }

        if (root.right != null) {
            if (root.right.val == root.val + 1) {
                helper(root.right, current + 1);
            } else {
                helper(root.right, 1);
            }
        }
    }
}
