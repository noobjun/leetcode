import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jun on 4/26/16.
 * 272. Closest Binary Search Tree Value II
 */
public class P272 {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> prevStack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();

        while (root != null) {
            if (root.val < target) {
                prevStack.push(root);
                root = root.right;
            } else {
                nextStack.push(root);
                root = root.left;
            }
        }

        for (int i = 0; i < k; i++) {
            TreeNode prev = prevStack.isEmpty() ? null : prevStack.peek();
            TreeNode next = nextStack.isEmpty() ? null : nextStack.peek();

            if (prev == null || next != null && Math.abs(prev.val - target) > Math.abs(next.val - target)) {
                list.addLast(next.val);
                getNext(nextStack);
            } else {
                list.addFirst(prev.val);
                getPrev(prevStack);
            }
        }

        return list;
    }

    private void getPrev(Stack<TreeNode> stack) {
        TreeNode node = stack.pop();
        if (node.left != null) {
            node = node.left;

            while (node != null) {
                stack.push(node);
                node = node.right;
            }
        }
    }

    private void getNext(Stack<TreeNode> stack) {
        TreeNode node = stack.pop();
        if (node.right != null) {
            node = node.right;

            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
}
