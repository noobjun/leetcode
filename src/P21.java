/**
 * Created by jun on 2/23/16.
 * 21. Merge Two Sorted Lists
 */
public class P21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode result = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }

        if (l1 == null)
            head.next = l2;
        else
            head.next = l1;

        result = result.next;
        return result;
    }
}
