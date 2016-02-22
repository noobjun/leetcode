import java.util.Arrays;

/**
 * Created by jun on 2/22/16.
 * 16. 3Sum Closest
 */
public class P16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int a = nums[i], b = nums[j], c = nums[k];
                int sum = a + b + c;
                result = Math.abs(target - sum) < Math.abs(target - result) ? sum : result;

                if (sum == target)
                    return target;
                else if (sum < target)
                    j++;
                else
                    k--;
            }
        }

        return result;
    }
}
