/**
 * Created by jun on 2/23/16.
 * 24. Swap Nodes in Pairs
 */
public class P24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode result = prev;
        ListNode newHead;

        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            newHead = second.next;
            second.next = first;

            prev.next = second;
            first.next = newHead; // this is needed because if the while loop terminate this cycle, then first.next would point to second, creating infinite loop
            prev = first;

            head = newHead;
        }

        return result.next;
    }
}
