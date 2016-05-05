/**
 * Created by jun on 5/4/16.
 * 160. Intersection of Two Linked Lists
 */
public class P160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode A = headA;
        ListNode B = headB;


        while (A != null && B != null) {
            A = A.next;
            B = B.next;
        }

        int count = 0;
        boolean aIsShorter;
        if (A == null) {
            aIsShorter = true;
            while (B != null) {
                B = B.next;
                count++;
            }
        } else {
            aIsShorter = false;
            while (A != null) {
                A = A.next;
                count++;
            }
        }

        if (aIsShorter) {
            for (int i = 0; i < count; i++)
                headB = headB.next;
        } else {
            for (int i = 0; i < count; i++)
                headA = headA.next;
        }

        while (headA != null) {
            if (headA.equals(headB))
                return headA;

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}
