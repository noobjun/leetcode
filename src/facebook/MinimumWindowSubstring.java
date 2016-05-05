package facebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by jun on 5/3/16.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0)
            return "";

        int i = 0, j = 0, minLen = Integer.MAX_VALUE;
        String result = "";
        Set<Character> set = new HashSet<>();

        for (char ch : t.toCharArray())
            set.add(ch);
        int setSize = set.size();
        Map<Character, Integer> map = new HashMap<>();


        while (j < s.length()) {
            while (j < s.length() && map.size() < setSize) {
                char ch = s.charAt(j);
                if (set.contains(ch)) {
                    map.putIfAbsent(ch, 0);
                    map.put(ch, map.get(ch) + 1);
                }
                j++;
            }

            if (j == s.length() && map.size() < setSize)
                return "";


            while (i < j && map.size() >= setSize) {
                char ch = s.charAt(i);
                if (set.contains(ch)) {
                    map.put(ch, map.get(ch) - 1);
                    if (map.get(ch) == 0)
                        map.remove(ch);
                }
                i++;
            }

            if (j - i + 1 < minLen) {
                minLen = j - i + 1;
                result = s.substring(i - 1, j);
            }

        }
        return result;
    }
}
