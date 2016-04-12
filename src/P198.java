/**
 * Created by jun on 4/10/16.
 * 198. House Robber
 */
public class P198 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;

        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++)
            dp[i] = Math.max(dp[i - 1], i >= 2 ? dp[i - 2] + nums[i] : nums[i]);

        return dp[len - 1];
    }
}
