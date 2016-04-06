import java.util.StringTokenizer;

/**
 * Created by jun on 4/5/16.
 * 297. Serialize and Deserialize Binary Tree
 */
public class P297 {
    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "#";
            } else {
                String result = String.valueOf(root.val) + ",";
                result += root.left == null ? "#," : serialize(root.left);
                result += root.right == null ? "#," : serialize(root.right);
                return result;
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return helper(new StringTokenizer(data, ","));
        }

        public TreeNode helper(StringTokenizer tokenizer) {
            if (!tokenizer.hasMoreTokens())
                return null;

            String token = tokenizer.nextToken();
            if (token.equals("#"))
                return null;

            TreeNode node = new TreeNode(Integer.valueOf(token));
            node.left = helper(tokenizer);
            node.right = helper(tokenizer);
            return node;
        }
    }
}
