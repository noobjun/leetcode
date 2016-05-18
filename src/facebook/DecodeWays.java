package facebook;

import java.util.Arrays;

/**
 * Created by jun on 5/17/16.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s.isEmpty())
            return 0;

        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(s, 0, dp);
    }

    public int helper(String s, int index, int[] dp) {
        if (index == s.length())
            return 1;
        else if (s.charAt(index) == '0')
            return 0;
        else if (index == s.length() - 1)
            return 1;

        if (dp[index] != -1)
            return dp[index];

        int ten = s.charAt(index) - '0';
        int one = s.charAt(index + 1) - '0';
        int sum = ten * 10 + one;

        int ways = 0;
        ways += helper(s, index + 1, dp);
        if (sum <= 26)
            ways += helper(s, index + 2, dp);

        dp[index] = ways;
        return ways;
    }
}