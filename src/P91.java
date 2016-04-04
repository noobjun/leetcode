import java.util.HashMap;
import java.util.Map;

/**
 * Created by jun on 3/5/16.
 * 91. Decode Ways
 * <p>
 * Wow spent so much on this, nasty edge cases. Next time I should do this in dp.
 */
public class P91 {
    public int numDecodings(String s) {
        if (s.isEmpty())
            return 0;

        Map<String, Integer> map = new HashMap<>();
        return helper(s, map);
    }

    public int helper(String s, Map<String, Integer> map) {
        if (map.containsKey(s))
            return map.get(s);

        int result;
        int len = s.length();

        if (len > 0 && s.charAt(0) == '0') {
            result = 0;
        } else {
            if (len <= 1) {
                result = 1;
            } else {
                int first = s.charAt(0) - '0';
                int second = s.charAt(1) - '0';
                int num = first * 10 + second;

                if (num > 26) {
                    result = helper(s.substring(1), map);
                } else {
                    result = helper(s.substring(1), map) + helper(s.substring(2), map);
                }
            }
        }
        map.put(s, result);
        return result;
    }
}
