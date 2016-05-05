package facebook;

/**
 * Created by jun on 5/2/16.
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;

        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int result = 1;

        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--)
                dp[i] = Math.max(dp[i], nums[i] > nums[j] ? dp[j] + 1 : 1);
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
