/**
 * Created by jun on 2/21/16.
 * 10. Regular Expression Matching
 */
public class P10 {
    /*
    The key to solve this problem is similar to edit distance problem, where we want to have a 2d array as dynamic programming array.
    Then we start from right side, there can be several cases:
        1. if the pattern is a .(dot), it matches any one character from text
        2. if the pattern is a *(asterisk), it can match zero, one or more patterns from text.
        3. else, just do simple matching by comparing character
     */

    public boolean isMatch(String s, String p) {
        int r = s.length();
        int c = p.length();
        int[][] dp = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                dp[i][j] = -1;

        return helper(s, p, dp, r - 1, c - 1);
    }

    public boolean helper(String s, String p, int[][] dp, int i, int j) {
        if (i < 0 && j < 0)
            return true;
        else if (j < 0)
            return false;
        else if (i < 0)  // We cannot have if i==-1 return false, because s could be "" and p can be ".*"
            return p.charAt(j) == '*' && helper(s, p, dp, i, j - 2);

        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        } else {
            if (p.charAt(j) == '.') {
                return helper(s, p, dp, i - 1, j - 1);
            } else if (p.charAt(j) == '*') {
                // from zeroMatch and oneOrMoreMatch, we can recursively match other occurrences too
                boolean zeroMatch = helper(s, p, dp, i, j - 2);
                boolean oneOrMoreMatch = (p.charAt(j - 1) == '.' || s.charAt(i) == p.charAt(j - 1)) &&
                        (helper(s, p, dp, i - 1, j - 2) /*one match*/ || helper(s, p, dp, i - 1, j)/*multiple match*/);
                return zeroMatch || oneOrMoreMatch;
            } else {
                return s.charAt(i) == p.charAt(j) && helper(s, p, dp, i - 1, j - 1);
            }
        }
    }
}
