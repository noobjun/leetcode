/**
 * Created by jun on 1/20/16.
 * 72. Edit Distance
 */
public class P72 {
    public int minDistance(String word1, String word2) {
        int a = word1.length();
        int b = word2.length();
        int[][] dp = new int[a][b];
        for (int i = 0; i < a; i++)
            for (int j = 0; j < b; j++)
                dp[i][j] = -1;

        return helper(dp, a - 1, b - 1, word1, word2);
    }

    public int helper(int[][] dp, int i, int j, String s1, String s2) {
        if (i == -1)
            return j + 1;
        if (j == -1)
            return i + 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        int result;

        if (s1.charAt(i) == s2.charAt(j)) {
            result = helper(dp, i - 1, j - 1, s1, s2);
        } else {
            int a = helper(dp, i - 1, j, s1, s2) + 1;
            int b = helper(dp, i, j - 1, s1, s2) + 1;
            int c = helper(dp, i - 1, j - 1, s1, s2) + 1;
            result = Math.min(Math.min(a, b), c);
        }

        dp[i][j] = result;
        return result;
    }
}
