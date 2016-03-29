import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by jun on 3/23/16.
 * 253. Meeting Rooms II
 */
public class P253 {
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> new Integer(a.start).compareTo(b.start));
        PriorityQueue<Interval> heap = new PriorityQueue<>((a, b) -> new Integer(a.end).compareTo(b.end));

        for (Interval interval : intervals) {
            if (heap.isEmpty()) {
                heap.add(interval);
            } else {
                Interval earlier = heap.peek();
                if (interval.start >= earlier.end) {
                    heap.poll();
                }
                heap.offer(interval);
            }
        }

        return heap.size();
    }
}
