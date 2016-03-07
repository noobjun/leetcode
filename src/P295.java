import java.util.PriorityQueue;

/**
 * Created by jun on 3/6/16.
 * 295. Find Median from Data Stream
 * <p>
 * We maintain two heaps, one min heap and one max heap, we maintain two heaps to as same size (more precisely, their size won't differ by more than 1 at any time).
 * <p>
 * ACTUALLY, FUCK THIS.
 * I read a much simpler solution, we just simply add num into the left heap, and then we while (left.size>right.size) then move element from left to right. This allows us to not check many conditions.
 * NEXT TIME, IMPROVE THIS SOLUTION.
 */
public class P295 {
    public class MedianFinder {
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b.compareTo(a))); // to the left of the number
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (a.compareTo(b))); // to the right of the number

        // Adds a number into the data structure.
        public void addNum(int num) {
            if (maxHeap.isEmpty() && minHeap.isEmpty()) {
                maxHeap.add(num);
            } else if (maxHeap.isEmpty() || minHeap.isEmpty()) {
                int prev = maxHeap.isEmpty() ? minHeap.poll() : maxHeap.poll();
                if (num < prev) {
                    maxHeap.add(num);
                    minHeap.add(prev);
                } else {
                    maxHeap.add(prev);
                    minHeap.add(num);
                }
            } else {
                int small = maxHeap.peek();
                int big = minHeap.peek();

                if (small <= num && num <= big) {
                    if (maxHeap.size() < minHeap.size())
                        maxHeap.add(num);
                    else
                        minHeap.add(num);
                } else if (num < small) {
                    if (maxHeap.size() < minHeap.size()) {
                        maxHeap.add(num);
                    } else {
                        minHeap.add(maxHeap.poll());
                        maxHeap.add(num);
                    }
                } else { // num > big
                    if (maxHeap.size() < minHeap.size()) {
                        maxHeap.add(minHeap.poll());
                        minHeap.add(num);
                    } else {
                        minHeap.add(num);
                    }
                }
            }
        }

        // Returns the median of current data stream
        public double findMedian() {
            if (minHeap.size() == maxHeap.size())
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            else if (minHeap.size() < maxHeap.size())
                return maxHeap.peek();
            else
                return minHeap.peek();
        }

    }
}
