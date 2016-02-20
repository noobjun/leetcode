import java.util.*;

/**
 * Created by jun on 2/19/16.
 * 249. Group Shifted Strings
 */

public class P249 {
    public List<List<String>> groupStrings(String[] strings) {
        Arrays.sort(strings);
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strings) {
            String key = "#"; // initialize to # so that for word with length 1, they share the key "#"
            for (int i = 0; i < word.length() - 1; i++) {
                char a = word.charAt(i);
                char b = word.charAt(i + 1);

                int distance = ((b - a) + 26) % 26;
                key += "#" + String.valueOf(distance);
            }
            if (!map.containsKey(key))
                map.put(key, new LinkedList<>());
            map.get(key).add(word);
        }

        List<List<String>> result = new LinkedList<>();
        result.addAll(map.values());

        return result;
    }
}
