/**
 * Created by jun on 2/22/16.
 * 19. Remove Nth Node From End of List
 */

public class P19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null)
            return null;

        ListNode first = head;
        ListNode second = head;
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            prev = second;
            second = second.next;
        }

        if (prev == null)
            head = head.next;
        else
            prev.next = second.next;

        return head;
    }
}
