import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by jun on 2/1/16.
 * 325. Maximum Size Subarray Sum Equals k
 */
public class P325 {
    public static void main(String[] args) {
        P325 p = new P325();
        int a = p.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3);
        System.out.println(a);
    }

    public int maxSubArrayLen(int[] nums, int k) {
        int[] sums = new int[nums.length + 1];
        int current = 0;
        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
            current += nums[i - 1];
            sums[i] = current;
        }
        Map<Integer, Integer> map = new HashMap<>();
        // [a.......b] , and k
        // b-a = k , so b = a+k
        int result = 0;
        for (int i = 0; i < sums.length; i++) {
            if (map.containsKey(sums[i])) {
                result = Math.max(result, i - map.get(sums[i]));
            }
            int match = sums[i] + k;
            if (!map.containsKey(match))
                map.put(match, i);
        }
        return result;
    }

}
