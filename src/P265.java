/**
 * Created by jun on 4/6/16.
 * 265. Paint House II
 */
public class P265 {
    public int minCostII(int[][] costs) {
        int houses = costs.length;
        if (houses == 0)
            return 0;
        int colors = costs[0].length;

        int[][] dp = new int[houses][colors];
        for (int i = 0; i < colors; i++)
            dp[0][i] = costs[0][i];

        for (int i = 1; i < houses; i++) {
            for (int j = 0; j < colors; j++) {
                int cost = Integer.MAX_VALUE;
                for (int k = 0; k < colors; k++) {
                    if (j == k)
                        continue;
                    cost = Math.min(cost, dp[i - 1][k] + costs[i][j]);
                }
                dp[i][j] = cost;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < colors; i++)
            result = Math.min(result, dp[houses - 1][i]);

        return result;
    }
}
