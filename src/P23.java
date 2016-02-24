import java.util.PriorityQueue;

/**
 * Created by jun on 2/23/16.
 * 23. Merge k Sorted Lists
 */
public class P23 {
    /**
     * Runtime complexity of this algorithm can be analyzed this way:
     * We will have a total of N elements in the list. Each time we add one to the heap, it's logN. So it will be NLogN,
     * where N is total number of elements from all the lists.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode result = head;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((ListNode a, ListNode b) -> new Integer(a.val).compareTo(b.val));

        for (ListNode node : lists) {
            if (node != null)
                heap.add(node);
        }

        while (!heap.isEmpty()) {
            // pull off the smallest node and add to list
            ListNode node = heap.poll();
            head.next = node;
            head = head.next;

            if (node.next != null) {
                node = node.next;
                heap.add(node);
            }
        }

        result = result.next;
        return result;
    }
}
