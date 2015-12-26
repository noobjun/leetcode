/**
 * Created by jun on 12/24/15.
 */
public class P86 {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode leftHead = left;
        ListNode rightHead = right;

        while (head != null) {
            int val = head.val;
            if (val < x) {
                left.next = new ListNode(val);
                left = left.next;
            } else {
                right.next = new ListNode(val);
                right = right.next;
            }
            head = head.next;
        }

        left.next = rightHead.next;
        return leftHead.next;
    }
}
