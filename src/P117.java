/**
 * Created by jun on 5/2/16.
 * 117. Populating Next Right Pointers in Each Node II
 */
public class P117 {
    public static void main(String[] args) {
        TreeLinkNode root1 = new TreeLinkNode(1);

        TreeLinkNode root2 = new TreeLinkNode(2);
        root1.left = root2;

        TreeLinkNode root3 = new TreeLinkNode(3);
        root2.left = root3;

        P117 p = new P117();
        p.connect(root1);
    }

    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        TreeLinkNode head = root;
        TreeLinkNode prev = null;
        TreeLinkNode curr = null;

        while (head != null) {
            curr = head;
            prev = null;
            head = null; // KEY, without this, infinite loop
            while (curr != null) {
                if (curr.left != null) {
                    if (prev != null)
                        prev.next = curr.left;
                    else
                        head = curr.left; // KEY, it needs to find the start of next level, which might not be head.left as previous problem
                    prev = curr.left;
                }

                if (curr.right != null) {
                    if (prev != null)
                        prev.next = curr.right;
                    else
                        head = curr.right; // KEY
                    prev = curr.right;
                }

                curr = curr.next;
            }
        }
    }
}
