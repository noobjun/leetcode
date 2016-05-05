/**
 * Created by jun on 5/4/16.
 * 108. Convert Sorted Array to Binary Search Tree
 */
public class P108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    TreeNode helper(int[] nums, int i, int j) {
        if (i > j)
            return null;

        int mid = (i + j) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = helper(nums, i, mid - 1);
        node.right = helper(nums, mid + 1, j);

        return node;
    }
}
