package facebook;

import java.util.*;


/**
 * Created by jun on 5/3/16.
 */
public class VerticalTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> oq = new LinkedList<>();
        q.add(root);
        oq.add(0);

        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode node = q.poll();
                int offset = oq.poll();

                map.putIfAbsent(offset, new LinkedList<Integer>());
                map.get(offset).add(node.val);

                if (node.left!=null){
                    q.offer(node.left);
                    oq.offer(offset-1);
                }

                if (node.right!=null){
                    q.offer(node.right);
                    oq.offer(offset+1);
                }
            }
        }

        for (List<Integer> values : map.values()) {
            result.add(values);
        }

        return result;
    }


}
