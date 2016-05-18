package facebook;

/**
 * Created by jun on 5/16/16.
 */
public class PopulateRightPointer {

    public static class TreeLinkNode {
        TreeLinkNode left, right, next;
        int val;
    }

    public void connect(TreeLinkNode root) {

        if (root == null)
            return;


        TreeLinkNode head, curr, prev;

        head = root;


        while (head != null) {
            curr = head;
            prev = null;
            head = null;

            while (curr != null) {

                if (curr.left != null) {
                    if (prev == null)
                        head = curr.left;
                    else
                        prev.next = curr.left;

                    prev = curr.left;
                }

                if (curr.right != null) {
                    if (prev == null)
                        head = curr.right;
                    else
                        prev.next = curr.right;

                    prev = curr.right;
                }

                curr = curr.next;
            }
        }
    }
}
