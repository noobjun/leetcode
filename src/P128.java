import java.util.HashSet;
import java.util.Set;

/**
 * Created by jun on 2/28/16.
 * 128. Longest Consecutive Sequence
 * <p>
 * This problem resembles Union Find algorithm. We first put all the numbers into a set. While iterating through the array,
 * we query if the set contains a number to the left and similarly to the right. If contains, we remove that number from
 * the set. We keep doing it until reaches left or right boundary is reached. VERY SMART INDEED!
 */
public class P128 {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int n : nums)
            set.add(n);

        int result = 0;

        for (int n : nums) {
            if (!set.contains(n))
                continue;

            set.remove(n);
            int count = 1;
            int left = n - 1;
            int right = n + 1;

            while (set.contains(left)) {
                set.remove(left);
                count++;
                left--;
            }

            while (set.contains(right)) {
                set.remove(right);
                count++;
                right++;
            }

            result = Math.max(result, count);
        }

        return result;
    }
}
