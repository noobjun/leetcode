package facebook;

import java.util.*;

/**
 * Created by jun on 5/2/16.
 */
public class BinarySearchTreeIterator {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode node = stack.pop();
            int val = node.val;

            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            return val;
        }
    }

}
