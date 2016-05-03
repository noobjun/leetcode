import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jun on 4/6/16.
 * 116. Populating Next Right Pointers in Each Node
 */
public class P116 {

    // efficient constant space solution
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        TreeLinkNode head = root;
        TreeLinkNode curr = null;

        while (head.left != null) {
            curr = head;

            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null)
                    curr.right.next = curr.next.left;

                curr = curr.next;
            }

            head = head.left;
        }
    }

// BFS level traverse below, but it uses O(N) space
//    public void connect(TreeLinkNode root) {
//        if (root == null)
//            return;
//
//        Queue<TreeLinkNode> q = new LinkedList<>();
//        q.offer(root);
//
//        while (!q.isEmpty()) {
//            int qSize = q.size();
//
//            for (int i = 0; i < qSize; i++) {
//                TreeLinkNode node = q.poll();
//                if (node.left != null)
//                    q.offer(node.left);
//                if (node.right != null)
//                    q.offer(node.right);
//                if (i == qSize - 1)
//                    node.next = null;
//                else
//                    node.next = q.peek();
//            }
//        }
//    }
}
