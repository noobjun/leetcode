import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by jun on 3/2/16.
 * 159. Longest Substring with At Most Two Distinct Characters
 */
public class P159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int leftIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (!map.containsKey(letter) && map.size() == 2) {
                Iterator<Character> iterator = map.keySet().iterator();
                char k1 = iterator.next();
                char k2 = iterator.next();
                int v1 = map.get(k1);
                int v2 = map.get(k2);
                if (v1 < v2) {
                    map.remove(k1);
                } else {
                    map.remove(k2);
                }
                leftIndex = v1 < v2 ? v1 + 1 : v2 + 1;
            }
            map.put(letter, i);
            result = Math.max(result, i - leftIndex + 1);
        }

        return result;
    }
}
