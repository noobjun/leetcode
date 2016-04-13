import java.util.HashMap;
import java.util.Map;

/**
 * Created by jun on 4/12/16.
 * 337. House Robber III
 */
public class P337 {
    public int rob(TreeNode root) {
        return helper(root, new HashMap<TreeNode,  Integer>());
    }

    public int helper(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null)
            return 0;

        if (map.containsKey(root))
            return map.get(root);

        // rob
        int yes = root.val + (root.left == null ? 0 : helper(root.left.left, map) + helper(root.left.right, map)) +
                (root.right == null ? 0 : helper(root.right.left, map) + helper(root.right.right, map));
        // not rob
        int no = helper(root.left, map) + helper(root.right, map);
        int result = Math.max(yes, no);
        map.put(root, result);

        return result;
    }
}
