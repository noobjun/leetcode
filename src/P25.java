/**
 * Created by jun on 2/24/16.
 * 25. Reverse Nodes in k-Group
 */
public class P25 {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;

        P25 p = new P25();
        p.reverseKGroup(one, 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode prevHead = result;

        while (checkN(head, k)) { // while next k are not null
            ListNode newTail = head;
            ListNode prev;
            ListNode next = head.next;

            for (int i = 0; i < k - 1; i++) {
                prev = head;
                head = next;
                next = head.next;
                head.next = prev;
            }

            prevHead.next = head;
            newTail.next = next;
            prevHead = newTail;
            head = next;
        }

        return result.next;
    }

    public boolean checkN(ListNode head, int k) {
        for (int i = 0; i < k; i++) {
            if (head == null)
                return false;
            else
                head = head.next;
        }
        return true;
    }
}
