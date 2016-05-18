import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by jun on 5/18/16.
 */
public class P239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k==0)
            return new int[]{};

        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);

            while (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.removeFirst();
            }

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
