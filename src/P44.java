import com.sun.tools.classfile.Annotation;

/**
 * Created by jun on 4/25/16.
 * 44. Wildcard Matching
 * <p>
 * Somehow when I use recursion with memoization, memory limit exceeded. Ha!
 * <p>
 * The greedy solution is tricky. In particular, it needs to track "match", in order to rewind i pointer, otherwise it
 * can fail for test cases such as:
 * aabcdfgh
 * *abd*h
 */
public class P44 {
    public static void main(String[] args) {
        P44 p = new P44();
        System.out.println(p.isMatch("hi", "*?")); // f
    }


    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, match = 0, star = -1;

        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                star = j;
                match = i; // only record the match when we see stars in the sky
                j++;
            } else if (star != -1) {
                j = star + 1;
                match++;
                i = match;
            } else {
                return false;
            }
        }

        while (j < p.length() && p.charAt(j) == '*') j++;
        return j == p.length();
    }


// My recursion takes O(mn) space, exceeds OJ memory limit.
//    public boolean isMatch(String s, String p) {
//        int[][] dp = new int[s.length()][p.length()];
//        for (int i =0; i<s.length(); i++)
//            for (int j =0; j<p.length(); j++)
//                dp[i][j] = -1;
//        return helper(s, p, s.length()-1, p.length()-1, dp);
//
//    }
//
//    public boolean helper(String s, String p, int i, int j, int[][] dp) {
//        if (i == -1 && j == -1)
//            return true;
//        else if (i == -1) {
//            if (p.charAt(j) == '?' || p.charAt(j) == '*')
//                return helper(s, p, i, j - 1, dp);
//            else
//                return false;
//        } else if (j == -1)
//            return false;
//
//        if (dp[i][j] != -1)
//            return dp[i][j] == 1;
//
//        boolean result = false;
//        if (p.charAt(j) == '*')
//            result = helper(s, p, i - 1, j, dp) || helper(s, p, i, j - 1, dp);
//        else if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))
//            result = helper(s, p, i - 1, j - 1, dp);
//
//        dp[i][j] = result ? 1 : 0;
//        return result;
//    }
}
