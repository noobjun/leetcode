import java.util.*;

/**
 * Created by jun on 2/19/16.
 * 243. Shortest Word Distance
 */
public class P243 {
    public int shortestDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!map.containsKey(word)) {
                map.put(word, new LinkedList<>());
            }

            List<Integer> list = map.get(word);
            list.add(i);
        }

        int result = Integer.MAX_VALUE;
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);


        for (int i = 0, j = 0; i < l1.size() && j < l2.size(); ) {
            result = Math.min(Math.abs(l1.get(i) - l2.get(j)), result);
            if (l1.get(i) < l2.get(j))
                i++;
            else
                j++;
        }

        return result;
    }
}
