package facebook;

/**
 * Created by jun on 5/16/16.
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome p = new LongestPalindrome();
        p.longestPalindrome("bb");
    }
    public String longestPalindrome(String s) {
        if (s==null || s.length()==0)
            return "";

        int len = s.length();

        int maxLen = 1;
        boolean[][] dp = new boolean[len][len];

        int start =0;
        int end = 0;

        for (int i = 2; i <= len; i++) {
            for (int j = 0; j + i - 1 < len; j++) {
                int left = j + 1;
                int right = j + i - 2;

                if (s.charAt(j) == s.charAt(j + i - 1) && (left >= right || dp[left][right])) {
                    dp[j][j+i-1] = true;
                    if (i > maxLen){
                        maxLen = i;
                        start = j;
                        end = j+i-1;
                    }

                }
            }
        }

        return s.substring(start, end+1);
    }
}
