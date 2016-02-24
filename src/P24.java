/**
 * Created by jun on 2/23/16.
 * 24. Swap Nodes in Pairs
 */
public class P24 {
    /**
     * The strategy for doing this problem is to declare "first" and "second" node, it will significantly reduce error
     * likelihood. Also remember to second first.next pointer to be the newHead, in case there the loop terminates this cycle,
     * it also prevents infinite loop.
     */
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
            first.next = newHead; // THIS STEP IS IMPORTANT
            prev = first;

            head = newHead;
        }

        return result.next;
    }
}
