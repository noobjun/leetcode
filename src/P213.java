import java.util.Arrays;

/**
 * Created by jun on 4/10/16.
 * 213. House Robber II
 */
public class P213 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        if (len == 1)
            return nums[0];

        int result;

        int[] dp = new int[len];

        // if we rob first
        dp[0] = nums[0];
        for (int i = 1; i < len - 1; i++)
            dp[i] = Math.max(dp[i - 1], i - 2 >= 0 ? dp[i - 2] + nums[i] : nums[i]);

        result = dp[len - 2];

        // if we don't rob first
        Arrays.fill(dp, 0);
        for (int i = 1; i < len; i++)
            dp[i] = Math.max(dp[i - 1], i - 2 >= 0 ? dp[i - 2] + nums[i] : nums[i]);

        result = Math.max(result, dp[len - 1]);
        return result;
    }
}
