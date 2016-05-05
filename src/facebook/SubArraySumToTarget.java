package facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jun on 5/2/16.
 */
public class SubArraySumToTarget {
    public int maxSubArrayLen(int[] nums, int k) {
        int len = nums.length;
        int[] sums = new int[len];
        int curr = 0;
        for (int i = 0; i < len; i++) {
            sums[i] = curr + nums[i];
            curr = sums[i];
        }

        Map<Integer, Integer> map = new HashMap<>();

        int result = 0;
        for (int i = 0; i < len; i++) {
            if (sums[i] == k) {
                result = Math.max(result, i + 1);
            }
            if (map.containsKey(sums[i] - k)) {
                result = Math.max(result, i - map.get(sums[i] - k));
            }

            if (!map.containsKey(sums[i]))
                map.put(sums[i], i);
        }

        return result;
    }
}
