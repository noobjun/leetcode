/**
 * Created by jun on 2/7/16.
 * 214. Shortest Palindrome
 */
public class P214 {
    public static void main(String[] args) {
        P214 p = new P214();
        System.out.println(p.shortestPalindrome("abb"));
        System.out.println(p.shortestPalindrome("aabb"));
    }

    public String shortestPalindrome(String s) {
        if (s.length() < 2)
            return s;

        int palinLength = findFromMid(s);
        String addon = "";
        for (int i = s.length() - 1; i > palinLength; i--) {
            addon += s.charAt(i);
        }

        return addon + s;
    }

    public int helper(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                dp[i][j] = false;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j + i - 1 < len; j++) {
                int x = j;
                int y = j + i - 1;
                dp[x][y] = s.charAt(x) == s.charAt(y) && (y - x < 2 || dp[x + 1][y - 1]);
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            if (dp[0][i])
                return i;
        }
        return 0;
    }

    public int longestPalindrome(String s) {
        int len = s.length();
        for (int k = len - 1; k >= 0; k--) {
            int i = 0;
            int j = k;

            while (i < j) {
                char a, b;
                a = s.charAt(i);
                b = s.charAt(j);
                if (a != b) {
                    break;
                }
                i++;
                j--;
            }

            if (i >= j) {
                return k;
            }
        }

        return 0;
    }

    public int findFromMid(String s) {
        int mid = (s.length() - 1) / 2;
        for (int i = mid; i >= 0; i--) {

            int j = i, k = i + 1;

            while (j >= 0 && k < s.length()) {
                char a = s.charAt(j);
                char b = s.charAt(k);
                if (a != b)
                    break;
                j--;
                k++;
            }

            if (j < 0)
                return i + 1;

            j = i - 1;
            k = i + 1;

            while (j >= 0) {
                char a = s.charAt(j);
                char b = s.charAt(k);
                if (a != b)
                    break;
                j--;
                k++;
            }

            if (j < 0)
                return i;

        }
        return 0;
    }
}
