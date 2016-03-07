import java.util.Iterator;
import java.util.Stack;

/**
 * Created by jun on 3/5/16.
 * 173. Binary Search Tree Iterator
 * <p>
 * I initially implemented a recursive solution but that was slow. After checking the optimal solution, the hint here is to use a stack, since allowed memory usage is O(h).
 */
public class P173 {
    public class BSTIterator {
        private Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            this.stack = new Stack<>();
            while (root != null) {
                this.stack.push(root);
                root = root.left;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !this.stack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode node = this.stack.pop();
            TreeNode right = node.right;
            while (right != null) {
                this.stack.push(right);
                right = right.left;
            }
            return node.val;
        }
    }
}
