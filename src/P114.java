/**
 * Created by jun on 5/18/16.
 * 114. Flatten Binary Tree to Linked List
 */
public class P114 {
    public void flatten(TreeNode root) {
        // pre order traversal
        helper(root);
    }

    public TreeNode[] helper(TreeNode root) {
        if (root == null)
            return new TreeNode[]{null, null};

        TreeNode[] left = helper(root.left);
        TreeNode[] right = helper(root.right);

        root.left = null; // important, need to null out left
        if (left[0]!=null){
            root.right = left[0];
            left[1].right = right[0];
        } else{
            root.right=right[0];
        }

        TreeNode tail = root;
        if (right[1]!=null)
            tail = right[1];
        else if (left[1]!=null)
            tail = left[1];

        return new TreeNode[]{root, tail};
    }
}
