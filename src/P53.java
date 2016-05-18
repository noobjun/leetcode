/**
 * Created by jun on 5/16/16.
 */
public class P53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;

        int result = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result = Math.max(result, sum);

            if (sum < 0) {
                sum = 0;
            }
        }

        return result;
    }
}
