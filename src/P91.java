/**
 * Created by jun on 3/5/16.
 * 91. Decode Ways
 */
public class P91 {

    public int numDecodings(String s) {
        if (s.isEmpty())
            return 0;

        for (int i = 0; i < s.length(); i++)
            if (i == 0 && s.charAt(i) == '0' || s.charAt(i) == '0' && s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2')
                return 0;

        int[] dp = new int[s.length()];
        for (int i = 0; i < dp.length; i++)
            dp[i] = -1;

        return helper(s, 0, dp);
    }

    public int helper(String s, int index, int[] dp) {
        int len = s.length();
        if (index >= len - 1)
            return 1;

        if (dp[index] != -1)
            return dp[index];

        int result;
        char current = s.charAt(index);
        char next = s.charAt(index + 1);

        if (next == '0') {
            result = helper(s, index + 2, dp);
        } else {
            if (Integer.valueOf("" + current + next) <= 26)
                result = helper(s, index + 1, dp) + helper(s, index + 2, dp);
            else
                result = helper(s, index + 1, dp);
        }

        dp[index] = result;
        return result;
    }
}
