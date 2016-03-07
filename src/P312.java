/**
 * Created by jun on 3/6/16.
 * 312. Burst Balloons
 * <p>
 * We maintain array dp[i][j], which means the max coin by popping all the balloons from i and j (inclusive)
 * So how to find dp[i][j]? Intuitively, we need to find out the max coins we get by popping each position LAST.
 * Let's define k where i<=k<=j. To pop position k last, it means we are doing arr[k]*arr[i-1]*arr[j+1] + dp[i][k-1] + dp[k+1][j]
 * After we have the dp formula, it's easy, we just loop from i to j for each k and do a max(k1, k2, ... kn).
 */
public class P312 {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        arr[0] = 1;
        arr[arr.length - 1] = 1;
        System.arraycopy(nums, 0, arr, 1, nums.length);
        int[][] dp = new int[arr.length][arr.length]; // default value is 0

        for (int len = 1; len <= nums.length; len++) {
            for (int left = 1; left + len - 1 <= nums.length; left++) {
                int right = left + len - 1;
                for (int k = left; k <= right; k++) {
                    dp[left][right] = Math.max(dp[left][right], dp[left][k - 1] + dp[k + 1][right] + arr[left - 1] * arr[k] * arr[right + 1]);
                }
            }
        }
        return dp[1][nums.length];
    }
}
