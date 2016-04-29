import java.util.HashMap;
import java.util.Map;

/**
 * Created by jun on 12/24/15.
 * 3. Longest Substring Without Repeating Characters
 */

public class P3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int result = 0;
        int left = 0, right = 0;
        Map<Character, Integer> prev = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            if (prev.containsKey(c)) {
                left = Math.max(prev.get(c) + 1, left);
            }
            prev.put(c, right);
            result = right - left + 1 > result ? right - left + 1 : result;
            right++;
        }

        return result;
    }
}
