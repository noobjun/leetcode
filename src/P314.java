import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created by jun on 4/6/16.
 * 314. Binary Tree Vertical Order Traversal
 */
public class P314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;

        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>(); // stores TreeNodes
        Queue<Integer> p = new LinkedList<>(); // stores index

        q.offer(root);
        p.offer(0);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int index = p.poll();
            map.putIfAbsent(index, new LinkedList<>());
            map.get(index).add(node.val);
            if (node.left != null) {
                q.offer(node.left);
                p.offer(index - 1);
            }
            if (node.right != null) {
                q.offer(node.right);
                p.offer(index + 1);
            }
        }

        result.addAll(map.values());
        return result;
    }
}
