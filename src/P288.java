import java.util.*;

/**
 * Created by jun on 3/20/16.
 * 288. Unique Word Abbreviation
 */
public class P288 {
    public class ValidWordAbbr {
        private Map<String, Set<String>> map;

        public ValidWordAbbr(String[] dictionary) {
            map = new HashMap<>();
            for (String word : dictionary) {
                String uniq = convert(word);
                if (!map.containsKey(uniq)) {
                    map.put(uniq, new HashSet<String>());
                }
                map.get(uniq).add(word);
            }
        }

        public boolean isUnique(String word) {
            String uniq = convert(word);
            return !map.containsKey(uniq) || map.get(uniq).size() == 1 && map.get(uniq).contains(word);
        }

        public String convert(String word) {
            int len = word.length();

            if (len <= 2)
                return word;
            else
                return word.charAt(0) + String.valueOf(len - 2) + word.charAt(len - 1);
        }
    }
}
