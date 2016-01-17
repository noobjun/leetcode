import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jun on 1/16/16.
 * 145. Binary Tree Postorder Traversal
 */
public class P145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        helper(root, result);
        return result;
    }

    public void helper(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        helper(root.left, result);
        helper(root.right, result);

        result.add(root.val);
    }
}




