package facebook;

import java.util.PriorityQueue;

/**
 * Created by jun on 5/17/16.
 */
public class MergedLinkedList {

    public static void main(String[] args) {
        Integer a = 5;
        Integer b = a;
        a = 6;
        System.out.println(a);
        System.out.println(b);
    }

    public static class ListNode {
        ListNode next;
        int val;
        public ListNode(int val){
            this.val = val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b)->Integer.compare(a.val, b.val));


        for (ListNode node :lists){
            if (node!=null)
                minHeap.add(node);
        }

        ListNode curr = new ListNode(-1);
        ListNode head = curr;

        while (!minHeap.isEmpty()){

            ListNode node = minHeap.poll();
            if (node.next!=null)
                minHeap.offer(node.next);
            curr.next = node;
            curr=curr.next;
        }

        return head.next;
    }
}
