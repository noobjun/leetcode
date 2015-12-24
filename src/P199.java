import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jun on 12/23/15.
 * 199. Binary Tree Right Side View
 */
public class P199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();

        if (root == null)
            return result;

        List<TreeNode> prev = new ArrayList<TreeNode>();
        List<TreeNode> next = new ArrayList<TreeNode>();

        prev.add(root);

        while (!prev.isEmpty()) {
            result.add(prev.get(prev.size() - 1).val);

            for (TreeNode node : prev) {
                if (node.left != null)
                    next.add(node.left);
                if (node.right != null)
                    next.add(node.right);
            }

            prev = next;
            next = new ArrayList<TreeNode>();
        }

        return result;
    }
}
