/**
 * Created by jun on 4/25/16.
 * 230. Kth Smallest Element in a BST
 */
public class P230 {
    public int kthSmallest(TreeNode root, int k) {
        return helper(root, k)[1];
    }

    public int[] helper(TreeNode root, int k) {
        // helper returns an array size of 2, left element is how many nodes the sub-BST starts with the current node has; if the value is found, then right element is not -1
        if (root == null)
            return new int[]{0, -1};

        int[] left = helper(root.left, k);
        if (left[1] != -1)
            return left;

        if (left[0] == k - 1)
            return new int[]{0, root.val};

        int[] right = helper(root.right, k - 1 - left[0]);
        if (right[1] != -1)
            return right;

        return new int[]{left[0] + 1 + right[0], -1};
    }
}
