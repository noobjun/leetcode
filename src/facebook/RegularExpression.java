package facebook;

import java.util.Arrays;

/**
 * Created by jun on 5/3/16.
 */
public class RegularExpression {

    public static void main(String[] args) {
        RegularExpression reg  =new RegularExpression();
        System.out.println(reg.isMatch("abc", "abc"));  // t
        System.out.println(reg.isMatch("abc", "ab+c")); // t
        System.out.println(reg.isMatch("abc", "ab*c")); // t
        System.out.println(reg.isMatch("abc", "a*b*c")); // t
        System.out.println(reg.isMatch("abc", "a+b*c")); // t
        System.out.println(reg.isMatch("abc", "a+b*cd*")); // t
        System.out.println(reg.isMatch("abc", "a+b*cd+")); // f
        System.out.println(reg.isMatch("abc", "a+b*c.+")); // f
        System.out.println(reg.isMatch("abc", "a+b*c.*")); // t
    }

    // the problem can contain +, *, .
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(dp, m - 1, n - 1, s, p);
    }

    public boolean helper(int[][] dp, int i, int j, String s, String p) {
        if (i == -1 && j == -1) {
            return true;
        } else if (i == -1) {
            if (p.charAt(j) != '*')
                return false;
            else
                return helper(dp, i, j - 2, s, p);
        } else if (j == -1) {
            return false;
        }

        if (dp[i][j] != -1)
            return dp[i][j] == 1;

        boolean result;

        if (p.charAt(j) == '*') {
            result = (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') && helper(dp, i - 1, j, s, p) || helper(dp, i, j - 2, s, p);
        } else if (p.charAt(j) == '+') {
            result = (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') && (helper(dp, i - 1, j - 2, s, p) || helper(dp, i - 1, j, s, p));
        } else if (p.charAt(j) == '.') {
            result = helper(dp, i - 1, j - 1, s, p);
        } else {
            result = s.charAt(i) == p.charAt(j) && helper(dp, i - 1, j - 1, s, p);
        }

        dp[i][j] = result ? 1 : 0;
        return result;
    }
}
