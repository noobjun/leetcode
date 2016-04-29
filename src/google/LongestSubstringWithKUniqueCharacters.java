package google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by jun on 4/27/16.
 */
public class LongestSubstringWithKUniqueCharacters {

    public static void main(String[] args) {
        LongestSubstringWithKUniqueCharacters solution = new LongestSubstringWithKUniqueCharacters();
        System.out.println(solution.longestWithK("aabbcc", 1));
        System.out.println(solution.longestWithK("aabbcc", 2));
        System.out.println(solution.longestWithK("aabbcc", 3));
        System.out.println(solution.longestWithK("aasjssjssjaskeasjsjsasjsdj", 4));
        System.out.println(solution.longestWithK("aasjssjssjaskeasjsjsasjsdj", 3));
        System.out.println(solution.longestWithK("aasjssjssjaskeasjsjsasjsdj", 2));
    }

    public String longestWithK(String s, int k) {
        int i = 0;

        Map<Character, Integer> map = new HashMap<>();
        String result = "";

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            map.put(c, j);

            if (map.size() > k) {
                char gone = s.charAt(i);
                int idx = map.get(gone);
                map.remove(gone);
                i = idx + 1;
            }

            if (j - i + 1 >= result.length()) {
                result = s.substring(i, j + 1);
            }
        }

        return result;
    }
}
