import java.util.*;

/**
 * Created by jun on 2/22/16.
 * 18. 4Sum
 */
public class P18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int k = j + 1;
                int m = nums.length - 1;

                while (k < m) {
                    int a, b, c, d;
                    a = nums[i];
                    b = nums[j];
                    c = nums[k];
                    d = nums[m];

                    int sum = a + b + c + d;
                    if (sum == target) {
                        set.add(Arrays.asList(a, b, c, d));
                        k++;
                        m--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        m--;
                    }
                }
            }
        }

        List<List<Integer>> result = new LinkedList<>();
        result.addAll(set);
        return result;
    }
}
