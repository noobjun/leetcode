package facebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by jun on 5/3/16.
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring substring = new MinimumWindowSubstring();
        String res = substring.minWindow("ab", "a");
        System.out.println(res);
    }

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0)
            return "";

        int left = 0, right = 0;
        String result = s;

        int[] found = new int[256];
        int[] target = new int[256];
        for (char ch : t.toCharArray())
            target[ch - 'A']++;
        int count = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            if (target[ch - 'A'] == 0)
                continue;

            found[ch - 'A']++;
            if (found[ch - 'A'] <= target[ch - 'A'])
                count++;

            if (count == t.length()) {
                while (target[s.charAt(left) - 'A'] == 0 || found[s.charAt(left) - 'A'] > target[s.charAt(left) - 'A']) {
                    found[s.charAt(left) - 'A']--;
                    left++;
                }


                String candidate = s.substring(left, right);
                if (result.length() > candidate.length())
                    result = candidate;

            }
        }

        return count < t.length() ? "" : result;
    }
}
