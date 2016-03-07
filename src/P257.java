import java.util.LinkedList;
import java.util.List;

/**
 * Created by jun on 3/6/16.
 * 257. Binary Tree Paths
 */
public class P257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        helper(root, "", result);
        return result;
    }

    public void helper(TreeNode root, String current, List<String> result) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            result.add(current + String.valueOf(root.val));
            return;
        }

        if (root.left != null)
            helper(root.left, current + String.valueOf(root.val) + "->", result);

        if (root.right != null)
            helper(root.right, current + String.valueOf(root.val) + "->", result);
    }
}
