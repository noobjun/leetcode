import java.util.HashMap;
import java.util.Map;

/**
 * Created by jun on 12/23/15.
 * 76. Minimum Window Substring
 */
public class P76 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";

        String result = s;
        int counter = 0, left = 0, right = 0;
        int[] target = new int[58]; // This is because we want to use array instead of map, but problem has both a-z and A-Z
        int[] found = new int[58];

        for (char c : t.toCharArray())
            target[c - 'A']++;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (target[c - 'A'] > 0) {
                if (found[c - 'A'] < target[c - 'A'])
                    counter++;
                found[c - 'A']++;
            }

            if (counter == t.length()) {
                char cc = s.charAt(left);
                while (target[cc - 'A'] == 0 || target[cc - 'A'] < found[cc - 'A']) {
                    if (target[cc - 'A'] > 0 && target[cc - 'A'] < found[cc - 'A']) {
                        found[cc - 'A']--;
                    }
                    left++;
                    cc = s.charAt(left);
                }

                String window = s.substring(left, right);
                result = window.length() < result.length() ? window : result;

            }
        }

        if (counter < t.length())
            return "";
        else
            return result;
    }
}
