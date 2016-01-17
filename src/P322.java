/**
 * Created by jun on 1/16/16.
 * 322. Coin Change
 */
public class P322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++)
            dp[i] = Integer.MAX_VALUE - 1; // needs to be 0xfffffffe to take care of integer overflow

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i + coins[j] <= amount)
                    dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1); // if it's Integer.MAX_VALUE, then dp[i] + 1 would be the smallest Integer, and it would get assigned to dp array because of Math.min
            }
        }

        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }

}
