/**
 * Created by jun on 2/6/16.
 * 5. Longest Palindromic Substring
 */
public class P5 {
    public static void main(String[] args) {
        P5 p = new P5();
        System.out.println("a");
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                dp[i][j] = false;

        int max = 0;
        int start = 0;
        int end = len - 1;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j + i - 1 < len; j++) {
                int x = j;
                int y = j + i - 1;

                dp[x][y] = s.charAt(x) == s.charAt(y) && (y - x < 2 || dp[x + 1][y - 1]);

                if (dp[x][y] && y - x > max) {
                    max = y - x;
                    start = x;
                    end = y;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
